package com.trendtalk.app.repository.interfaces;

import com.trendtalk.app.repository.entity.ClothesSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClothesSubcategory extends JpaRepository<ClothesSubcategory, Long> {
    // Burada ClothesSubcategory entity ile ilgili özel sorgularınızı tanımlayabilirsiniz.
}
