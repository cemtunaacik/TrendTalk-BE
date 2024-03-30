package com.trendtalk.app.service;

import com.trendtalk.app.repository.entity.Clothes;

public interface IClothesService {
    Clothes addClothes(Clothes clothes);
    Clothes updateClothes(Long id, Clothes clothes);
    void deleteClothes(Long id);
    // Diğer iş mantığı metodları...
}
