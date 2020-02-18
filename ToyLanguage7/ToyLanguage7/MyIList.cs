using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    interface MyIList<T>
    {
        void add(T elem);
        int size();
        bool isEmpty();
    }
}
