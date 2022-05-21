package http.header;

public enum ContentType {

    PLAIN_TEXT("plain/text");

    String type;
    ContentType(String type) {
        this.type = type;
    }
}
