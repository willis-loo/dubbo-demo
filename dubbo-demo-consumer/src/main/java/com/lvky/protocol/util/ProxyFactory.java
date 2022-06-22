package com.lvky.protocol.util;

import com.lvky.protocol.LoadBalance;
import com.lvky.protocol.Protocol;
import com.lvky.protocol.ProtocolFactory;
import com.lvky.protocol.URL;
import com.lvky.protocol.util.Invocation;
import com.lvky.register.ZookeeperRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class ProxyFactory {
    @SuppressWarnings("unchecked")
    public static <T> T getProxy(final Class interfaceClass){
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), args);
                List<URL> urlList = ZookeeperRegister.get(interfaceClass.getName());
                URL url = LoadBalance.random(urlList);
                Protocol protocol = ProtocolFactory.getProtocol();
                String result = protocol.send(url, invocation);
                return result;
            }
        });
    }
}
