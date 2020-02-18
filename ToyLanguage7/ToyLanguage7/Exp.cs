using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    abstract class Exp
    {
        public abstract int eval(MyIDictionary<string, int> tbl);
    }
}
