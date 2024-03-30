package com.trendtalk.app.service.impl;

import com.trendtalk.app.repository.interfaces.IClothes;
import com.trendtalk.app.repository.entity.Clothes;
import com.trendtalk.app.service.IClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClothesServiceImpl implements IClothesService {

    private final IClothes clothesRepository;

    @Autowired
    public ClothesServiceImpl(IClothes clothesRepository) {
        this.clothesRepository = clothesRepository;
    }

    @Override
    public Clothes addClothes(Clothes clothes) {
        // Giysi ekleme iş mantığı
        return clothesRepository.save(clothes);
    }

    @Override
    public Clothes updateClothes(Long id, Clothes clothes) {
        // Giysi güncelleme iş mantığı
        // findById ve save metodlarıyla birlikte kullanılabilir.
        return clothesRepository.save(clothes);
    }

    @Override
    public void deleteClothes(Long id) {
        // Giysi silme iş mantığı
        clothesRepository.deleteById(id);
    }

    // Diğer metodların implementasyonları...
}
