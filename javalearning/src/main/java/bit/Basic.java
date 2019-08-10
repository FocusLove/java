package bit;

/**
 * 1.java不涉及地址、字节序的概念；Jvm屏蔽了这一层
 * 2.整数的最高位表示是否为负数
 * 3.整形溢出是如何表示的
 */
public class Basic {

    public static void main(String args[]) {
        int c1 = -1;

        System.out.printf("c1:%x\r\n", c1);

        c1 = c1 << 1;
        System.out.printf("c1:%x\r\n", c1);

        /**
         * 整形溢出的表示：包括正整数的溢出跟负数的溢出
         * 十六进制：0 -> 0x7fffffff -> 80000000 -> 0xffffffff -> 0
         * 十进制： 0 -> 整数最大值   -> 负数最小值 -> -1         -> 0
         */
        int int1 = Integer.MAX_VALUE;
        System.out.printf("int1:%x\r\n", int1);
        int1++;
        System.out.printf("int1:%x,%d\r\n", int1, int1);
        int1++;
        System.out.printf("int1:%x,%d\r\n", int1, int1);

        int int2 = 0xFFFFFFFF + 1;
        System.out.printf("int1:%x,%d\r\n", int2, int2);
    }

}
