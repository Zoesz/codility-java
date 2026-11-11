package lesson01_iterations;

public class BinaryGap {
    public int solution(int N) {
        String bin = Integer.toBinaryString(N);

        int res = 0;
        int temp = 0;
        for (int i = 0; i < bin.length(); i++) {

            if (bin.charAt(i) == '1') {
                if (res < temp) {
                    res = temp;
                }
                temp = 0;

            } else {
                temp++;
            }
        }

        return res;
    }
}

