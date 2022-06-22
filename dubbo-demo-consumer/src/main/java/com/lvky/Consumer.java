package com.lvky;

import com.lvky.api.DemoService;
import com.lvky.protocol.util.ProxyFactory;

public class Consumer {
    public static void main(String[] args) {

        /*HttpClient httpClient = new HttpClient();
        Invocation invocation = new Invocation(DemoService.class.getName(),"sayHello",new Class[]{String.class},new Object[]{"tomcat"});
        String s = httpClient.send("localhost", 8080, invocation);*/

        //通过动态代理实现逻辑，在代理逻辑中实现调用
        DemoService demoService = ProxyFactory.getProxy(DemoService.class);
        String s = demoService.sayHello("hello,tomcat");
        System.out.println(s);
    }
}
