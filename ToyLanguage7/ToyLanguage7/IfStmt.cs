using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    class IfStmt : IStmt
    {
        private Exp exp;
        private IStmt thenS;
        private IStmt elseS;

        public IfStmt(Exp exp, IStmt thenS, IStmt elseS)
        {
            this.exp = exp;
            this.thenS = thenS;
            this.elseS = elseS;
        }
        public PrgState execute(PrgState state)
        {
            MyIDictionary<string, int> dict = state.getSymTable();
            MyIStack<IStmt> stk = state.getStk();
            try
            {
                if (exp.eval(dict) != 0)
                {
                    stk.push(thenS);
                }
                else
                {
                    stk.push(elseS);
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
            return "IF " + exp +
                    " THEN " + thenS +
                    " ELSE " + elseS;

        }
    }
}
