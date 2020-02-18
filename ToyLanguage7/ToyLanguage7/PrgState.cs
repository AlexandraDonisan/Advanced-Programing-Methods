using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace ToyLanguage7
{
    class PrgState
    {
        private MyIStack<IStmt> exeStack;
        private MyIDictionary<string, int> symTable;
        private MyIList<int> output;
        private MyIFileDictionary<int, KeyValuePair<string, StreamReader>> fileTable;

        public PrgState(MyIStack<IStmt> exeStack, MyIDictionary<string, int> symTable, MyIList<int> output, MyIFileDictionary<int, KeyValuePair<string, StreamReader>> fileTable, IStmt prg)
        {
            this.exeStack = exeStack;
            this.symTable = symTable;
            this.output = output;
            this.fileTable = fileTable;
            exeStack.push(prg);
        }

        public MyIDictionary<string, int> getSymTable()
        {
            return symTable;
        }

        public MyIList<int> getOut()
        {
            return output;
        }

        public MyIStack<IStmt> getStk()
        {
            return exeStack;
        }

        public MyIFileDictionary<int, KeyValuePair<string, StreamReader>> getFileTable()
        {
            return fileTable;
        }

        public void setOut(MyIList<int> output)
        {
            this.output = output;
        }

        public override string ToString()
        {
            return "PrgState{" + Environment.NewLine + 
                "exeStack=" + exeStack +
                ","+Environment.NewLine+ "symTable =" + symTable +
                "," + Environment.NewLine + "out= " + output +
                "," + Environment.NewLine + "fileTable=" + fileTable +
                "}"+ Environment.NewLine;
        }

    }
}
