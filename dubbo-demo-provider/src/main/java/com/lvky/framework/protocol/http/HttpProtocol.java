package com.lvky.framework.protocol.http;


import com.lvky.framework.protocol.Protocol;
import com.lvky.framework.protocol.util.URL;

public class HttpProtocol implements Protocol {

    @Override
    public void start(URL url) {
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostname(), url.getPort());
    }
}
