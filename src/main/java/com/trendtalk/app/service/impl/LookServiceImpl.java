package com.trendtalk.app.service.impl;

import com.trendtalk.app.repository.interfaces.ILook;
import com.trendtalk.app.repository.entity.Look;
import com.trendtalk.app.service.ILookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LookServiceImpl implements ILookService {

    private final ILook lookRepository;

    @Autowired
    public LookServiceImpl(ILook lookRepository) {
        this.lookRepository = lookRepository;
    }

    @Override
    public Look createLook(Look look) {
        // Business logic to create a look
        return lookRepository.save(look);
    }

    @Override
    public Look updateLook(Long id, Look look) {
        // Business logic to update a look
        return lookRepository.save(look);
    }

    @Override
    public void deleteLook(Long id) {
        // Business logic to delete a look
        lookRepository.deleteById(id);
    }

    // Other method implementations...
}
