
import java.io.IOException;
import java.io.Serializable;
import java.util.*;


class MySuper {
    void superMethod(){
        System.out.println("superMethod");
    }
}

  class Shape  extends MySuper{
      void draw(){

      }
}

class Rectangle extends Shape implements Serializable {
    void draw() {
        System.out.println("drawing rectangle");
    }
}

class Circle extends Shape implements Serializable  {
    void draw() {
        System.out.println("drawing circle");
    }
}

class GenericTest {
    public static void drawShapes(List<? extends Shape> lists) {
        for (Shape s : lists) {
            s.draw();
        }
    }

    public static void processElements(List<? super Shape> elements) {
        for (Object o : elements) {
            System.out.println(o);
        }

    }
    public static void addToArray( Shape elements) {

        Shape[] shapes = new Shape[5];
        shapes[0]=elements;
        System.out.println(shapes.length);

    }

    public static<T> T temp(T t){
        if(t instanceof Circle){
            System.out.println("true");

        }else{
            System.out.println("false");
        }
        return t;
    }

    public static void main(String args[]) throws InterruptedException, IOException {
        Optional<String> optional = Optional.ofNullable("fff");

        if (optional.isPresent()) System.out.println("true");
        else System.out.println(false);

//        List<Rectangle> rectangleList = new ArrayList<>();
//        rectangleList.add(new Rectangle());
//
//        List<Circle> circleList = new ArrayList<>();
//        circleList.add(new Circle());
//
//        List<MySuper> mySuperList = new ArrayList<>();
//        mySuperList.add(new MySuper());
//
//        drawShapes(circleList);
////        drawShapes(mySuperList);
//        processElements(mySuperList);
////        processElements(rectangleList);
//
//        addToArray(new Rectangle());
//        GenericArray<Shape, Shape> shapeCircleGenericArray = new GenericArray<>();
//        Shape circle = shapeCircleGenericArray.get(new Shape(), new Circle());
//
//        shapeCircleGenericArray.copy(circleList,rectangleList);
//        //List of Integers
//        List<Integer> ints = Arrays.asList(1,2,3,4,5);
//        System.out.println(GenericArray.sum(ints));
//
//        //List of Doubles
//        List<Double> doubles = Arrays.asList(1.5d,2d,3d);
//        System.out.println(GenericArray.sum(doubles));
//
//        List<String> strings = Arrays.asList("1","2");
//        //This will give compilation error as :: The method sum(List<? extends Number>) in the
//        //type GenericsExample<T> is not applicable for the arguments (List<String>)
//        System.out.println(GenericArray.sum(strings));


    }
}

  class GenericArray< T ,E> {
    // this one is fine
    Collection<? extends E> coll = new ArrayList<E>();

      public List<E>  notYetInstantiatedArray=new ArrayList<>();
      public T get(  T t,E x){
           notYetInstantiatedArray.add(x);
          return t;

      }

      public   void copy(List<? extends    T> dest, List<? extends  T> src){

      }

      public static    Object sum (List<? extends Object> numbers){
          double s = 0.0;
          for (Object n : numbers)
               n.toString();
          return s;
      }


  }