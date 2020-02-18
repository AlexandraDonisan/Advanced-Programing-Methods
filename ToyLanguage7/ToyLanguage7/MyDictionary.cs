using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    class MyDictionary<K, V> : MyIDictionary<K,V>
    {
        private Dictionary<K, V> dict;

        public MyDictionary() { this.dict = new Dictionary<K,V>(); }

        public void add(K id, V val)
        {
            dict.Add(id,val);
        }

        public V get(K key)
        {
            return dict[key];
        }

        public bool isDefined(K id)
        {
            return dict.ContainsKey(id);
        }

        public bool isEmpty()
        {
            return dict.Count()==0;
        }

        public V lookup(K id)
        {
            if (isDefined(id))
                return get(id);
            else
            {
                throw new MyException("variable " + id +" is not defined");
            }
        }

        public void remove(K key)
        {
            dict.Remove(key);
        }

        public int size()
        {
            return dict.Count();
        }

        public void update(K id, V val)
        {
            dict[id] = val;
        }

        public override string ToString()
        {
            string result = "";
            foreach(var el in this.dict)
                result+=el+",";
            //result = result.Remove(result.Length - 1, 1);
            return result;
        }
    }
}
