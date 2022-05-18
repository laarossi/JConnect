import exception.NoSuchUrlException;
import http.HTTPMethod;
import http.request.HTTPRequest;
import http.request.RequestBuilder;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws NoSuchUrlException, IOException {
        HTTPRequest httpRequest = RequestBuilder.connect("https://www.google.com")
                .method(HTTPMethod.GET)
                .content("plain/text")
                .timeout(50000)
                .header("HeaderTest", "TestData")
                .build();
        httpRequest.call();
    }

}
