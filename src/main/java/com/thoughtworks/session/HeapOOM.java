package com.thoughtworks.session;

import java.util.ArrayList;
import java.util.List;

/**
 * -verbose:gc -Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>();
        while(true){
            list.add(new Object());
        }
    }
}
