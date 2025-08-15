package assignment.notification.di.annot;

import org.springframework.stereotype.Component;


public interface NotificationService {
    void sendNotification(String message);
}