using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    class MyException :Exception
    {
        private String message;
        public MyException(string message) : base(message) { }
    }
}
