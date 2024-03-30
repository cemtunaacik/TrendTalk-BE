package com.trendtalk.app.service.impl;

import com.trendtalk.app.repository.interfaces.IClothesSubcategory;
import com.trendtalk.app.repository.entity.ClothesSubcategory;
import com.trendtalk.app.service.IClothesSubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClothesSubcategoryServiceImpl implements IClothesSubcategoryService {

    private final IClothesSubcategory subcategoryRepository;

    @Autowired
    public ClothesSubcategoryServiceImpl(IClothesSubcategory subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    @Override
    public ClothesSubcategory addSubcategory(ClothesSubcategory subcategory) {
        // Alt kategori ekleme iş mantığı
        return subcategoryRepository.save(subcategory);
    }

    @Override
    public ClothesSubcategory updateSubcategory(Long id, ClothesSubcategory subcategory) {
        // Alt kategori güncelleme iş mantığı
        return subcategoryRepository.save(subcategory);
    }

    @Override
    public void deleteSubcategory(Long id) {
        // Alt kategori silme iş mantığı
        subcategoryRepository.deleteById(id);
    }

    // Diğer metodların implementasyonları...
}
