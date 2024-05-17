import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class RestApiDisplayTest {
    @Test
    public void displayTest() throws InterruptedException {
        RestApiDisplay display = new RestApiDisplay();
        List<RequestTask> requestTasks = display.requestApi();
        int size = requestTasks.size();
        CountDownLatch countDownLatch = new CountDownLatch(size);
        requestTasks.forEach(t -> {
            t.setLatch(countDownLatch);
            display.POOL.submit(t);
        });
        countDownLatch.await();
    }

    @Test
    public void httpTest() throws Exception {
        HSBCHttpUtils.doGet("https://jsonplaceholder.typicode.com/users");
    }

}
