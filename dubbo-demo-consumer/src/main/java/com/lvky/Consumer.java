package com.lvky;

import com.lvky.api.DemoService;

public class Consumer {
    public static void main(String[] args) {

        //通过动态代理实现逻辑，在代理逻辑中实现调用
        DemoService demoService = ProxyFactory.getProxy(DemoService.class);
        String s = demoService.sayHello("hello,tomcat");
        System.out.println(s);
    }
}
