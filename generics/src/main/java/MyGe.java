  class E<E> {
    E obj;

    public E( ){

    }
    void add(E obj) {
        this.obj = obj;
    }

  E get() {
        return obj;
    }
}
  class T<T> {
    T obj;

    public T( ){

    }
    void add(T obj) {
        this.obj = obj;
    }

    T get() {
        return obj;
    }
}
class TestE {
    public static void main(String args[]) {
        E<Integer> m = new E<Integer>( );
        m.add(2);
//m.add("vivek");//Compile time error
        System.out.println(m.get());
    }
}

class TestT {
    public static void main(String args[]) {
        E<MySuper>   m = new E ( );
        m.add(new Rectangle());
        m.add(new Shape());//Compile time error
        m.add("xxxx");//Compile time error
        System.out.println(m.get());
    }
}