using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    class MyStmtExecException :Exception
    {
        String message;

        public MyStmtExecException(String message):base(message)
        {
        }

    }
}
