package hnit.llc.cpms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@EnableTransactionManagement
public class CPMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(CPMSApplication.class, args);
	}

	@Bean//注册视图解析器
	public InternalResourceViewResolver setupViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/pages/");//自动添加前缀
		resolver.setSuffix(".jsp");//自动添加后缀
		return resolver;
	}
}
