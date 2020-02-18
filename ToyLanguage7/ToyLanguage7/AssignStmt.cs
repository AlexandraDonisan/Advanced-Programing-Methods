using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    class AssignStmt : IStmt
    {
        private String id;
        private Exp exp;

        public AssignStmt(String id, Exp exp)
        {
            this.id = id;
            this.exp = exp;
        }

        public PrgState execute(PrgState state)
        {
            MyIDictionary<string,int> symTbl = state.getSymTable();
            try {
                int val = exp.eval(symTbl);
                if(symTbl.isDefined(id)) {
                    symTbl.update(id, val);
                }
                else
                {
                    symTbl.add(id, val);
                }
            }
            catch(MyException ex){
                throw new MyException(""+ex);
            }

            return state;
        }
        
        public override string ToString()
        {
            return id + "=" + exp;
        }
    }
}
