package net.class101.eventdrivenpoc.web;

import lombok.extern.slf4j.Slf4j;
import net.class101.eventdrivenpoc.domain.Usage;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Date;
import java.util.Random;

@Slf4j
@RestController
public class WebController {
    @CrossOrigin(allowedHeaders = "*")
    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Usage> testEndpoint() {
        Random random = new Random();

        return Flux.interval(Duration.ofSeconds(1))
                .map(it -> {
                    log.info("event is sent");
                    return new Usage(
                            random.nextInt(101),
                            random.nextInt(101),
                            new Date()
                    );
                });

    }
}
