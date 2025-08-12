package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloJUnit5Test {

	ApplicationContext context;

	@BeforeEach
	void createContainer() {
		// 1. Container 객체생성
		context = new GenericXmlApplicationContext("classpath:spring-beans.xml");
	}

	@Test
	void helloBean() {

		// 2. Container가 생서한 Hello 스프링빈을 요청하기
		Hello helloById = (Hello) context.getBean("hello");
		Hello helloByType = (Hello) context.getBean("hello", Hello.class);

		System.out.println(helloById == helloByType);
		Assertions.assertSame(helloById, helloByType);

		assertEquals("Hello 스프링", helloByType.sayHello());
		helloById.print();

		Printer printer = context.getBean("stringPrinter", Printer.class);
		assertEquals("Hello 스프링", printer.toString());
	}

}
