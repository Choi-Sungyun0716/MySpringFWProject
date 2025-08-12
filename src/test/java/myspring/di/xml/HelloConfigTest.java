package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.xml.config.HelloConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloConfig.class)

public class HelloConfigTest {

	@Autowired
	Hello hello;
	
	@Resource(name ="stringPrinter")
	Printer printer;
	
	@Test
	void hello전략32() {
		System.out.println(hello.sayHello());
		
		hello.print();
		
		System.out.println(printer.toString());
		
		for(String name: hello.getNames())
		{
			System.out.println(name);
		}
		
		assertEquals(3, hello.getNames().size());
	}
	
	
}
