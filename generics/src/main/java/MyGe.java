public class MyGe<E> {
    E obj;

    public MyGe( ){

    }
    void add(E obj) {
        this.obj = obj;
    }

    E get() {
        return obj;
    }
}

class TestGenerics3 {
    public static void main(String args[]) {
        MyGe<Integer> m = new MyGe<Integer>( );
        m.add(2);
//m.add("vivek");//Compile time error
        System.out.println(m.get());
    }
}