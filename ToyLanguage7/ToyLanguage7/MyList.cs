using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    class MyList<T> : MyIList<T>
    {
        private List<T> list;

        public MyList() { this.list = new List<T>(); }

        public void add(T elem)
        {
            list.Add(elem);
        }

        public bool isEmpty()
        {
            return list.Count() == 0;
        }
        
        public int size()
        {
            return list.Count();
        }

        public override string ToString()
        {
            string result = "[";
            foreach (var el in this.list)
                result += el + " ";
            //result = result.Remove(result.Length - 1, 1);
            result += "]";
            return result;
        }
    }
}
