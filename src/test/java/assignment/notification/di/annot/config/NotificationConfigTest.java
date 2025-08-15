package assignment.notification.di.annot.config;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import assignment.notification.di.annot.EmailNotificationService;
import assignment.notification.di.annot.NotificationManager;
import assignment.notification.di.annot.SmsNotificationService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {

    @Autowired
    private NotificationManager notificationManager;

    @Autowired
    private EmailNotificationService emailService;

    @Autowired
    private SmsNotificationService smsService;

    @Test
    void testNotificationManagerInjection() {
        // NotificationManager가 주입되었는지 검증
        assertNotNull(notificationManager, "NotificationManager가 주입되지 않았습니다.");
    }

    @Test
    void testEmailNotificationService() {
        // EmailNotificationService가 null 아닌지 확인
        assertNotNull(emailService, "EmailNotificationService가 주입되지 않았습니다.");

        // SMTP 서버 검증
        assertEquals("smtp.gmail.com", emailService.getSmtpServer(), "SMTP 서버 주소가 다릅니다.");

        // 포트 검증
        assertEquals(587, emailService.getPort(), "SMTP 포트가 다릅니다.");

        // NotificationManager를 통한 이메일 전송 테스트
        assertDoesNotThrow(() -> notificationManager.sendNotificationByEmail("테스트 이메일"));
    }

    @Test
    void testSmsNotificationService() {
        // SmsNotificationService가 null 아닌지 확인
        assertNotNull(smsService, "SmsNotificationService가 주입되지 않았습니다.");

        // Provider 검증
        assertEquals("SKT", smsService.getProvider(), "SMS Provider가 다릅니다.");

        // NotificationManager를 통한 SMS 전송 테스트
        assertDoesNotThrow(() -> notificationManager.sendNotificationBySms("테스트 SMS"));
    }
}
