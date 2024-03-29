package abc.rpc.dubbo;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubboConfiguration
@SpringBootApplication
public class ProviderSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderSpringApplication.class, args);
    }

}
