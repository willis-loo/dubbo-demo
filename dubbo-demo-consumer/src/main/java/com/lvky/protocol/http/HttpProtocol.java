package com.lvky.protocol.http;


import com.lvky.protocol.util.HttpClient;
import com.lvky.protocol.util.Invocation;
import com.lvky.protocol.Protocol;
import com.lvky.protocol.URL;

public class HttpProtocol implements Protocol {

    @Override
    public String send(URL url, Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.send(url.getHostname(), url.getPort(),invocation);
    }
}
