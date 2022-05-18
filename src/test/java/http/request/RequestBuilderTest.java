package http.request;

import exception.NoSuchUrlException;
import http.HTTPMethod;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RequestBuilderTest {

    private HTTPRequest httpRequest;

    @BeforeAll
    public void init() throws NoSuchUrlException {
         this.httpRequest = RequestBuilder.connect("https://www.google.com")
                 .method(HTTPMethod.GET)
                 .content("plain/text")
                 .timeout(50000)
                 .header("HeaderTest", "TestData")
                 .build();
    }

    @Test
    public void build(){
        assert this.httpRequest != null;
    }

    @Test
    void connect() {
        assert this.httpRequest.host.equals("www.google.com");
    }

    @Test
    void method() {
        assert this.httpRequest.requestMethod == HTTPMethod.GET;
    }

    @Test
    void header() {
    }

    @Test
    void headers() {
    }

    @Test
    void cookie() {
    }

    @Test
    void cookies() {
    }

    @Test
    void content() {
    }

    @Test
    void writer() {
    }

    @Test
    void timeout() {
    }

}