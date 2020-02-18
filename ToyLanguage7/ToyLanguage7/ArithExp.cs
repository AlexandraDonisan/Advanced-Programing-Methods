using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    class ArithExp : Exp
    {
        private Exp e1;
        private Exp e2;
        private int op;

        public ArithExp(int op, Exp e1, Exp e2)
        {
            this.e1 = e1;
            this.e2 = e2;
            this.op = op;
        }

        public override int eval(MyIDictionary<string, int> tbl)
        {
            if (op == 1) return (e1.eval(tbl) + e2.eval(tbl));
            else if (op == 2) return (e1.eval(tbl) - e2.eval(tbl));
            else if (op == 3) return (e1.eval(tbl) * e2.eval(tbl));
            else if (op == 4)
            {
                if (e2.eval(tbl) == 0)
                    throw new MyException("Division by 0!!!");
                return (e1.eval(tbl) / e2.eval(tbl));
            }
            return (e1.eval(tbl) + e2.eval(tbl)); //CAUTION HERE
        }

        public String operation(int o)
        {
            String res = "";
            if (o == 1)
                res += "+";
            else if (o == 2)
                res += "-";
            else if (o == 3)
                res += "*";
            else if (o == 4)
                res += "/";
            return res;
        }
        
        public override string ToString()
        {
            return e1 + operation(op) + e2; 
        }
    }
}
