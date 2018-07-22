import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import java.util.*;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StringHelperTest {

    StringHelper helper = null;

    private String input;
    private String expectedOutput;


    public StringHelperTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void beforeEach() {
        helper = new StringHelper();
    }

    @Parameterized.Parameters
    public static Collection<String[]> testConditions() {
        String expectedOutputs[][] = {{"AACD", "CD"},
                {"ACD", "CD"}};

        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void testTruncateAInFirstPositions(){
        assertEquals(expectedOutput,
                helper.truncateAInFirst2Positions(input));
    }

    /*@After
    public void afterEach() {

    }

    @Test
    public void truncateAInFirst2PositionsTest_AInFirst2Positions() {

        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
    }

    @Test
    public void truncateAInFirst2PositionsTest_AInFirstPosition() {

        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }

    @Test
    public void areFirstAndLastTwoCharactersTheSameTest_BasicNegativeScenario() {

        assertFalse("Dummy string",
                helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
    }

    @Test
    public void areFirstAndLastTwoCharactersTheSameTest_BasicPositiveScenario() {

        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
    }*/

}
