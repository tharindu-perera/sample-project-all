package thread;

import static java.lang.Thread.sleep;

public class CalculatePrimes extends Thread {
    String str;

    public static final int MAX_PRIMES = 1000000;

    public boolean finished = false;
     public void run() {
        int[] primes = new int[MAX_PRIMES];
        int count = 0;

        for (int i=2; count<MAX_PRIMES; i++) {
           if (finished) {
                break;
            }
             boolean prime = true;
            for (int j=0; j<count; j++) {
                if (i % primes[j] == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime) {
                primes[count++] = i;
//                System.out.println("Found prime: " + i);
            }
            try {
                print(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public  static synchronized void print(String str) throws InterruptedException {

            System.out.println(str);
            sleep(10000);

    }
    public static void main(String[] args)throws InterruptedException {
        CalculatePrimes calculator = new CalculatePrimes();
        calculator.str="first";
        CalculatePrimes calculator2 = new CalculatePrimes();
        calculator2.str="sec";
        calculator.start();
        calculator2.start();

    }
}
