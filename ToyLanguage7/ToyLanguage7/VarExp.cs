using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    class VarExp : Exp
    {
        private String id;

        public VarExp(String id)
        {
            this.id = id;
        }


        public override int eval(MyIDictionary<string, int> tbl)
        {
            try
            {
                return tbl.lookup(id);
            }
            catch (MyException ex)
            {
                throw new MyException("" + ex);
            }
        }

        public override string ToString()
        {
            return id;
        }
    }
}
