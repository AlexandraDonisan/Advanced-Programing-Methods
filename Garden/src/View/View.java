package View;

import Controller.Controller;
import Model.AppleTree;
import Model.CherryTree;
import Model.FruitTrees;
import Model.PearTree;
import Repository.Repo;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private static void printMenu()
    {
        System.out.println("Possible commands:");
        System.out.println("1.\t Show all trees.");
        System.out.println("2.\t Cut a tree.");
        System.out.println("3.\t Filter trees by age.");
        System.out.println("0.\t Exit.");
    }

    public static void main(String[] argv)
    {
        FruitTrees a1 = new AppleTree(10, "Pink Lady", "pink");
        FruitTrees a2 = new AppleTree(5, "Red Jonathan", "red");
        FruitTrees c1 = new CherryTree(7,9);
        FruitTrees c2 = new CherryTree(15, 20);
        FruitTrees p1 = new PearTree(12,7,"Bartlett");
        FruitTrees p2 = new PearTree(3, 5,"D’Anjou");

        Repo repo = new Repo(6);
        try {
            repo.add(a1);
            repo.add(a2);
            repo.add(c1);
            repo.add(c2);
            repo.add(p1);
            repo.add(p2);
        }
        catch(RuntimeException ex) {
            ex.printStackTrace();
        }

         Controller ctrl = new Controller(repo);

        int ok=0;
        Scanner input = new Scanner(System.in);

        while(ok==0)
        {
            printMenu();
            int choice = input.nextInt();
            if(choice == 1)
            {
                for (FruitTrees f: repo.getAll())
                    System.out.print(f);
                System.out.println();
            }
            else if(choice == 2)
            {
                System.out.println("Give an index: ");
                int pos = input.nextInt();
                try{
                    ctrl.cutTree(pos);
                }
                catch(RuntimeException ex)
                {
                    //ex.printStackTrace();
                    System.err.println(ex.toString());
                }
                for(FruitTrees f: repo.getAll())
                    System.out.print(f);
                System.out.println();
            }
            else if(choice == 3)
            {
                System.out.println("Give a number of years: ");
                int age = input.nextInt();
                System.out.println(ctrl.TreesOlderThan(age));
            }
            else if (choice == 0)
            {
                ok=1;

            }

        }



    }
}
