package ExceptionGeneric;

public class Main {
    public static void main(String[] args) {
        try{
            throw new MyException(222);
        }catch (MyException e){
            System.out.println("Caught Exception: "+e.getMessage());
        }
        try{
            throw new MyException("String");
        }catch (MyException e){
            System.out.println("Caught Exception: "+e.getMessage());
        }
    }
}


class StringProcessingException extends Exception{
    public StringProcessingException(String msg){
        super(msg);
    }
}


class IntegerProcessingException extends Exception{
    public IntegerProcessingException(String msg){
        super(msg);
    }
}


class MyException extends Exception{

    // Constructer to Generic creation
    public <T> MyException(T value){
        super("Exception related to value: "+value.toString()+" of type: "+value.getClass().getName());
    }
}
