package github.magnusp.declarativefortune.client;

import com.herokuapp.FortuneCookieService;
import reactivefeign.spring.config.ReactiveFeignClient;

@ReactiveFeignClient(name = "cookie-feign-client", url = "http://fortunecookieapi.herokuapp.com")
public interface FortuneCookieServiceClient extends FortuneCookieService {

}
