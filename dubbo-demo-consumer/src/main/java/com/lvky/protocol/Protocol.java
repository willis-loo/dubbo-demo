package com.lvky.protocol;

import com.lvky.Invocation;

public interface Protocol {
    String send(URL url, Invocation invocation);
}
