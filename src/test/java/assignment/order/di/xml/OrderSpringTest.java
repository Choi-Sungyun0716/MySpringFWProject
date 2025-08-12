package assignment.order.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig  
@ContextConfiguration(locations = "classpath:mylab-order-di.xml") 
public class OrderSpringTest {

    @Autowired
    ShoppingCart shoppingCart;

    @Autowired
    OrderService orderService;

    @Test
    void testShoppingCartBean() {
     
        assertNotNull(shoppingCart);

        
        assertEquals(2, shoppingCart.getProducts().size());

        
        assertEquals("노트북", shoppingCart.getProducts().get(0).getName());

   
        assertEquals("스마트폰", shoppingCart.getProducts().get(1).getName());
        
        
    }

    @Test
    void testOrderServiceBean() {
        
    	orderService.setShoppingCart(shoppingCart);
    	
        assertNotNull(orderService);
        
        assertEquals(950000, orderService.calculateOrderTotal());
        System.out.println(orderService.toString());
        assertEquals("OrderService [shoppingCart=ShoppingCart "
        		+ "[products=[Product [id=P001, name=노트북, price=150000.0], "
        		+ "Product [id=P002, name=스마트폰, price=800000.0]]]]"
        			, orderService.toString());
       
       
    }
}
