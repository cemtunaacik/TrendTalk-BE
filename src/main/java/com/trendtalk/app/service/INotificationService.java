package com.trendtalk.app.service;

import com.trendtalk.app.repository.entity.Notification;

public interface INotificationService {
    Notification createNotification(Notification notification);
    // Diğer iş mantığı metodları...
}
