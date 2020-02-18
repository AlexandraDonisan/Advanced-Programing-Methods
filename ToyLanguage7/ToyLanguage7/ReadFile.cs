using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace ToyLanguage7
{
    class ReadFile : IStmt
    {
        private Exp exp_file_id;
        private String var_name;

        public ReadFile(Exp exp_file_id, String var_name)
        {
            this.exp_file_id = exp_file_id;
            this.var_name = var_name;
        }

        public PrgState execute(PrgState state)
        {
            MyIDictionary<string, int> symTbl = state.getSymTable();
            MyIFileDictionary<int, KeyValuePair<string, StreamReader>> fileTable = state.getFileTable();
            try
            {
                int val = exp_file_id.eval(symTbl);
                fileTable.lookup(val);
                StreamReader br = fileTable.get(val).Value;
                String line = br.ReadLine();

                int value, x;
                if (line == null)
                    value = 0;
                else
                    value = int.Parse(line);

                if (symTbl.isDefined(var_name))
                    symTbl.update(var_name, value);
                else
                    symTbl.add(var_name, value);
            }
            catch (MyException e)
            {
                throw new MyException("" + e);
            }
            return state;
        }

        public override string ToString()
        {
            return "ReadFile(" +
                    exp_file_id +
                    ", \"" + var_name + '\"' + ")";
        }
    }
}
