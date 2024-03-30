package com.trendtalk.app.service;

import com.trendtalk.app.repository.entity.Save;

public interface ISaveService {
    Save savePost(Save save);
    void unsavePost(Long saveId);
    // Diğer iş mantığı metodları...
}
