package test;

import org.redisson.Redisson;
import org.redisson.config.Config;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Archibald on 2/8/2017.
 */
public class Test2 {
    public static void main(String [] args){
        // 1.初始化
        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.auth("wuyunu1230");
        String mykey = jedis.get("mykey");
        System.out.println(mykey);
        jedis.lpush("kecheng","java");
        jedis.lpush("kecheng","php");
        jedis.lpush("kecheng","mysql");
        List list=jedis.lrange("kecheng",0,1);
        for(int i=0;i<list.size();i++){
            System.out.println(i+" values is "+list.get(i));
        }
        System.out.println();
        Map map=new HashMap();
        map.put("name","zz1265");
        map.put("age","22");
        map.put("qq","123456");
        jedis.hmset("my",map);
        map.put("sex","男");
        map.remove("name");
        map.put("name","zz");
        jedis.hmset("my",map);
        Iterator iterator=jedis.hkeys("my").iterator();
        while (iterator.hasNext()){
            String next = (String) iterator.next();
            System.out.println(next+":"+jedis.hmget("my",next));
        }
//        Config config = new Config();
//        config.setConnectionPoolSize(10);
//        config.addAddress("127.0.0.1:6379");
//        Redisson redisson = Redisson.create(config);
//        System.out.println("reids连接成功...");

//        // 2.测试concurrentMap,put方法的时候就会同步到redis中
//        ConcurrentMap<String, Object> map = redisson.getMap("FirstMap");
//        map.put("wuguowei", "男");
//        map.put("zhangsan", "nan");
//        map.put("lisi", "女");
//
//        ConcurrentMap resultMap = redisson.getMap("FirstMap");
//        System.out.println("resultMap==" + resultMap.keySet());
//
//        // 2.测试Set集合
//        Set mySet = redisson.getSet("MySet");
//        mySet.add("wuguowei");
//        mySet.add("lisi");
//
//        Set resultSet = redisson.getSet("MySet");
//        System.out.println("resultSet===" + resultSet.size());

//        //3.测试Queue队列
//        Queue myQueue = redisson.getQueue("FirstQueue");
//        myQueue.add("wuguowei");
//        myQueue.add("lili");
//        myQueue.add("zhangsan");
//        myQueue.peek();
//        myQueue.poll();
//
//        Queue resultQueue=redisson.getQueue("FirstQueue");
//        System.out.println("resultQueue==="+resultQueue);

        // 关闭连接
//        redisson.shutdown();
    }
    static void operate(StringBuffer x,StringBuffer y){
        x.append(y);
        y=x;
    }
    public static int getNo(){
        try {
            int j=10/0;
            return 1;
        }catch (Exception e){
            return 2;
        }
        finally {
            return 3;
        }
    }
}
