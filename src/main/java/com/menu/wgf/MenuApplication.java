package com.menu.wgf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = {"com.menu.wgf.mapper","com.menu.wgf.query"})
public class MenuApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(MenuApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(MenuApplication.class, args);
	}
}
