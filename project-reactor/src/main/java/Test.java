import org.hamcrest.core.Is;
import org.junit.Assert;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class Test {
    @org.junit.Test
    public void empty() {
        Mono<Integer> map = Mono.from(Flux.range(1, 10)).
               flatMap(it -> {   System.out.println(it) });




    }
}
