package http.request;

import exception.NoSuchUrlException;
import http.HTTPMethod;
import http.header.cache.Cache;
import io.writer.ContentWriter;

import java.util.Map;

public class RequestBuilder {

    private HTTPRequest httpRequest;

    private RequestBuilder(){

    }

    public static RequestBuilder connect(String url) throws NoSuchUrlException {
        RequestBuilder requestBuilder = new RequestBuilder();
        HTTPRequest httpRequest = new HTTPRequest();
        httpRequest.setUrl(url);
        requestBuilder.httpRequest = httpRequest;
        httpRequest.setUrl(url);
        return requestBuilder;
    }

    public RequestBuilder port(int port){
        this.httpRequest.setPort(port);
        return this;
    }

    public RequestBuilder method(HTTPMethod httpMethod){
        httpRequest.setRequestMethod(httpMethod);
        return this;
    }

    public RequestBuilder header(String headerName, String value){
        httpRequest.setHeader(headerName, value);
        return this;
    }

    public RequestBuilder headers(Map<String, String> headers, boolean append){
        httpRequest.setHeaders(headers, append);
        return this;
    }

    public RequestBuilder cookie(String cookieName,String value){
        this.httpRequest.setCookie(cookieName, value);
        return this;
    }

    public RequestBuilder cookies(Map<String, String> cookies, boolean append){
        this.httpRequest.setCookies(cookies, append);
        return this;
    }

    public RequestBuilder content(String contentType){
        this.httpRequest.setContentType(contentType);
        return this;
    }

    public RequestBuilder writer(ContentWriter contentWriter){
        this.httpRequest.setContentWriter(contentWriter);
        return this;
    }

    public RequestBuilder timeout(int ms){
        this.httpRequest.setTimeout(ms);
        return this;
    }

    public RequestBuilder entity(Object entity){
        this.httpRequest.setEntity(entity);
        return this;
    }

    public RequestBuilder cache(Cache cache){
        this.httpRequest.setCache(cache);
        return this;
    }

    public HTTPRequest build(){
        return this.httpRequest;
    }
}
