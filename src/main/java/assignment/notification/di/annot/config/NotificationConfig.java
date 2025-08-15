package assignment.notification.di.annot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import assignment.notification.di.annot.EmailNotificationService;
import assignment.notification.di.annot.NotificationManager;
import assignment.notification.di.annot.SmsNotificationService;

@Configuration
public class NotificationConfig {

    @Bean
    public EmailNotificationService emailNotificationService() {
        return new EmailNotificationService("smtp.gmail.com", 587);
    }

    @Bean
    public SmsNotificationService smsNotificationService() {
        return new SmsNotificationService("SKT");
    }

    @Bean
    public NotificationManager notificationManager() {
        return new NotificationManager(emailNotificationService(), smsNotificationService());
    }
}
