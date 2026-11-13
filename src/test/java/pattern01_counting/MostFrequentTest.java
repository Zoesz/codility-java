package pattern01_counting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MostFrequentTest {

    private final MostFrequent sut = new MostFrequent();

    @Test
    void exampleClearWinner() {
        assertEquals(3, sut.solution(new int[]{3, 1, 3, 2, 1, 3}));
    }

    @Test
    void winnerIsNotEqualToItsCount() {
        // a 2-es kétszer fordul elő: a SZÁMOT kell visszaadni, nem a darabszámot
        assertEquals(2, sut.solution(new int[]{2, 2, 1}));
    }

    @Test
    void singleElement() {
        assertEquals(1, sut.solution(new int[]{1}));
    }

    @Test
    void tieReturnsSmallest() {
        assertEquals(1, sut.solution(new int[]{1, 3, 3, 1}));
    }

    @Test
    void tieWhenLargerComesFirst() {
        // a 3-as éri el előbb a 2-es darabszámot, mégis az 1 a helyes válasz
        assertEquals(1, sut.solution(new int[]{3, 3, 1, 1}));
    }

    @Test
    void allDistinctReturnsSmallest() {
        // mindenki egyszer fordul elő → döntetlen mindenki között
        assertEquals(1, sut.solution(new int[]{4, 2, 3, 1}));
    }

    @Test
    void maxValueEqualsNWins() {
        assertEquals(4, sut.solution(new int[]{4, 1, 4, 2}));
    }

    @Test
    void largeAllSame() {
        int n = 100_000;
        int[] a = new int[n];
        Arrays.fill(a, 7);
        assertEquals(7, sut.solution(a));
    }

    @Test
    void largeAllDistinct() {
        int n = 100_000;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = n - i;          // N, N-1, ..., 1 (csökkenő sorrend!)
        }
        assertEquals(1, sut.solution(a));
    }

    @Test
    void largeMaxValueWins() {
        int n = 100_000;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        a[0] = n;                  // az N kétszer fordul elő, mindenki más legfeljebb egyszer
        assertEquals(n, sut.solution(a));
    }

    @Test
    void tryIt() {
        int[] a = {3, 3, 1, 1, 2};
        System.out.println("Eredmény: " + sut.solution(a));
    }
}