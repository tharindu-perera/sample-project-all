import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoProcessor;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test {

    private static List<String> streamOfNames =
            Arrays.asList("Ranga", "Adam", "Joe", "Doe", "Jane");


    @org.junit.jupiter.api.Test
    public void fluxStreamWithDelay() throws InterruptedException {
        Flux<String> stubFluxWithNames =
                Flux.fromIterable(streamOfNames)–º≠ p,i;
        stubFluxWithNames.subscribe(System.out::println);
        stubFluxWithNames.subscribe(x -> System.out.println(x + "ffff"));
        Thread.sleep(10000);
    }
}

