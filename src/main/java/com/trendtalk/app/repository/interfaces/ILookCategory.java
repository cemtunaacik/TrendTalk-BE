package com.trendtalk.app.repository.interfaces;

import com.trendtalk.app.repository.entity.LookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILookCategory extends JpaRepository<LookCategory, Long> {
    // Custom queries for the LookCategory entity can be defined here.
}
