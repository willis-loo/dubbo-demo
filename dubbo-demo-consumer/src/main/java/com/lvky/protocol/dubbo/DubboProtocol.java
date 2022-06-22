package com.lvky.protocol.dubbo;

import com.lvky.protocol.util.Invocation;
import com.lvky.protocol.Protocol;
import com.lvky.protocol.URL;

public class DubboProtocol implements Protocol {
    @Override
    public String send(URL url, Invocation invocation) {
        NettyClient nettyClient = new NettyClient();
        return nettyClient.send(url.getHostname(),url.getPort(), invocation);
    }
}
