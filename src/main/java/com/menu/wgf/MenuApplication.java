package com.menu.wgf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

@SpringBootApplication
@MapperScan(basePackages = {"com.menu.wgf.mapper"})
public class MenuApplication {
	public static void main(String[] args) {
		SpringApplication.run(MenuApplication.class, args);
	}
}
