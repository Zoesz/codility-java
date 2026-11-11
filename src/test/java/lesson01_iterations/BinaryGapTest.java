package lesson01_iterations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryGapTest {

    @Test
    void gapInMiddle(){
        assertEquals(5, new BinaryGap().solution(1041));
    }

    @Test
    void onlyZeroes(){
        assertEquals(0, new BinaryGap().solution(32));
    }

    @Test
    void trailingZerosAreNotAGap(){
        assertEquals(0, new BinaryGap().solution(15));
    }

    @Test
    void validValue529(){
        assertEquals(4, new BinaryGap().solution(529));
    }

    @Test
    void maxValue(){
        assertEquals(0, new BinaryGap().solution(Integer.MAX_VALUE));
    }
}