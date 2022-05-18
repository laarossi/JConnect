package http.socket;

import http.request.HTTPRequest;
import http.response.HTTPResponse;

import java.io.*;
import java.net.Socket;

public class WebSocket {

    public static HTTPResponse request(HTTPRequest httpRequest) throws IOException {
        Socket socket = new Socket(httpRequest.getHost(), httpRequest.getPort());
        InputStream is = socket.getInputStream();
        DataOutputStream buffer = new DataOutputStream(socket.getOutputStream());
        buffer.writeUTF(httpRequest.toString());
        buffer.flush();
        byte[] bufferO = new byte[1024];
        int read;
        HTTPResponse httpResponse = new HTTPResponse();
        StringBuilder outputBuffer = new StringBuilder();
        while((read = is.read(bufferO)) != -1) {
            outputBuffer.append(new String(bufferO, 0, read));
        }
        httpResponse.parse(outputBuffer.toString());
        return httpResponse;
    }

}
