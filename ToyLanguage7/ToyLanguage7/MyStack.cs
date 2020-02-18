using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    class MyStack<T> : MyIStack<T>
    {
        private List<T> stack;

        public MyStack() { this.stack = new List<T>(); }

        public bool isEmpty()
        {
            return stack.Count()==0;
        }

        public T pop()
        {
            if (!isEmpty())
            {
                T getTop = this.stack[size() - 1];
                stack.RemoveAt(size() - 1);
                return getTop;
            }
            else
                throw new MyException("Empty stack!");
        }

        public void push(T v)
        {
            stack.Add(v);
        }

        public int size()
        {
            return stack.Count();
        }

        public override string ToString()
        {
            string result = "[";
            List<T> newStack = this.stack;
            newStack.Reverse();
            foreach (var el in newStack)
                result += el + " ";
            result += "]";
            //result = result.Remove(result.Length - 1, 1);
            return result;
        }
    }
}
