using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace ToyLanguage7
{
    class OpenRFile : IStmt
    {
        private string var_file_id;
        private string filename;
        private KeyGenerator key;

        public OpenRFile(string var_file_id, string filename,KeyGenerator key)
        {
            this.var_file_id = var_file_id;
            this.filename = filename;
            this.key = key;
        
        }

        public PrgState execute(PrgState state)
        {
            MyIFileDictionary<int, KeyValuePair<string, StreamReader>> dict = state.getFileTable();
            try
            {
                for (int i = 0; i < dict.size(); i++)
                {
                    if (dict.lookup(i).Key==filename)
                        throw new MyException("Filename already exists!");
                }
                StreamReader br = null;
                FileStream fr = null;
                try
                {
                    fr = new FileStream(filename, FileMode.Open);
                    br = new StreamReader(fr);
                    KeyValuePair<string, StreamReader> p = new KeyValuePair<string, StreamReader>(filename, br);
                    int uniqKey = this.key.getGeneratedKey();
                    dict.add(uniqKey,p);
                    //int lastKey = dict.getKey();
                    MyIDictionary<string, int> symTbl = state.getSymTable();
                    symTbl.add(var_file_id, uniqKey);
                }
                catch (IOException e)
                {
                    throw new IOException(e.ToString());
                }
            }
            catch (MyException ex)
            {
                throw new MyException("" + ex);
            }
            return state;
        }

        public override string ToString()
        {
            return "OpenFile(" +
                    var_file_id +
                    "," + '\"' + filename + '\"' + ")";
        }
    }
}
