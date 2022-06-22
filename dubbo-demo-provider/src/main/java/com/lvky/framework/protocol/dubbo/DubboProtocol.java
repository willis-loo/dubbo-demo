package com.lvky.framework.protocol.dubbo;


import com.lvky.framework.protocol.Protocol;
import com.lvky.framework.protocol.util.URL;

public class DubboProtocol implements Protocol {

    @Override
    public void start(URL url) {
        NettyServer nettyServer = new NettyServer();
        nettyServer.start(url.getHostname(), url.getPort());
    }


}
