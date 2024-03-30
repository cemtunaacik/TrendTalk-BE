package com.trendtalk.app.service;

import com.trendtalk.app.repository.entity.ClothesSubcategory;

public interface IClothesSubcategoryService {
    ClothesSubcategory addSubcategory(ClothesSubcategory subcategory);
    ClothesSubcategory updateSubcategory(Long id, ClothesSubcategory subcategory);
    void deleteSubcategory(Long id);
    // Diğer iş mantığı metodları...
}
