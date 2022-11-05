package pwo.lab13;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(PER_CLASS)
public class TextTest {

    @ParameterizedTest
    @ValueSource(strings = {"aa234bb34sd", "1 2 3 4 5", "xx12x12x1x"})
    void cont5DigTest1(String str) {
        System.out.println("Test pozytywny dla: " + str);
        assertTrue(Text.cont5Dig(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"aa23bb34sd", "1 2 x 4 5", "xx1x12x1x"})
    void cont5DigTest2(String str) {
        System.out.println("Test negatywny dla: " + str);
        assertFalse(Text.cont5Dig(str));
    }

    Stream<Arguments> numberCountTest1() {
        return Stream.of(
                arguments("aabb4sd", 1),
                arguments("1 2 x ", 2),
                arguments("xx1x2x1x", 3)
        );
    }

    @ParameterizedTest
    @MethodSource
    void numberCountTest1(String str, int value) {
        System.out.println("Test pozytywny dla: " + str);
        assertEquals(Text.numberCount(str), value);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aa23bb34sd", "1 2 x 4 5", "xx1x12x1x"})
    void numberCountTest2(String str) {
        System.out.println("Test negatywny dla: " + str);
        assertEquals(Text.numberCount(str), 4);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aabbsd", " x ", "xxxxx"})
    void noNumbersTest1(String str) {
        System.out.println("Test pozytywny dla: " + str);
        assertTrue(Text.noDigits(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"aa23bb34sd", "1 2 x 4 5", "xx1x12x1x"})
    void noNumbersTest2(String str) {
        System.out.println("Test negatywny dla: " + str);
        assertFalse(Text.noDigits(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2334", "1245", "1121"})
    void onlyDigitsTest1(String str) {
        System.out.println("Test pozytywny dla: " + str);
        assertTrue(Text.onlyDigits(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"aa23bb34sd", "1 2 x 4 5", "xx1x12x1x"})
    void onlyDigitsTest2(String str) {
        System.out.println("Test negatywny dla: " + str);
        assertFalse(Text.onlyDigits(str));
    }
}