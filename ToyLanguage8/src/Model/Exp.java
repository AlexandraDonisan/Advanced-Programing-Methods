package Model;

abstract class Exp {
    abstract int eval(MyIDictionary<String,Integer> tbl, MyIHeap<Integer,Integer> hp) throws MyException;
}
