import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class GenericFactory<T,E,N> {

    Class theClass = null;

    public GenericFactory(Class theClass) {
        this.theClass = theClass;
    }

    public T createInstance()  throws  Exception {
        return  (T)this.theClass.newInstance();
    }

    public static void main(String[] args) throws Exception {

        GenericFactory<MySuper,MySuper,MySuper> genericFactory= new  GenericFactory(MySuper.class);
        MySuper instance = (MySuper) genericFactory.createInstance();
        instance.superMethod();

    }
    public static <T> T addAndReturn(T element, Collection<T> collection){
        collection.add(element);
        return element;
    }
}

