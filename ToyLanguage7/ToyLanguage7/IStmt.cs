using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    interface IStmt
    {
        PrgState execute(PrgState state);
    }
}
