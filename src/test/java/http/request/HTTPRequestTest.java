package http.request;

import exception.NoSuchUrlException;
import http.HTTPMethod;
import http.header.cache.CacheBuilder;
import io.writer.ContentWriter;
import io.writer.JSONContentWriter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HTTPRequestTest {

    private HTTPRequest httpRequest;

    @BeforeAll
    public void init() throws NoSuchUrlException {
        Map<String, String> headers = new HashMap<>(), cookies = new HashMap<>();
        headers.put("HeaderTest2", "dzada");
        cookies.put("cookie2","cookie2");
        this.httpRequest = RequestBuilder.connect("https://www.google.com")
                .method(HTTPMethod.GET)
                .content("plain/text")
                .timeout(50000)
                .header("HeaderTest", "TestData")
                .entity("data")
                .writer(new JSONContentWriter())
                .cookie("cookie", "cookie1")
                .headers(headers, true)
                .cookies(cookies, true)
                .cache(CacheBuilder.cache().privateCache().maxAge(100).build())
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
    void writer() throws IOException {
        this.httpRequest.call();
        assert this.httpRequest.body.equals("\"data\"");
    }

    @Test
    void jsonWriter() throws IOException {
        this.httpRequest.setContentWriter(new JSONContentWriter());
        this.httpRequest.call();
        assert this.httpRequest.body.equals("\"data\"");
    }

    @Test
    void print(){
        String output = this.httpRequest.toString();
        assert output != null && !output.isEmpty();
    }

    @Test
    void cookies(){
        assert this.httpRequest.cookies.size() == 2;
    }

    @Test
    void headers(){
        assert this.httpRequest.headers.size() == 2;
    }

    @Test
    void cache(){
        assert this.httpRequest.cache.print().equals("Cache-Control : private, max-age=100");
    }

}