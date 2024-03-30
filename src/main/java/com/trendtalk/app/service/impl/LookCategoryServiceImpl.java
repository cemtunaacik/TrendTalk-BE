package com.trendtalk.app.service.impl;

import com.trendtalk.app.repository.interfaces.ILookCategory;
import com.trendtalk.app.repository.entity.LookCategory;
import com.trendtalk.app.service.ILookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LookCategoryServiceImpl implements ILookCategoryService {

    private final ILookCategory lookCategoryRepository;

    @Autowired
    public LookCategoryServiceImpl(ILookCategory lookCategoryRepository) {
        this.lookCategoryRepository = lookCategoryRepository;
    }

    @Override
    public LookCategory createLookCategory(LookCategory lookCategory) {
        // Business logic to create a look category
        return lookCategoryRepository.save(lookCategory);
    }

    @Override
    public LookCategory updateLookCategory(Long id, LookCategory lookCategory) {
        // Business logic to update a look category
        return lookCategoryRepository.save(lookCategory);
    }

    @Override
    public void deleteLookCategory(Long id) {
        // Business logic to delete a look category
        lookCategoryRepository.deleteById(id);
    }

    // Other method implementations...
}
