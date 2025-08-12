package myspring.di.annot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//container 객체 생성
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class HelloBeanSpringTest {

	@Autowired
	HelloBean hello;

	@Autowired 
	
	@Qualifier("stringPrinterBean") // 없으면 error StringPrinterBean, ConsolePrinterBean 두개가 존재해서
	PrinterBean printer;

	//전략 2의 constructor injection 테스트
	@Test
	@Disabled
	void helloBeanConstructor() {
		assertEquals("Hello 생성자어노테이션", hello.sayHello());
		hello.print();

		assertEquals("Hello 생성자어노테이션", printer.toString());
	}

	// 전략 2의 setter injection 테스트
	@Test
	void helloBean() {
		// System.out.println(hello.sayHello());
		assertEquals("Hello 어노테이션", hello.sayHello());

		hello.print();

		assertEquals("Hello 어노테이션", printer.toString());
		
		assertEquals(3, hello.getNames().size());
	}

}
