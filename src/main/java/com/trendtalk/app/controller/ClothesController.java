package com.trendtalk.app.controller;

import com.trendtalk.app.repository.entity.Clothes;
import com.trendtalk.app.service.IClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clothes")
public class ClothesController {

    private final IClothesService clothesService;

    @Autowired
    public ClothesController(IClothesService clothesService) {
        this.clothesService = clothesService;
    }

    @PostMapping
    public ResponseEntity<Clothes> addClothes(@RequestBody Clothes clothes) {
        return ResponseEntity.ok(clothesService.addClothes(clothes));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clothes> updateClothes(@PathVariable Long id, @RequestBody Clothes clothes) {
        return ResponseEntity.ok(clothesService.updateClothes(id, clothes));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClothes(@PathVariable Long id) {
        clothesService.deleteClothes(id);
        return ResponseEntity.ok().build();
    }

    // Diğer endpointler...
}
