package pattern01_counting;

public class MissingInteger {
    public int solution(int[] A) {

        int[] storePositiveNumbers = new int[A.length + 1];
        int lowestPositiveNumber = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && A[i] <= A.length) {
                storePositiveNumbers[A[i]] = 1;
            }
        }
        for (int i = 1; i < storePositiveNumbers.length; i++) {
            if (storePositiveNumbers[i] == 0) {
                return i;
            }
        }
        return A.length + 1;
    }
}
