using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using System;

namespace ToyLanguage7
{
    class Repository : IRepository
    {
        private PrgState prg;
        private String logFilePath;

        public Repository(PrgState prg, String logFilePath)
        {
            this.prg = prg;
            this.logFilePath = logFilePath;
        }

        public void clearData()
        {
            try
            {
                FileStream fs = new FileStream(logFilePath,FileMode.Create);
                string s = "";
                UnicodeEncoding unienc = new UnicodeEncoding();
                fs.Write(unienc.GetBytes(s),0, unienc.GetByteCount(s));
                fs.Close();
            }
            catch (IOException e)
            {
                throw new MyException("" + e);
            }
        }

        public PrgState getCtrPrg()
        {
            return prg;
        }

        public void logPrgStateExec()
        {
            FileStream fs = new FileStream(logFilePath, FileMode.Append);
            try
            {
                string s = prg.ToString();
                UnicodeEncoding unienc = new UnicodeEncoding();
                fs.Write(unienc.GetBytes(s), 0, unienc.GetByteCount(s));
                fs.Close();
                /*
                logFile = new PrintWriter(new StreamWriter(new FileWriter(logFilePath, true)));
                logFile.println("ExeStack:");
                logFile.println("\t" + prg.getStk().toString());
                logFile.println("SymTable:");
                logFile.println("\t" + prg.getSymTable().toString());
                logFile.println("Out:");
                logFile.println("\t" + prg.getOut().toString());
                logFile.println("FileTable:");
                logFile.println("\t" + prg.getFileTable().toString());
                logFile.println();*/
            }
            catch (IOException e)
            {
                new MyException("" + e);
            }
        }

        public override string ToString()
        {
            return "Repository{" +
                    "prg=" + prg +
                    '}';
        }
    }
}
