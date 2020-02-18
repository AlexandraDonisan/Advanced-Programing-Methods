import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class mainExample {
    public static void seminarProblems()
    {
        List<String> words = Arrays.asList("hi","hello","ola","salut");

        //P1. Loop down the words and print each on a separate line, with two spaces in front of each word.
        //Don’t use map.
        words.stream()
                .forEach(p->System.out.println("  "+p));

        //P2. Repeat the previous problem, but without the two spaces in front. This is trivial if you use the
        //same approach as in P1, so the point is to use a method reference here, as opposed to an explicit
        //lambda as in P1.

        words.stream().forEach(System.out::println);

        //P3. We assume that we have a method StringUtils.transformedList(List<String>,
        //Function1<String>)
        //where interface Function1<T> { T app(T);}
        //and we produced transformed lists like this:
        //• List<String> excitingWords = StringUtils.transformedList(words, s -> s + "!");
        //• List<String> eyeWords = StringUtils.transformedList(words, s -> s.replace("i", "eye"));
        //• List<String> upperCaseWords = StringUtils.transformedList(words, String::toUpperCase);
        //Produce the same lists as above, but this time use streams and the builtin “map” method.

        List<String> first = words.stream()
                .map(w -> w + "!")
                .collect(Collectors.toList());
        List<String> second = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        List<String> third = words.stream()
                .map(w->w.replaceAll("a","eye"))
                .collect(Collectors.toList());

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);

        //P4. We assume that we have the method StringUtils.allMatches(List<String>, Predicate1<String>)
        //where interface Predicate1<T> { boolean check(T);}
        //and we produced filtered lists like this:
        //• List<String> shortWords = StringUtils.allMatches(words, s -> s.length() < 4);
        //• List<String> wordsWithB = StringUtils.allMatches(words, s -> s.contains("b"));
        //• List<String> evenLengthWords = StringUtils.allMatches(words, s -> (s.length() % 2) == 0);
        //Produce the same lists as above, but this time use “filter”.
        List<String> p4First = words.stream()
                .filter(w->{return w.length() <4;})
                .collect(Collectors.toList());

        List<String> p4Second = words.stream()
                .filter(w->w.contains("h"))
                .collect(Collectors.toList());

        List<String> p4Third = words.stream()
                .filter(w->(w.length()%2)==0)
                .collect(Collectors.toList());

        System.out.println(p4First);
        System.out.println(p4Second);
        System.out.println(p4Third);

        //P5. Turn the strings into uppercase, keep only the ones that are shorter than 4 characters, of what is
        //remaining, keep only the ones that contain “E”, and print the first result. Repeat the process, except
        //checking for a “Q” instead of an “E”. When checking for the “Q”, try to avoid repeating all the code
        //from when you checked for an “E”.
        List<String> p5First = words.stream()
                .map(String::toUpperCase)
                .filter(w->{return w.length()<=5;})
                .filter(w->w.contains("H"))
                .collect(Collectors.toList());

        System.out.println(p5First);

        //P6. Produce a single String that is the result of concatenating the uppercase versions of all of the
        //Strings. Use a single reduce operation, without using map.
        System.out.println(words.stream()
                .reduce("",(acc,item)->acc+item.toUpperCase()));

        //P7. Produce the same String as above, but this time via a map operation that turns the words into
        //uppercase, followed by a reduce operation that concatenates them.
        System.out.println(words.stream().map(String::toUpperCase).reduce("",(acc,item)->acc+item));


        //P8. Produce a String that is all the words concatenated together, but with commas in between. E.g.,
        //the result should be "hi,hello,...". Note that there is no comma at the beginning, before “hi”, and
        //also no comma at the end, after the last word. Major hint: there are two versions of reduce discussed
        //in the notes.
        words.stream().reduce((acc,item)->acc+','+item).ifPresent(System.out::println);

        //P9. Find the total number of characters (i.e., sum of the lengths) of the strings in the List
        System.out.println(words.stream().map(String::length).reduce(0,(acc, item)->acc+item));

        //P10. Find the number of words that contain an “h”.
        System.out.println(words.stream().filter(w->w.contains("l")).count());
    }

    public static void main(String[] args) {
       seminarProblems();
    }
}