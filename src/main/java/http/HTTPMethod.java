package http;

public enum HTTPMethod {

    GET("GET"),POST("POST"),PUT("PUT"),PATCH("PATCH"),DELETE("DELETE"),OPTION("OPTION");

    String method;
    HTTPMethod(String method){
        this.method = method;
    }
}
