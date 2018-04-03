package com.github.pvasilyev.springbootplayground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.io.IOException;

@SpringBootApplication
public class SpringBootPlaygroundApplication extends SpringBootServletInitializer {

    private volatile static WebApplicationContext webApplicationContext;

//    @Override
//    protected WebApplicationContext createRootApplicationContext(ServletContext servletContext) {
//        webApplicationContext = super.createRootApplicationContext(servletContext);
//        return webApplicationContext;
//    }
//
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootPlaygroundApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPlaygroundApplication.class, args);
	}
}

@RestController
class HelloController {

    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {

        return "Hi " + name + " !";

    }
}
