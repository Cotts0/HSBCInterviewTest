import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class RequestTask  implements Callable<String> {
    private String url;
    private CountDownLatch latch;

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try {
            // 请求接口
            return HSBCHttpUtils.doGet(url);
        } catch (Exception e) {
            System.out.println("Catch business exception," + e.getMessage());
        } finally {
            latch.countDown();
        }
        return null;
    }
}