import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class GenericFactory<T,E,N> {

    Class theClass = null;

    public GenericFactory(Class theClass) {
        this.theClass = theClass;
    }

    public T createInstance()  throws IllegalAccessException, InstantiationException {
        return (T) this.theClass.newInstance();
    }
    public static void main2(String[] args) {
        List<String> stringCollection = new ArrayList<>();

        for(String string : stringCollection){

        }
    }
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        List<String> list = new ArrayList<>();

        for(String aString : list) {
            System.out.println(aString);
        }
        GenericFactory genericFactory= new  GenericFactory(MyGe.class);
        MyGe instance = (MyGe) genericFactory.createInstance();
        System.out.println(instance.get());

    }
    public static <T> T addAndReturn(T element, Collection<T> collection){
        collection.add(element);
        return element;
    }
}

