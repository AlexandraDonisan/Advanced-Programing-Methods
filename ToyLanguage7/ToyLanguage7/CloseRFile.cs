using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace ToyLanguage7
{
    class CloseRFile : IStmt
    {
        private Exp exp_file_id;

        public CloseRFile(Exp exp_file_id)
        {
            this.exp_file_id = exp_file_id;
        }


        public PrgState execute(PrgState state)
        {
            MyIDictionary<string, int> symTbl = state.getSymTable();
            MyIFileDictionary<int, KeyValuePair<string, StreamReader>> fileTable = state.getFileTable();
            try
            {
                int val = exp_file_id.eval(symTbl);
                KeyValuePair<string, StreamReader> p = fileTable.lookup(val);
                StreamReader br = p.Value;
                br.Close();
                fileTable.remove(val); //not Sure
            }
            catch (MyException ex)
            {
                throw new MyException("" + ex);
            }

            return state;
        }

        public override string ToString()
        {
            return "closeRFile(" + exp_file_id + ')';
        }
    }
}
