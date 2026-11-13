package pattern00_basics;

//13 perc újból
public class BinaryGap {
    public int solution(int N) {
        String binary = Integer.toBinaryString(N);

        int currentGap = 0;
        int maxGap = 0;

        for (int i = 0; i < binary.length(); i++) {

            if (binary.charAt(i) == '1') {
                if (maxGap < currentGap) {
                    maxGap = currentGap;
                }
                currentGap = 0;
            } else {
                currentGap++;
            }
        }
        return maxGap;
    }
}

