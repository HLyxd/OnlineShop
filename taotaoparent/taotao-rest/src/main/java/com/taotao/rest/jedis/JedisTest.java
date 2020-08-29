package com.taotao.rest.jedis;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;

public class JedisTest {
    @Test
    public void testJedisCluster() throws IOException {
        HashSet<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.136.131", 7001));
        nodes.add(new HostAndPort("192.168.136.131", 7002));
        nodes.add(new HostAndPort("192.168.136.131", 7003));
        nodes.add(new HostAndPort("192.168.136.131", 7004));
        nodes.add(new HostAndPort("192.168.136.131", 7005));
        nodes.add(new HostAndPort("192.168.136.131", 7006));

        JedisCluster cluster = new JedisCluster(nodes);

        cluster.set("key1", "1000");
        String string = cluster.get("key1");
        System.out.println(string);

        cluster.close();
    }

}
