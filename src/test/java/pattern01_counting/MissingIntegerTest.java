package pattern01_counting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissingIntegerTest {

    private final MissingInteger sut = new MissingInteger();

    // --- a feladat példái ---

    @Test
    void exampleWithGap() {
        assertEquals(5, sut.solution(new int[]{1, 3, 6, 4, 1, 2}));
    }

    @Test
    void exampleAllPresent() {
        assertEquals(4, sut.solution(new int[]{1, 2, 3}));
    }

    @Test
    void exampleAllNegative() {
        assertEquals(1, sut.solution(new int[]{-1, -3}));
    }

    // --- szélső esetek ---

    @Test
    void singleOne() {
        assertEquals(2, sut.solution(new int[]{1}));
    }

    @Test
    void singleNotOne() {
        assertEquals(1, sut.solution(new int[]{2}));
    }

    @Test
    void zeroIsNotPositive() {
        assertEquals(1, sut.solution(new int[]{0}));
    }

    @Test
    void duplicatesOnly() {
        assertEquals(2, sut.solution(new int[]{1, 1, 1, 1}));
    }

    @Test
    void unorderedFullRange() {
        assertEquals(4, sut.solution(new int[]{3, 1, 2}));
    }

    @Test
    void valueLargerThanN() {
        // a tömbméret-hiba ezen bukott volna el
        assertEquals(2, sut.solution(new int[]{1, 1_000_000}));
    }

    @Test
    void onlyHugeValue() {
        assertEquals(1, sut.solution(new int[]{1_000_000}));
    }

    @Test
    void minAndMaxValues() {
        assertEquals(1, sut.solution(new int[]{-1_000_000, 1_000_000}));
    }

    // --- nagy bemenetek (teljesítmény) ---

    @Test
    void largeFullRange() {
        int n = 100_000;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = n - i;              // N, N-1, ..., 1
        }
        assertEquals(n + 1, sut.solution(a));
    }

    @Test
    void largeGapInMiddle() {
        int n = 100_000;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        a[n / 2] = -5;                 // az n/2 + 1 hiányzik
        assertEquals(n / 2 + 1, sut.solution(a));
    }

    @Test
    void largeAllNegative() {
        int n = 100_000;
        int[] a = new int[n];
        java.util.Arrays.fill(a, -1_000_000);
        assertEquals(1, sut.solution(a));
    }

    @Test
    void largeAllHuge() {
        int n = 100_000;
        int[] a = new int[n];
        java.util.Arrays.fill(a, 1_000_000);
        assertEquals(1, sut.solution(a));
    }
}