package com.thoughtworks.session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dwwang on 5/12/15.
 */
public class HeapOOM {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>();
        while(true){
            list.add(new Object());
        }
    }
}
