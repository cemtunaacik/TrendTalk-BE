package com.trendtalk.app.controller;

import com.trendtalk.app.repository.entity.ClothesSubcategory;
import com.trendtalk.app.service.IClothesSubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subcategories")
public class ClothesSubcategoryController {

    private final IClothesSubcategoryService subcategoryService;

    @Autowired
    public ClothesSubcategoryController(IClothesSubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @PostMapping
    public ResponseEntity<ClothesSubcategory> addSubcategory(@RequestBody ClothesSubcategory subcategory) {
        return ResponseEntity.ok(subcategoryService.addSubcategory(subcategory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClothesSubcategory> updateSubcategory(@PathVariable Long id, @RequestBody ClothesSubcategory subcategory) {
        return ResponseEntity.ok(subcategoryService.updateSubcategory(id, subcategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubcategory(@PathVariable Long id) {
        subcategoryService.deleteSubcategory(id);
        return ResponseEntity.ok().build();
    }

    // Diğer endpointler...
}
