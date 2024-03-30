package com.trendtalk.app.service.impl;

import com.trendtalk.app.repository.interfaces.IClothesCategory;
import com.trendtalk.app.repository.entity.ClothesCategory;
import com.trendtalk.app.service.IClothesCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClothesCategoryServiceImpl implements IClothesCategoryService {

    private final IClothesCategory categoryRepository;

    @Autowired
    public ClothesCategoryServiceImpl(IClothesCategory categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ClothesCategory addCategory(ClothesCategory category) {
        // Kategori ekleme iş mantığı
        return categoryRepository.save(category);
    }

    @Override
    public ClothesCategory updateCategory(Long id, ClothesCategory category) {
        // Kategori güncelleme iş mantığı
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        // Kategori silme iş mantığı
        categoryRepository.deleteById(id);
    }

    // Diğer metodların implementasyonları...
}
