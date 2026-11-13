package pattern01_counting;

public class MostFrequent {
    public int solution(int[] A){
        int[] counts = new int [A.length + 1];

        int maxCount = 0;
        int mostFrequent = 0;
        for (int i = 0; i < A.length; i++) {
            counts[A[i]] = counts[A[i]] + 1;
        }
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                mostFrequent = i;
            }
        }
        return mostFrequent;
    }
}

