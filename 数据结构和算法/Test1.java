
public class Test1 {

    public static void main(String[] args) {
        getNumOfOne(10);


    }


    /**
     * 求出【0，k】区间每个整数值对应的二进制中1的个数
     * k=2,返回0,1,1
     *
     * @param k
     */
    private static void getNumOfOne(int k) {
        for (int i = 0; i <= k; i++) {
            //String binary = Integer.toBinaryString(i);
            int tmp = i;
            int count = 0;
            while (tmp > 0) {
                //从最右边开始计算该位置是否为1
                if (tmp % 2 == 1) {
                    count++;
                }
                // 通过位运算将原始值右移一位
                tmp = tmp >> 1;
            }
            System.out.println(i + "的二进制" + Integer.toBinaryString(i) + ",1的个数为" + count);
        }
    }
}
