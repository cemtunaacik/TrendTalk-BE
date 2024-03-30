package com.trendtalk.app.service.impl;

import com.trendtalk.app.repository.interfaces.ISave;
import com.trendtalk.app.repository.entity.Save;
import com.trendtalk.app.service.ISaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveServiceImpl implements ISaveService {

    private final ISave saveRepository;

    @Autowired
    public SaveServiceImpl(ISave saveRepository) {
        this.saveRepository = saveRepository;
    }

    @Override
    public Save savePost(Save save) {
        // Post kaydetme iş mantığı
        return saveRepository.save(save);
    }

    @Override
    public void unsavePost(Long saveId) {
        // Post kaydı silme iş mantığı
        saveRepository.deleteById(saveId);
    }

    // Diğer metodların implementasyonları...
}
