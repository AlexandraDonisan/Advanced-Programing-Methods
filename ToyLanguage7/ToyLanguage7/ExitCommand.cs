using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    class ExitCommand : Command
    {
        public ExitCommand(String key, String description): base(key, description){}

        public override void execute()
        {
            System.Environment.Exit(1);
        }
    }
}
