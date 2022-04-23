package tests;

import org.junit.jupiter.api.Test;
import xenon.game.Move;
import xenon.game.Pair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputToIndexesTests {

    @Test
    public void test1(){
        assertEquals(new Pair<>(0, 0), Move.inputToIndexes(1));
    }

    @Test
    public void test2(){
        assertEquals(new Pair<>(0, 1), Move.inputToIndexes(2));
    }

    @Test
    public void test3(){
        assertEquals(new Pair<>(0, 2), Move.inputToIndexes(3));
    }

    @Test
    public void test4(){
        assertEquals(new Pair<>(1, 0), Move.inputToIndexes(4));
    }

    @Test
    public void test5(){
        assertEquals(new Pair<>(1, 1), Move.inputToIndexes(5));
    }

    @Test
    public void test6(){
        assertEquals(new Pair<>(1, 2), Move.inputToIndexes(6));
    }

    @Test
    public void test7(){
        assertEquals(new Pair<>(2, 0), Move.inputToIndexes(7));
    }

    @Test
    public void test8(){
        assertEquals(new Pair<>(2, 1), Move.inputToIndexes(8));
    }

    @Test
    public void test9(){
        assertEquals(new Pair<>(2, 2), Move.inputToIndexes(9));
    }

    @Test
    public void testZeroInput(){
        Throwable exceptionThatWasThrown = assertThrows(IllegalArgumentException.class,
                () -> Move.inputToIndexes(0));
        assertEquals(exceptionThatWasThrown.getMessage(), "ERROR, WRONG INPUT!");
    }

    @Test
    public void testNegativeNumber(){
        Throwable exceptionThatWasThrown = assertThrows(IllegalArgumentException.class,
                () -> Move.inputToIndexes(-4));
        assertEquals(exceptionThatWasThrown.getMessage(), "ERROR, WRONG INPUT!");
    }

    @Test
    public void testBigNumber(){
        Throwable exceptionThatWasThrown = assertThrows(IllegalArgumentException.class,
                () -> Move.inputToIndexes(999_999_999));
        assertEquals(exceptionThatWasThrown.getMessage(), "ERROR, WRONG INPUT!");
    }




}
