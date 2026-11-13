package pattern01_counting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepeatedValuesTest {

    @Test
    void sameValueManyTimesCountsOnce() {
        assertEquals(1, new RepeatedValues().solution(new int[]{5,5,5,5}));
    }

    @Test
    void exampleFromTask() {
        assertEquals(2, new RepeatedValues().solution(new int[]{3, 1, 3, 2, 1, 3}));
    }

    @Test
    void allDistinctReturnsZero() {
        assertEquals(0, new RepeatedValues().solution(new int[]{5, 4, 3, 2, 1, 6}));
    }

    @Test
    void singleElement() {
        assertEquals(0, new RepeatedValues().solution(new int[]{1}));
    }

    @Test
    void exactlyTwiceCounts() {
        assertEquals(1, new RepeatedValues().solution(new int[]{1, 2, 2}));
    }

    @Test
    void largeAllSame() {
        int n = 100_000;
        int[] a = new int[n];
        java.util.Arrays.fill(a, 1);
        assertEquals(1, new RepeatedValues().solution(a));
    }

    @Test
    void largeAllDistinct() {
        int n = 100_000;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;          // 1..N, mind különböző
        }
        assertEquals(0, new RepeatedValues().solution(a));
    }

    @Test
    void largeEveryValueTwice() {
        int n = 100_000;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i / 2 + 1;      // 1,1,2,2,3,3,... → n/2 különböző érték, mind kétszer
        }
        assertEquals(n / 2, new RepeatedValues().solution(a));
    }
}