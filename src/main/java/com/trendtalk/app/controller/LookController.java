package com.trendtalk.app.controller;

import com.trendtalk.app.repository.entity.Look;
import com.trendtalk.app.service.ILookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/looks")
public class LookController {

    private final ILookService lookService;

    @Autowired
    public LookController(ILookService lookService) {
        this.lookService = lookService;
    }

    @PostMapping
    public ResponseEntity<Look> createLook(@RequestBody Look look) {
        return ResponseEntity.ok(lookService.createLook(look));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Look> updateLook(@PathVariable Long id, @RequestBody Look look) {
        return ResponseEntity.ok(lookService.updateLook(id, look));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLook(@PathVariable Long id) {
        lookService.deleteLook(id);
        return ResponseEntity.ok().build();
    }

    // Other endpoints...
}
