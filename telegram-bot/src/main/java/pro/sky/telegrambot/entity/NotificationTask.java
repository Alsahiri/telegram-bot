package pro.sky.telegrambot.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Напоминание
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "notification_tasks")
public class NotificationTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "chat_id", nullable = false)
    private long chatId;

    @Column(nullable = false)
    private String message;

    @Column(name = "notification_data_time", nullable = false)
    private LocalDateTime notificationDataTime;

    public NotificationTask(long chatId, String message, LocalDateTime notificationDataTime) {
        this.chatId = chatId;
        this.message = message;
        this.notificationDataTime = notificationDataTime;
    }
}
