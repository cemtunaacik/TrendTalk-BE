package com.trendtalk.app.controller;

import com.trendtalk.app.repository.entity.ClothesCategory;
import com.trendtalk.app.service.IClothesCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class ClothesCategoryController {

    private final IClothesCategoryService categoryService;

    @Autowired
    public ClothesCategoryController(IClothesCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<ClothesCategory> addCategory(@RequestBody ClothesCategory category) {
        return ResponseEntity.ok(categoryService.addCategory(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClothesCategory> updateCategory(@PathVariable Long id, @RequestBody ClothesCategory category) {
        return ResponseEntity.ok(categoryService.updateCategory(id, category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }

    // Diğer endpointler...
}
