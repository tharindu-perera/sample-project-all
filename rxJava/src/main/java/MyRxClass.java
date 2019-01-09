import rx.Observable;
import rx.Observer;
import rx.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class MyRxClass {

    public static void main(String[] args) {

        Observable<String> createObserver = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {


                int i=0;
                while(i<95)
                {
                    subscriber.onNext("Hello World "+ i);
                    i++;
                }


                subscriber.onCompleted();
        }});

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                System.out.println("MySubscriber onNext(): "+ s);
            }

            @Override
            public void onCompleted() {
                System.out.println("Subscriber completed");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("OnError");
            }



        };



        Observer<String> myObserver = new Observer<String>() {
            @Override
            public void onNext(String s) {
                System.out.println("MyObserver onNext(): "+ s);
            }

            @Override
            public void onCompleted() {
                System.out.println("Observer completed");
            }

            @Override
            public void onError(Throwable e) {
            }
        };

        createObserver.subscribe(mySubscriber);
        createObserver.subscribe(myObserver);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        Observable<Integer> fromObservable = Observable.from(numbers);

        Subscriber<Integer> intSubscriber = new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext: "+ integer);
            }
        };

        //Subscription subscription = fromObservable.subscribe(intSubscriber); //One Subscriber with multiple observers is not possible. Hence commented

        //Observable<Integer> justObservable = Observable.just(4,4,6,null);
        //justObservable.subscribe(intSubscriber);

        Observable<Integer> rangeObservable = Observable.range(2,5);
        rangeObservable.subscribe(intSubscriber);


        Observable.just(1,2,3)
                .map(i -> i*i)
                .map(i -> i*i)
                .filter(i -> i>10)
                .subscribe(System.out::println);

    }
}
