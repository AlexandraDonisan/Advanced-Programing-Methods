using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    class CompStmt :IStmt
    {
        private IStmt first;
        private IStmt snd;

        public CompStmt(IStmt first, IStmt snd)
        {
            this.first = first;
            this.snd = snd;
        }

        public PrgState execute(PrgState state)
        {
            MyIStack<IStmt> stk = state.getStk();
            stk.push(snd);
            stk.push(first);
            return state;
        }
        
        public override string ToString()
        {
            return first +"; " + snd;
        }
}
}
