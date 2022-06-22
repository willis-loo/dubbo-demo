package com.lvky.framework.protocol;


import com.lvky.framework.protocol.dubbo.DubboProtocol;
import com.lvky.framework.protocol.http.HttpProtocol;

public class ProtocolFactory {

    public static Protocol getProtocol() {

        String name = System.getProperty("protocolName");
        if (name == null || name.equals("")) {
            name = "dubbo";
        }
        switch (name) {
            case "http":
                return new HttpProtocol();
            case "dubbo":
                return new DubboProtocol();
            default:
                break;
        }
        return new HttpProtocol();
    }
}
