package com;

import com.sun.tools.internal.ws.wsdl.document.http.HTTPAddress;
import org.reactivestreams.Publisher;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Reactive {
    public static void main(String[] args) {
        lesson1();

    }
    public static void lesson2() {
        Mono.just("xxx").subscribe(
                successValue -> {System.out.println(successValue);
                    try {
                        sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },
                error -> System.err.println(error.getMessage()),
                () -> System.out.println("Mono consumed.")
        );
    }

    public static void lesson1() {

        Mono.just("Hello World !").
                map(id -> id).
                map(user -> user + 1)
                // will convert the Flux<UserDetails> into a Mono<List<UserDetails>>
                .subscribe(System.out::println);
        Mono<Integer> monoFromFlux = Mono.from(Flux.range(1, 10));
//        monoFromFlux.map(
//                Mono.empty()
//        )
        monoFromFlux .subscribe(System.out::println);

        //.subscribe(x -> System.out.println(x.block() ));
    }

    public static void main2() {
        Flux<String> just = Flux.just("1", "2", "3");
        Mono<String> mono = Mono.just("ww");
        Publisher<String> just2 = Mono.just("foo");
        List<Integer> elements = new ArrayList<>();

///////////////////////////////////////////////////////////////////////////////////////////////////////

        Flux.just(1, 2, 3, 4)
                .subscribe(e -> {
                    elements.add(e);
                    System.out.println(e);
                });

///////////////////////////////////////////////////////////////////////////////////////////////////////

        Flux<Integer> squared = Flux.range(1, 10).map(x -> x * x);
        squared.subscribe(x -> {
            System.out.print(x + ",, ");
        });

///////////////////////////////////////////////////////////////////////////////////////////////////////

        Flux.range(1, 10).
                map(id -> id).
                map(user -> user + 1).
                collectList(). // will convert the Flux<UserDetails> into a Mono<List<UserDetails>>
                map(listUserDetails -> {
            if (false) {
                return Flux.range(1, 10).
                        map(id -> id).
                        map(user -> user + 1).
                        collectList();
                //return Mono.just("xx");
                // return "xxx";
            } else {
                return Mono.just("yy");
            }

        })
                .subscribe(x -> System.out.println(x.block()));
///////////////////////////////////////////////////////////////////////////////////////////////////////

        Flux.range(1, 10).
                map(id -> id).
                map(user -> user + 1).
                collectList(). // will convert the Flux<UserDetails> into a Mono<List<UserDetails>>
                map(n -> {
            System.out.println("In map n=" + n);
            return n;
        });
        //.subscribe(x -> System.out.println(x.block() ));


    }
}


