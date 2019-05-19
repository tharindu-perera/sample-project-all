import com.sun.org.apache.xerces.internal.xs.StringList;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestAny {

   private static String[] arr=new String[2];
    public static void main(String[] args) {
        arr[0]=new String("100");
        arr[1]= arr[0];
        System.out.println(arr[0]);
        System.out.println(arr[1]);


        int[] arrayWitTen = new int[10];

        int[] arrayWith100 = new int[100];
        arrayWitTen=arrayWith100;
        System.out.println("ffff");
        System.out.println(arrayWitTen.length+">>");
          System.out.println( arr[1]);
        HashSet<String> list = new HashSet<>( Arrays.asList(arr));

        System.out.println(list. size());


    }
}


class A
{
    int i = 10;
}

class B extends A
{
    int i = 20;
}

  class MainClass
{
    public static void main(String[] args)
    {
        A a = new B();

        System.out.println(a.i);
    }
}
