package ClassObjectsAsTypeLiteralsEx;


/*Type Checking: With Class<T>, we can check the type at runtime.
* For example, the isInstance() method can verify if an object is of a specific type.

Retain Type Information: In generics, type information is lost at runtime due to type erasure,
but using Class<T> helps retain this information.

Class Objects as Type Literals: - In generics, if we want to know the specific type (like T or other types) during runtime,
we use a class object as a type. We can pass this class type to the constructor and then check or use it during runtime.
*
*/

class Boxx<T> {

    private T item;
    private Class<T> type;

    public Boxx(Class<T> type) {
        this.type = type;
    }

    public T getItem() {
        return item;
    }

    public void addItem(T item) {
        this.item = item;
    }

    public boolean isInstance(Object obj) {
        return type.isInstance(obj);

    }

}


public class ClassObjectAsLiteral {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Boxx<String> stringBox = new Boxx<>(String.class);
        stringBox.addItem("Hello World..");

        System.out.println("Is 'Hello' an instance of String: " + stringBox.isInstance("Hello")); // true
        System.out.println("Is 123 an instance of String: " + stringBox.isInstance(123)); // false

        Boxx<Integer> intBox = new Boxx<>(Integer.class);
        intBox.addItem(123);
        System.out.println("123 an instance of Integer: " + intBox.isInstance(123) + " " + intBox.getItem());
        System.out.println("Is 'Hello' an instance of String: " + intBox.isInstance("Hello"));

    }

}