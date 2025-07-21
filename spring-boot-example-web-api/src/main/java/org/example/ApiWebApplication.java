package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan("org.example.model") //JPA实体包目录，无需显示声明,会自动从当前目录往下寻找
//@EnableJpaRepositories("org.example.dao.repository") //JPA接口目录，无需显示声明,会自动从当前目录往下寻找
//@EnableTransactionManagement //启用事务管理，已经自动开启，无需显示声明
public class ApiWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiWebApplication.class, args);
    }
}
