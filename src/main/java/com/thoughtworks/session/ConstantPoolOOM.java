package com.thoughtworks.session;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:PermSize=8M -XX:MaxPermSize=8M
 */
public class ConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true){
            list.add("String"+String.valueOf(i++).intern());
        }
    }
}
