package com.lvky;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lvky-a
 */
@Data
public class Invocation implements Serializable {
    //需要传输的数据
    //接口名
    private String interfaceName;
    //方法名
    private String methodName;
    //参数类型
    private Class[] paramTypes;
    //参数
    private Object[] params;


    public Invocation(String interfaceName, String methodName, Class[] paramTypes, Object[] params) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.paramTypes = paramTypes;
        this.params = params;
    }
}
