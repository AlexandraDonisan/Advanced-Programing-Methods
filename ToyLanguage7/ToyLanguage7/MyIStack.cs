using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    interface MyIStack<T>
    {
        T pop();
        void push(T v);
        bool isEmpty();
        int size();
    }
}
