package com.lvky.framework.protocol.dubbo;

import com.lvky.protocol.util.Invocation;
import io.netty.channel.ChannelHandlerContext;

public interface ChannelHandler {

    public void handler(ChannelHandlerContext ctx, Invocation invocation) throws Exception;

}
