package http.request;

import exception.NoSuchUrlException;
import http.HTTPMethod;
import http.response.HTTPResponse;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HTTPResponseTest {

    private HTTPResponse httpResponse;

    @BeforeAll
    public void init() throws NoSuchUrlException, IOException {
        this.httpResponse = RequestBuilder.connect("https://www.google.com")
                .method(HTTPMethod.GET)
                .content("plain/text")
                .timeout(50000)
                .header("HeaderTest", "TestData")
                .build()
                .call();
    }

    @Test
    @Order(1)
    public void testResponse(){
        assert this.httpResponse != null;
    }

    @Test
    @Order(2)
    public void testHeadersParsing(){
        assert this.httpResponse.getHeaders().size() == 3;
    }

    @Test
    @Order(3)
    public void testCookieParsing(){
        List<String> cookies = new LinkedList<>(Arrays.asList("Cookie : cookie"));
        this.httpResponse.parseCookie(0, cookies);
        assert this.httpResponse.getCookies().size() == 1;
    }

}