package com.trendtalk.app.controller;

import com.trendtalk.app.repository.entity.LookCategory;
import com.trendtalk.app.service.ILookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lookcategories")
public class LookCategoryController {

    private final ILookCategoryService lookCategoryService;

    @Autowired
    public LookCategoryController(ILookCategoryService lookCategoryService) {
        this.lookCategoryService = lookCategoryService;
    }

    @PostMapping
    public ResponseEntity<LookCategory> createLookCategory(@RequestBody LookCategory lookCategory) {
        return ResponseEntity.ok(lookCategoryService.createLookCategory(lookCategory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LookCategory> updateLookCategory(@PathVariable Long id, @RequestBody LookCategory lookCategory) {
        return ResponseEntity.ok(lookCategoryService.updateLookCategory(id, lookCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLookCategory(@PathVariable Long id) {
        lookCategoryService.deleteLookCategory(id);
        return ResponseEntity.ok().build();
    }

    // Other endpoints...
}
