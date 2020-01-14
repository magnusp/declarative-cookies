package github.magnusp.declarativefortune;

import com.herokuapp.FortuneCookie;
import github.magnusp.declarativefortune.client.FortuneCookieServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Random;

@RestController
public class CookieController {
    private static final Random random = new Random();
    private final FortuneCookieServiceClient fortuneCookieServiceClient;

    @Autowired
    public CookieController(
            @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") FortuneCookieServiceClient fortuneCookieServiceClient
    ) {
        this.fortuneCookieServiceClient = fortuneCookieServiceClient;
    }

    @GetMapping("/randomcookie")
    public Mono<FortuneCookie> getRandomCookie() {
        return fortuneCookieServiceClient
                .listCookies()
                .map(fortuneCookies -> fortuneCookies.get(random.nextInt(fortuneCookies.size())));
    }
}
