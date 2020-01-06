package abc.rpc.dubbo;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubboConfiguration
@SpringBootApplication
public class ConsumerSpringApplication {


    public static void main(String[] args) {
        SpringApplication.run(ConsumerSpringApplication.class);
    }

}
