using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    class RunExample : Command
    {
        private Controller ctrl;

        public RunExample(String key, String description, Controller ctrl) : base(key, description)
        {
            this.ctrl = ctrl;
        }

        public override void execute()
        {
            try
            {
                ctrl.allStep();
            }
            catch (Exception ex) //CAUTION HERE
            {
                Console.WriteLine("Error: " + ex);
            }
        }
    }
}
