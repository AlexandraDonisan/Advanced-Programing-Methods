using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    class ConstExp : Exp
    {
        private int number;

        public ConstExp(int number)
        {
            this.number = number;
        }

        public override int eval(MyIDictionary<String, int> tbl) { return number; }
        
        public override string ToString()
        {
            return number.ToString();
        }

    }
}
