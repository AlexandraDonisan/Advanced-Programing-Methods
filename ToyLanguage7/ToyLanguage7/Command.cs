using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    abstract class Command
    {
        private String key, description;

        public Command(String key, String description)
        {
            this.key = key;
            this.description = description;
        }

        public abstract void execute();

        public string getKey()
        {
            return key;
        }

        public string getDescription()
        {
            return description;
        }
    }
}
