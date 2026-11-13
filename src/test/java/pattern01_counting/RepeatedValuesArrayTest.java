package pattern01_counting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RepeatedValuesArrayTest {

    private final RepeatedValuesArray sut = new RepeatedValuesArray();

    @Test
    void exampleFromTask() {
        assertEquals(2, sut.solution(new int[]{3, 1, 3, 2, 1, 3}));
    }

    @Test
    void sameValueManyTimesCountsOnce() {
        assertEquals(1, sut.solution(new int[]{5, 5, 5, 5, 5}));
    }

    @Test
    void allDistinctReturnsZero() {
        assertEquals(0, sut.solution(new int[]{5, 4, 3, 2, 1, 6}));
    }

    @Test
    void singleElement() {
        assertEquals(0, sut.solution(new int[]{1}));
    }

    @Test
    void exactlyTwiceCounts() {
        assertEquals(1, sut.solution(new int[]{1, 2, 2}));
    }

    @Test
    void maxValueEqualsN() {
        // a legnagyobb megengedett érték (N) is jó helyre kerül-e a tömbben
        assertEquals(1, sut.solution(new int[]{3, 3, 1}));
    }

    @Test
    void largeAllSame() {
        int n = 100_000;
        int[] a = new int[n];
        Arrays.fill(a, 1);
        assertEquals(1, sut.solution(a));
    }

    @Test
    void largeAllDistinct() {
        int n = 100_000;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        assertEquals(0, sut.solution(a));
    }

    @Test
    void largeEveryValueTwice() {
        int n = 100_000;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i / 2 + 1;
        }
        assertEquals(n / 2, sut.solution(a));
    }
}