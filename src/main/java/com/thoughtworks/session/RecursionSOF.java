package com.thoughtworks.session;

/**
 * -Xss160k
 */
public class RecursionSOF {

    /**
     * 求N的阶乘
     * @param N
     * @return N的阶乘
     */
    public static long fact(long n) {
        return n < 2 ? 1 : n * fact(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(fact(1 << 15));
    }
}
