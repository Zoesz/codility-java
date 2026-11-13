package pattern01_counting;

import java.util.HashMap;
import java.util.Map;

public class RepeatedValues {
    public int solution(int[] A) {

        Map<Integer, Integer> mapOFNumbers = new HashMap<>();
        int repeatedCount = 0;

        for (int i = 0; i < A.length; i++) {
            mapOFNumbers.put(A[i], mapOFNumbers.getOrDefault(A[i], 0) + 1);
            if (mapOFNumbers.get(A[i]) == 2) {
                repeatedCount++;
            }
        }
        return repeatedCount;
    }
}
