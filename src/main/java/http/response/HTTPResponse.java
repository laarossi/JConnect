package http.response;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTTPResponse {

    String body = "", rawResponse = "";
    Map<String, String> headers = new HashMap<>();
    Map<String, String> cookies = new HashMap<>();

    public void parse(String data){
        rawResponse = data;
        List<String> lines = new LinkedList<>(Arrays.asList(data.split("\n")));
        int i = 0;
        while (i != lines.size()) {
            if (parseHeader(i, lines)) continue;
            i++;
        }
    }

    public boolean parseHeader(int dataRow, List<String> data){
        String header = data.get(dataRow);
        Pattern pattern = Pattern.compile("(?<name>[a-zA-Z0-9_-]*)([ ]*):(?<value>(.*))");
        Matcher matcher = pattern.matcher(header);
        if(matcher.find()){
            headers.put(matcher.group("name").trim(), matcher.group("value").trim());
            data.remove(dataRow);
            return true;
        }
        return false;
    }

    public boolean parseCookie(int dataRow, List<String> data){
        String cookie = data.get(dataRow);
        Pattern pattern = Pattern.compile("(Cookie|cookie)([ ]*):(?<value>(.*))");
        Matcher matcher = pattern.matcher(cookie);
        if(matcher.find()){
            cookies.put("Cookie", matcher.group("value").trim());
            data.remove(dataRow);
            return true;
        }
        return false;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

}
