package com.rental.bikerent.Notification;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//package com.rental.bikerent.Notification;
//
//import com.rental.bikerent.model.User;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//
//public class Notification {
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private Integer notificationId;
//
//    private String message;
//
//    private Date createdAt;
//
//    private boolean isRead;
//
//    @ManyToOne
//    private User user;
//
//    public Notification(){}
//
//    public Notification(String message,Date createdAt,User user){
//        this.message = message;
//        this.createdAt = createdAt;
//        this.user = user;
//        this.isRead = false;
//    }
//
//
//    public Integer getNotificationId() {
//        return notificationId;
//    }
//
//    public void setNotificationId(Integer notificationId) {
//        this.notificationId = notificationId;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public Date getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public boolean isRead() {
//        return isRead;
//    }
//
//    public void setRead(boolean isRead) {
//        this.isRead = isRead;
//    }
//}
@RestController
public class Notification {

    @GetMapping("/send-notification")
    public String sendNotification() {
        // Create a JavaScript snippet to log a message in the browser console
        String jsScript = "console.log('Hello from Java!');";
        return "<script>" + jsScript + "</script>";
    }
}
