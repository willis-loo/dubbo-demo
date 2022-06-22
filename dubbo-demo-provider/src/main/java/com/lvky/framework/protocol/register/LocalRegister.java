package com.lvky.framework.protocol.register;

import java.util.HashMap;
import java.util.Map;

public class LocalRegister {

    public static Map<String,Class> map = new HashMap<>();

    public static Class get(String interfaceName){

        return map.get(interfaceName);
    }

    public static void register(String interfaceName,Class implClass){
        map.put(interfaceName,implClass);
    }

}
