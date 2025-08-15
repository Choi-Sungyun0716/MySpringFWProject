package assignment.user.di.annot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testUserServiceWiring() {
        // 1. UserService 주입 확인
        assertNotNull(userService, "UserService가 주입되지 않았습니다.");

        // 2. UserRepository 주입 확인
        assertNotNull(userService.getUserRepository(), "UserRepository가 주입되지 않았습니다.");

        // 3. UserRepository의 dbType이 MySQL인지 확인
        assertEquals("MySQL", userService.getUserRepository().getDbType(), "DB 타입이 MySQL이 아닙니다.");

        // 4. SecurityService 주입 확인
        assertNotNull(userService.getSecurityService(), "SecurityService가 주입되지 않았습니다.");

        // 5. registerUser()가 true를 반환하는지 확인
        boolean result = userService.registerUser("user01", "홍길동", "password123");
        assertTrue(result, "registerUser()가 true를 반환하지 않았습니다.");
    }
}
