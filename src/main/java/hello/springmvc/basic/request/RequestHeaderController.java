package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

  /**
   *
   * @param request
   * @param response
   * @param httpMethod
   * @param locale : Locale 정보 조회
   * @param headerMap : 모든 HTTP 헤더를 MultiValueMap 형식으로 조회
   * @param host : 특정 HTTP 헤더를 조회
   * @param cookie : 특정 쿠키 조회 (필수 값 여부 : required / 기본 값 : defaultValue)
   * @return
   */
  @RequestMapping("/headers")
  public String headers(HttpServletRequest request,
                        HttpServletResponse response,
                        HttpMethod httpMethod,
                        Locale locale,
                        @RequestHeader MultiValueMap<String, String> headerMap,
                        @RequestHeader("host") String host,
                        @CookieValue(value = "myCookie", required = false) String cookie){

    // MultiValueMap : Map과 유사한데, 하나의 키에 여러 값을 받을 수 있다. HTTP Header, HTTP 쿼리 파라미터와 같이 하나의 키에 여러 값을 받을 때 사용한다.

    log.info("request={}", request);
    log.info("response={}", response);
    log.info("httpMethod={}", httpMethod);
    log.info("locale={}", locale);
    log.info("headerMap={}", headerMap);
    log.info("header host={}", host);
    log.info("myCookie={}",cookie);

    return "ok";

  }
}
