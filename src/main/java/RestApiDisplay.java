import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

/**
 * 汇丰面试测试题
 * <p>
 * Write a program in Java to asynchronously fetch data from two REST APIs concurrently and display the result.
 * https://jsonplaceholder.typicode.com/users
 * https://jsonplaceholder.typicode.com/posts
 * If one of the APIs returns an error or takes too long to respond, the program should log the error but continue to display the response from the other API.
 * The program should make use of multi-threading to fetch data from both APIs concurrently and improve the program’s performance.
 *
 * @author Cotts
 */
@Component
public class RestApiDisplay {

    public final ThreadPoolExecutor POOL = new ThreadPoolExecutor(4, 8,
            60, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(16),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

    final static String userUrl = "https://jsonplaceholder.typicode.com/users";
    final static String postsUrl = "https://jsonplaceholder.typicode.com/posts";


    public List<RequestTask> requestApi() {
        List<RequestTask> requestTasks = new ArrayList<>(2);
        RequestTask taskUsers = new RequestTask();
        taskUsers.setUrl(userUrl);
        requestTasks.add(taskUsers);

        RequestTask taskPosts = new RequestTask();
        taskPosts.setUrl(postsUrl);
        requestTasks.add(taskPosts);
        return requestTasks;
    }


}
