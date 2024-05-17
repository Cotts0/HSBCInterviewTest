import java.util.Objects;
import java.util.concurrent.CountDownLatch;

public class RequestTask extends Thread {
    private String url;
    private CountDownLatch latch;

    @Override
    public void run() {
        try {
            // 请求接口
            String result = HSBCHttpUtils.doGet(url);
            if (Objects.nonNull(result)) {
                System.out.println("display the request like this --->");
                System.out.println(result);
            }
        } catch (Exception e) {
            System.out.println("Catch business exception," + e.getMessage());
        } finally {
            latch.countDown();
        }
    }


    public void setUrl(String url) {
        this.url = url;
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }
}