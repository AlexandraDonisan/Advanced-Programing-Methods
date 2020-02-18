import java.util.*;
import java.util.stream.Collectors;

public class mainClass {
    public static void lambdaFunctions()
    {
        MyGeneric<String> reverse = (str)->{
            StringBuilder result= new StringBuilder();

            for(int i=str.length()-1;i>=0;i--)
                result.append(str.charAt(i));

            return result.toString();
        };

        MyGeneric<Integer> factorial = (Integer n)->{
            int result=1;
            for(int i=1;i<=n;i++)
            {
                result=i*result;
            }
            return result;
        };

        MyGeneric<Integer> reverseInt = (Integer n)->{
            int result=0;

            while(n!=0)
            {
                result = result*10 + n%10;
                n=n/10;
            }
            return result;
        };
        System.out.println(reverse.compute("Hello World"));
        System.out.println(factorial.compute(6));
        System.out.println(reverseInt.compute(456));

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.addAll(Arrays.asList(4, 2, 3, 0, 12, 1, 6));
        System.out.println(list);

        Collections.sort(list,(Integer a, Integer b)->a.compareTo(b));
        System.out.println(list);
    }

    public static void streamFunctions()
    {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        System.out.println();
        //stream().map() lets you CONVERT an object to something ELSE.
        // stream().limit(n): Returns a stream that is no longer than the given size n
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> twoEvenSquares =
                numbers.stream()
                        .filter(n -> {
                            System.out.println("filtering " + n);
                            return n % 2 == 0;
                        })
                        .map(n -> {
                            System.out.println("mapping " + n);
                            return n * n;
                        })
                        .limit(2)
                        .collect(Collectors.toList());
        System.out.println("twoEvenSquares: " + twoEvenSquares);
        System.out.println();

        List<String> words = Arrays.asList("Oracle", "Java", "Magazine");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println("word lengths: " + wordLengths);
        System.out.println();

        List<String> listEye = Arrays.asList("i", "ala", "ii", "i", "abba", "Ella", "Quebec","Eli");
        List<String> a = listEye.stream().map(word -> word.replaceAll("i", "eye")).collect(Collectors.toList());
        List<String> b = listEye.stream().map(String::toUpperCase).collect(Collectors.toList());
        List<String> c = listEye.stream().filter(word -> word.length() < 4).collect(Collectors.toList());
        List<String> d = listEye.stream().filter(word -> word.contains("b")).collect(Collectors.toList());
        List<String> e = listEye.stream().filter(word -> word.length() % 2 == 0).collect(Collectors.toList());

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

        //P5
        Optional<String> e1 = Optional.of(listEye.stream().map(String::toUpperCase)
                .filter(word -> word.length() < 4)
                .filter(word -> word.contains("E"))
                .findFirst()
                .orElse("Not found"));
        System.out.println(e1);

        //P6
        System.out.println(words.stream().reduce("",(acc,item)->acc + item.toUpperCase()).toString());
        //P7
        System.out.println(words.stream().map(String::toUpperCase)
                .reduce("", (acc,word)->acc+""+word));
        //P8
        System.out.println(words.stream()
                .reduce(" ",(acc, item)->acc+","+item));
        //P9
        System.out.println(words.stream().map(s->s.length())
                .reduce((acc,bcc)->acc+bcc));

        //P10
        System.out.println(words.stream()
                .filter(word->word.contains("h"))
                .count());
    }

    public static void main(String[] args) {
        mainClass.lambdaFunctions();

        mainClass.streamFunctions();

    }

}
