import org.junit.*;
import org.junit.rules.*;

public class QuickBeforeAfterTest {

    @Rule public TestName name = new TestName();

    @BeforeClass
    public static void beforeAll(){
        System.out.println("Initialize class");
    }

    @AfterClass
    public static void afterAll(){
        System.out.println("Finalize class");
    }

    @Before
    public void beforeEach(){
        System.out.println("Initialized");
    }

    @After
    public void afterEach(){
        System.out.println("Finalized");
    }

    @Test
    public void test1(){
        System.out.println(name.getMethodName() + " executed");
    }

    @Test
    public void test2(){
        System.out.println(name.getMethodName() + " executed");
    }

}
