package com.gn.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


//@ComponentScan
//@Configuration
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//@EnableJpaRepositories(basePackages = "com.gn.app.dao")/*(scanBasePackages= "com.gn.app")*/

@SpringBootApplication
@ComponentScan("com.gn.app")
public class GnApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GnApplication.class, args);
	}

}

