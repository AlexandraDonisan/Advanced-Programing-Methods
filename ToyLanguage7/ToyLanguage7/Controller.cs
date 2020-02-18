using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    class Controller
    {
        private IRepository repo;

        public Controller(IRepository repo)
        {
            this.repo = repo;
        }

        private PrgState oneStep(PrgState state)
        {
            MyIStack<IStmt> stk = state.getStk();
            if(stk.isEmpty())throw new MyStmtExecException("The stack is empty");
            IStmt crtStmt = stk.pop();
            try {
                return crtStmt.execute(state);
            }
            catch(MyException ex)
            {
                throw new MyStmtExecException(""+ex);
            }
        }

        public void allStep()
        {
            PrgState prg = repo.getCtrPrg();
            repo.clearData();
            while (!prg.getStk().isEmpty())
            {
                try
                {
                    oneStep(prg);
                    repo.logPrgStateExec();
                }
                catch (MyStmtExecException e)
                {
                    Console.WriteLine("Exception is : " + e);
                }
                    Console.WriteLine(prg.ToString());
            }
        }
    }
}
