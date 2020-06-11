
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class TestGuava {
    @Test
    public void t1() throws ExecutionException {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder().expireAfterAccess(5, TimeUnit.MINUTES).maximumSize(10).build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                System.out.println("访问数据库了");
                if(key.equals("username")){
                    return "hello";
                }
                return null;
            }
        });
        //第一次才访问数据库 其余从缓存里读
        String username = cache.get("username");
        System.out.println(username);
        System.out.println(cache.get("username"));
        //手动过期
        cache.invalidate("username");
    }

}
