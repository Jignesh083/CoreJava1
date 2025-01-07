package MethodGenricEx;

public class EnumExample {
    public static void main(String[] args) {
        double res1 = Operation.ADD.apply(10, 20);
        System.out.println(res1);
    }
}


enum Operation{
    ADD,SUB,MUL,DIV;

    public <T extends Number> double apply(T a,T b){
        switch (this){
            case ADD:
                return a.doubleValue() + b.doubleValue();
            case SUB:
                return a.doubleValue() - b.doubleValue();
            case MUL:
                return a.doubleValue() * b.doubleValue();
            case DIV:
                return a.doubleValue() / b.doubleValue();
            default:
                throw new AssertionError("Unknown operation: "+this);
        }
    }
}