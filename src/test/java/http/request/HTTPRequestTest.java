package http.request;

import exception.NoSuchUrlException;
import http.HTTPMethod;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HTTPRequestTest {

    private HTTPRequest httpRequest;

    @BeforeAll
    public void init() throws NoSuchUrlException {
         this.httpRequest = RequestBuilder.connect("https://www.google.com")
                 .method(HTTPMethod.GET)
                 .content("plain/text")
                 .timeout(50000)
                 .header("HeaderTest", "TestData")
                 .entity("data")
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
    void writer(){
        this.httpRequest.contentWriter = new
    }

    @Test
    void print(){
        String output = this.httpRequest.toString();
        assert output != null && !output.isEmpty();
    }

}