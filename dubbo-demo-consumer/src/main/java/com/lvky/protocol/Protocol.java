package com.lvky.protocol;

import com.lvky.protocol.util.Invocation;

public interface Protocol {
    String send(URL url, Invocation invocation);
}
