package http.response.parser;

import java.util.Map;

public abstract class Parser {

    public abstract boolean isValid(String data);

    public abstract void parse(String data, Map<String, String> dataMap );

    public void read(String data, Map<String, String> dataMap){
        if(!isValid(data)) return;
        parse(data, dataMap);
    }

}
