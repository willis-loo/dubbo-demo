package com.lvky.framework.protocol.http;

import com.lvky.Invocation;
import com.lvky.framework.protocol.register.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp) {

        try {
            ObjectInputStream ois = new ObjectInputStream(req.getInputStream());
            Invocation invocation = (Invocation) ois.readObject();
            String interfaceName = invocation.getInterfaceName();
            //通过本地注册的方法名和服务找到对应的实现类
            Class implClass = LocalRegister.get(interfaceName);
            //反射执行方法
            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            String res = (String) method.invoke(implClass.newInstance(), invocation.getParams());
            IOUtils.write(res, resp.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
