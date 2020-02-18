using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    class KeyGenerator
    {
        private int key;

        public KeyGenerator() { this.key = 0; }

        public int getGeneratedKey() {
            this.key += 1;
            return this.key;
        }
       
    }
}
