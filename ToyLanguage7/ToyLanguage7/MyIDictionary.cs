using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    interface MyIDictionary<K,V>
    {
        bool isDefined(K id);
        void update(K id, V val);
        void add(K id, V val);
        V lookup(K id);
        int size();
        void remove(K key);
        bool isEmpty();
        V get(K key);

    }
}
