package com.trendtalk.app.service;

import com.trendtalk.app.repository.entity.LookCategory;

public interface ILookCategoryService {
    LookCategory createLookCategory(LookCategory lookCategory);
    LookCategory updateLookCategory(Long id, LookCategory lookCategory);
    void deleteLookCategory(Long id);
    // Other business logic methods...
}
