package com.trendtalk.app.service;

import com.trendtalk.app.repository.entity.Look;

public interface ILookService {
    Look createLook(Look look);
    Look updateLook(Long id, Look look);
    void deleteLook(Long id);
    // Other business logic methods...
}
