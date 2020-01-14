package com.herokuapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import java.util.List;

@RequestMapping(path="/v1")
public interface FortuneCookieService {
    @GetMapping("/fortunes")
    Mono<List<FortuneCookie>> listCookies();
}
