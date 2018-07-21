import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.time.*;

import static org.junit.jupiter.api.Assertions.*;


class StringTest {

    private String str;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Initialize connection to database");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Clean up connection to database");
    }

    @BeforeEach
    void beforeEach(TestInfo info) {
        System.out.println("Initialize Test Data for " + info.getDisplayName());
        System.out.println("Tags: " + info.getTags());
        System.out.println("Test class" + info.getTestClass());
        System.out.println("Test method: " + info.getTestMethod());
    }

    @AfterEach
    void afterEach(TestInfo info) {
        System.out.println("Clean up Test Data for " + info.getDisplayName());
    }

    @ValueSource(strings = {"ABCD", "", "ABC", "A", "DEF"})
    void lengthGreaterThanZeroUsingParameterizedTest(String str) {
        assertTrue(str.length() > 0);
    }

    @ParameterizedTest(name = "{0} to upper case is {1}")
    @CsvSource(value = {"abcd,ABCD", "abc,ABC", "'',''", "abcdefg,ABCDEFG"})
    void upperCase(String word, String capitalizedWord) {
        assertEquals(capitalizedWord, word.toUpperCase());
    }

    @ParameterizedTest(name = "{0} length is {1}")
    @CsvSource(value = {"abcd, 4", "abc, 3", "'', 0", "abcdefg, 7"})
    void length(String word, int expectedLength) {
        assertEquals(expectedLength, word.length());
    }

    @Test
    void performanceTest(){
        assertTimeout(Duration.ofSeconds(2), () -> {
            for (int i = 0 ; i < 1000000; i++){
                int j = i;
                System.out.println(j);
            }
        });
    }

    @Test
    @Disabled
    @DisplayName("When length is null, throws an exception")
    void lengthException() {
        String str = null;
        assertThrows(NullPointerException.class, () -> {
            str.length();
        });
    }

    @Test
    void test() {

        int actualLength = "ABCD".length();
        int expectedLength = 4;

        assertEquals(expectedLength, actualLength);
    }

    @Test
    void toUpperCase() {
        String str = "abcd";
        String result = str.toUpperCase();

        assertEquals("ABCD", result);

    }

    @Test
    void pro() {
        Integer integer1 = 20;
        Integer integer2 = 20;
        Integer integer3 = null;

        assertEquals(integer1, integer2);
    }

    @Test
    @RepeatedTest(10)
    void containsBasic() {
        assertFalse("abcde".contains("ijk"));
    }

    @Test
    void splitBasic() {
        String str = "abc def ghi";
        String[] result = str.split(" ");

        assertEquals(3, result.length);
        assertArrayEquals(new String[]{"abc", "def", "ghi"}, result);
    }

    @Nested
    @DisplayName("For an empty string")
    class EmptyStringTests {

        @BeforeEach
        void setToEmpty() {
             str = "";
        }

        @Test
        @DisplayName("Length is zero")
        void lengthIsZero() {
            assertEquals(0, str.length());
        }

        @Test
        @DisplayName("Upper case is empty")
        void uppercaseIsEmpty(){
            assertEquals("", str.toUpperCase());
        }

    }

    @Nested
    @DisplayName("For a large string")
    class LargeStringTest {
        @BeforeEach
        void setLargeString(){
            str = "fweijfiowejfioaejfae";
        }

        @Test
        @DisplayName("String is not empty")
        void isNotEmpty(){
            assertNotEquals(0, str.length());
        }

    }

}
