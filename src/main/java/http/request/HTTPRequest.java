package http.request;

import exception.NoSuchUrlException;
import http.HTTPMethod;
import http.response.HTTPResponse;
import http.socket.WebSocket;
import io.writer.ContentWriter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HTTPRequest {

    int timeout, port = 80;
    String httpVersion;
    String host, path, url;
    HTTPMethod requestMethod;
    Map<String,String> headers = new HashMap<>();
    Map<String,String> cookies = new HashMap<>();
    String contentType;
    ContentWriter contentWriter;

    public HTTPRequest(){}

    public void setUrl(String url) throws NoSuchUrlException {
        URL urlData = null;
        if(url == null || url.isEmpty())
            throw new NoSuchUrlException("The url provided " + url + " is malformed");

        try {
            urlData = new URL(url);
        } catch (MalformedURLException e) {
            throw new NoSuchUrlException("The url provided " + url + " is malformed");
        }

        this.host = urlData.getHost();
        this.path = urlData.getPath();
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setRequestMethod(HTTPMethod requestMethod) {
        this.requestMethod = requestMethod;
    }

    public void setHeader(String headerName, String value){
        this.headers.put(headerName, value);
    }

    public void setHeaders(Map<String,String> headers, boolean append){
        if(!append) this.headers = headers;
        else this.headers.putAll(headers);
    }

    public void setCookie(String cookieName, String value){
        this.cookies.put(cookieName, value);
    }

    public void setCookies(Map<String, String> cookies, boolean append)     {
        if(!append) this.cookies = cookies;
        this.cookies.putAll(cookies);
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public void setContentWriter(ContentWriter contentWriter) {
        this.contentWriter = contentWriter;
    }

    public String printHeaders(){
        if(headers.size() == 0) return "";
        StringBuffer buffer = new StringBuffer();
        headers.forEach((headerName, headerValue) -> {
            buffer.append(headerName).append(" : ").append(headerValue).append("\n");
        });
        return buffer.toString();
    }

    public String printCookies(){
        if(cookies.size() == 0) return "";
        StringBuffer buffer = new StringBuffer();
        buffer.append("Cookie : ");
        cookies.forEach((cookieName,cookieValue) -> {
            buffer.append(cookieName).append(":").append(cookieValue).append("; ");
        });
        return buffer.toString();
    }

    public void call() throws IOException {
        WebSocket.request(this);
    }

    public String toString(){
        StringBuffer bodyBuffer = new StringBuffer();
        bodyBuffer.append(requestMethod).append("  ").append(this.path).append(" HTTP/1.1\n");
        bodyBuffer.append("Host : ").append(this.host).append("\n");
        bodyBuffer.append(printHeaders()).append("\n");
        bodyBuffer.append(printCookies());
        return bodyBuffer.toString();
    }

}
