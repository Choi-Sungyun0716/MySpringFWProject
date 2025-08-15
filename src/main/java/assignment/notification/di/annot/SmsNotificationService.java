package assignment.notification.di.annot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class SmsNotificationService implements NotificationService {
	
	
    private String provider;
    
    public SmsNotificationService(String provider) {
        this.provider = provider;
    }
    
    public String getProvider() { return provider; }
    
    @Override
    public void sendNotification(String message) {
        System.out.println("SMS 알림 전송: " + message + " (제공업체: " + provider + ")");
    }
}