package com.trendtalk.app.repository.interfaces;

import com.trendtalk.app.repository.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClothes extends JpaRepository<Clothes, Long> {
    // Burada Clothes entity ile ilgili özel sorgularınızı tanımlayabilirsiniz.
}
