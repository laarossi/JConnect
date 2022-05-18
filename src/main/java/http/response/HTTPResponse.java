package http.response;

import java.util.HashMap;
import java.util.Map;

public class HTTPResponse {

    String body;
    Map<String, String> headers = new HashMap<>();
    Map<String, String> cookies = new HashMap<>();

    public void parse(String data){
        parseHeader(data);
        parseCookie(data);
    }

    public void parseHeader(String header){}

    public void parseCookie(String cookie){}

    public void setBody(String body) {
        this.body = body;
    }
}
