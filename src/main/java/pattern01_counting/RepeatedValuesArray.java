package pattern01_counting;

public class RepeatedValuesArray {
    public int solution(int[] A) {
        int[] counts = new int[A.length + 1];
        int repetitionCounter = 0;

        for (int i = 0; i < A.length; i++) {
            counts[A[i]] = counts[A[i]] + 1;
            if (counts[A[i]] == 2) {
                repetitionCounter++;
            }
        }
        return repetitionCounter;
    }
}
