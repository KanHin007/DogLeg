package com.hb.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.consul.ConsulAutoConfiguration;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryClientConfiguration;
import org.springframework.cloud.consul.discovery.RibbonConsulAutoConfiguration;
import org.springframework.cloud.consul.discovery.configclient.ConsulConfigServerAutoConfiguration;
import org.springframework.cloud.consul.serviceregistry.ConsulAutoServiceRegistrationAutoConfiguration;
import org.springframework.cloud.consul.serviceregistry.ConsulServiceRegistryAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.zookeeper.ZookeeperAutoConfiguration;
import org.springframework.cloud.zookeeper.discovery.RibbonZookeeperAutoConfiguration;
import org.springframework.cloud.zookeeper.discovery.ZookeeperDiscoveryAutoConfiguration;
import org.springframework.cloud.zookeeper.discovery.ZookeeperDiscoveryClientConfiguration;
import org.springframework.cloud.zookeeper.discovery.dependency.DependencyFeignClientAutoConfiguration;
import org.springframework.cloud.zookeeper.discovery.dependency.DependencyRestTemplateAutoConfiguration;
import org.springframework.cloud.zookeeper.discovery.dependency.DependencyRibbonAutoConfiguration;
import org.springframework.cloud.zookeeper.discovery.dependency.ZookeeperDependenciesAutoConfiguration;
import org.springframework.cloud.zookeeper.discovery.watcher.DependencyWatcherAutoConfiguration;
import org.springframework.cloud.zookeeper.serviceregistry.ZookeeperAutoServiceRegistrationAutoConfiguration;
import org.springframework.cloud.zookeeper.serviceregistry.ZookeeperServiceRegistryAutoConfiguration;
import org.springframework.cloud.zookeeper.support.CuratorServiceDiscoveryAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableFeignClients
@EnableDiscoveryClient
// 排除掉eureka的客户端
//@SpringBootApplication(exclude = {EurekaClientAutoConfiguration.class, ConsulAutoConfiguration.class,  RibbonConsulAutoConfiguration.class, ConsulConfigServerAutoConfiguration.class, ConsulAutoServiceRegistrationAutoConfiguration.class, ConsulServiceRegistryAutoConfiguration.class, ConsulDiscoveryClientConfiguration.class})
// 排除掉consul的客户端
//@SpringBootApplication(exclude = {ConsulAutoConfiguration.class})
// 排除掉zookeeper的客户端
//@SpringBootApplication(exclude = {ZookeeperAutoConfiguration.class})
@SpringBootApplication(exclude = {EurekaClientAutoConfiguration.class, ConsulAutoConfiguration.class, RibbonConsulAutoConfiguration.class, ConsulConfigServerAutoConfiguration.class, ConsulAutoServiceRegistrationAutoConfiguration.class, ConsulServiceRegistryAutoConfiguration.class, ConsulDiscoveryClientConfiguration.class, ZookeeperAutoConfiguration.class, RibbonZookeeperAutoConfiguration.class,
        ZookeeperDiscoveryAutoConfiguration.class,
        DependencyFeignClientAutoConfiguration.class,
        DependencyRibbonAutoConfiguration.class,
        DependencyRestTemplateAutoConfiguration.class,
        ZookeeperDependenciesAutoConfiguration.class,
        DependencyWatcherAutoConfiguration.class,
        ZookeeperAutoServiceRegistrationAutoConfiguration.class,
        ZookeeperServiceRegistryAutoConfiguration.class,
        CuratorServiceDiscoveryAutoConfiguration.class,
        ZookeeperDiscoveryClientConfiguration.class})
//@SpringBootApplication(exclude = {EurekaClientAutoConfiguration.class, ConsulAutoConfiguration.class, RibbonConsulAutoConfiguration.class, ConsulConfigServerAutoConfiguration.class, ConsulAutoServiceRegistrationAutoConfiguration.class, ConsulServiceRegistryAutoConfiguration.class, ConsulDiscoveryClientConfiguration.class, ZookeeperAutoConfiguration.class})
public class WalletServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalletServiceApplication.class, args);
    }

}
