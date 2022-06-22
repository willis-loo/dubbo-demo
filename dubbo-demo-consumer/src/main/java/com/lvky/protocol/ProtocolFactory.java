package com.lvky.protocol;


import com.lvky.protocol.dubbo.DubboProtocol;
import com.lvky.protocol.http.HttpProtocol;

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
