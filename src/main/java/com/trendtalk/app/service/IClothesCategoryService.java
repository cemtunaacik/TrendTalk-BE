package com.trendtalk.app.service;

import com.trendtalk.app.repository.entity.ClothesCategory;

public interface IClothesCategoryService {
    ClothesCategory addCategory(ClothesCategory category);
    ClothesCategory updateCategory(Long id, ClothesCategory category);
    void deleteCategory(Long id);
    // Diğer iş mantığı metodları...
}
