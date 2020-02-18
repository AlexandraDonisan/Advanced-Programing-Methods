using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    interface IRepository
    {
        PrgState getCtrPrg();
        void logPrgStateExec();
        void clearData();
    }
}
