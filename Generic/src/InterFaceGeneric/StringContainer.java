package InterFaceGeneric;

//-> Simple way

/*
public class StringContainer implements Container<String> {

    private String item;


    @Override
    public void add(String item) {
        this.item = item;
    }

    @Override
    public String get() {
        return item;
    }
}
*/




//-> Generic Way


public class StringContainer<T> implements Container<T> {

    private T item;


    @Override
    public void add(T item) {
        this.item = item;
    }

    @Override
    public T get() {
        return item;
    }
}