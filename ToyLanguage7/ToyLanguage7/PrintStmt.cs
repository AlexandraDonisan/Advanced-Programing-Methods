using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    class PrintStmt : IStmt
    {
        private Exp exp;

        public PrintStmt(Exp exp)
        {
            this.exp = exp;
        }

        public PrgState execute(PrgState state)
        {
            MyIList<int> list = state.getOut();
            MyIDictionary<string, int> dict = state.getSymTable();
            try
            {
                list.add(exp.eval(dict));
            }
            catch (MyException ex)
            {
                throw new MyException("" + ex);
            }
            return state;
        }

        public override string ToString()
        {
            return "Print(" + exp.ToString() + ")";
        }
    }
}
