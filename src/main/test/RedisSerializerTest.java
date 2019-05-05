import com.whj.springboot.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.serializer.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wuhaijun
 * @Date: 2019/4/23 14:41
 * @Description: 测试redis中集中序列化的性能
 */
@Slf4j
public class RedisSerializerTest {

    public static void main(String[] args) {
        JdkSerializationRedisSerializer jdkSeri = new JdkSerializationRedisSerializer();
        GenericJackson2JsonRedisSerializer genJsonSeri = new GenericJackson2JsonRedisSerializer();
        Jackson2JsonRedisSerializer jack2Seri = new Jackson2JsonRedisSerializer(Object.class);

        User user = new User("1","tom",20,"boy");
        List<Object> list = new ArrayList<>();
        for(int i = 0; i < 1000; i++){
            list.add(user);
        }

        log.info("jdkSeri序列化开始");
        long jdkSeri_Start = System.currentTimeMillis();
        byte[] serialize = jdkSeri.serialize(list);
        log.info("jdkSeri序列化结束，耗时：{}ms，序列化之后的长度为：{}==============",(System.currentTimeMillis()-jdkSeri_Start),serialize.length);
        log.info("jdkSeri开始反序列化");
        long jdkSeri_Start_again = System.currentTimeMillis();
        jdkSeri.deserialize(serialize);
        log.info("jdkSeri反序列化耗时：{}ms===========",(System.currentTimeMillis()-jdkSeri_Start_again));


        log.info("genJsonSeri序列化开始");
        long genJsonSeri_Start = System.currentTimeMillis();
        byte[] serialize1 = genJsonSeri.serialize(list);
        log.info("genJsonSeri序列化结束，耗时：{}ms，序列化之后的长度为：{}==============",(System.currentTimeMillis()-genJsonSeri_Start),serialize1.length);
        log.info("genJsonSeri开始反序列化");
        long genJsonSeri_Start_again = System.currentTimeMillis();
        genJsonSeri.deserialize(serialize1);
        log.info("genJsonSeri反序列化耗时：{}ms===========",(System.currentTimeMillis()-genJsonSeri_Start_again));


        log.info("jack2Seri序列化开始");
        long jack2Seri_Start = System.currentTimeMillis();
        byte[] serialize2 = jack2Seri.serialize(list);
        log.info("jack2Seri序列化结束，耗时：{}ms，序列化之后的长度为：{}===============",(System.currentTimeMillis()-jack2Seri_Start),serialize2.length);
        log.info("jack2Seri开始反序列化");
        long jack2Seri_Start_again = System.currentTimeMillis();
        jack2Seri.deserialize(serialize2);
        log.info("jack2Seri反序列化耗时：{}ms=============",(System.currentTimeMillis()-jack2Seri_Start_again));
    }
}
