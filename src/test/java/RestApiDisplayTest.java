import org.junit.Test;

public class RestApiDisplayTest {
    @Test
    public void displayTest() throws InterruptedException {
        RestApiDisplay display = new RestApiDisplay();
        display.displayResult();
    }


    @Test
    public void httpTest() throws Exception {
        HSBCHttpUtils.doGet("https://www.baidu.com/");
    }

}
