using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ToyLanguage7
{
    class TextMenu
    {
        private Dictionary<String, Command> commands;

        public TextMenu()
        {
            commands = new Dictionary<String, Command>();
        }
        public void addCommand(Command c)
        {
            commands.Add(c.getKey(), c);
        }
        private void printMenu()
        {
            foreach (Command com in commands.Values)
            {
                String line = String.Format("{0} {1}", com.getKey(), com.getDescription());
                Console.WriteLine(line);
            }
        }
        public void show()
        {
            while (true)
            {
                printMenu();
                Console.WriteLine("Input the option: ");
                String key = Console.ReadLine();
                Command com = commands[key];
                if (com == null)
                {
                    Console.WriteLine("Invalid option!");
                    continue;
                }
                com.execute();
            }
        }
    }
}
