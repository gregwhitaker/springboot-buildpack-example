package example.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @GetMapping(value = "/hello")
    public Mono<ResponseEntity<?>> hello(@RequestParam(value = "name", required = false, defaultValue = "You") String name) {
        return Mono.fromSupplier(() -> {
            final Map<String, String> body = new HashMap<>();
            body.put("message", String.format("Hello, %s!", name));

            return ResponseEntity.ok(body);
        });
    }
}
