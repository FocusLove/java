package grammar;

public class Retry {
    /**
     * 测试retry的用法
     * @param args
     */
    public static void main(String args[]) {

        retry:
        for (int i = 0; i < 10; i++) {
            System.out.println("the i is :" + i);
            if (i == 8) {
//                break retry;
                continue retry;
            }
        }

        System.out.println("over");

    }
}
