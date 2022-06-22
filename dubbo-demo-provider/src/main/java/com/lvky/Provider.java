package com.lvky;

import com.lvky.api.DemoService;
import com.lvky.api.impl.DemoServiceImpl;
import com.lvky.framework.protocol.http.HttpServer;
import com.lvky.framework.protocol.register.LocalRegister;
import com.lvky.framework.protocol.register.ZookeeperRegister;
import com.lvky.framework.protocol.util.URL;

public class Provider {
    public static void main(String[] args) {
        //  服务：实现类
        URL url = new URL("localhost", 8080);
        ZookeeperRegister.regist(DemoService.class.getName(),url);

        LocalRegister.register(DemoService.class.getName(), DemoServiceImpl.class);

        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost",8080);
    }
}
