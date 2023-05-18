package cn.itbill.order;

import cn.itbill.feign.clients.UserClient;
import cn.itbill.user.config.PatternProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itbill.order.mapper")
@SpringBootApplication
@EnableFeignClients(
        clients = {UserClient.class},
        defaultConfiguration = PatternProperties.class)
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    /**
     * 创建RestTemplate并注入spring容器
     */
//    @Bean
//    @LoadBalanced  // 负载均衡
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
}
