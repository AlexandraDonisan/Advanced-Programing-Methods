package Model;

abstract class Exp {
    abstract int eval(MyIDictionary<String,Integer> tbl) throws MyException;
}
