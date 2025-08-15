package assignment.notification.di.annot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class NotificationManager {
	
	@Autowired
	private EmailNotificationService emailService;

	@Autowired
	private SmsNotificationService smsService;
    
    public NotificationManager(EmailNotificationService emailService, SmsNotificationService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }
    
    public NotificationService getEmailService() { return emailService; }
    public NotificationService getSmsService() { return smsService; }
    
    public void sendNotificationByEmail(String message) {
        emailService.sendNotification(message);
    }
    
    public void sendNotificationBySms(String message) {
        smsService.sendNotification(message);
    }
}