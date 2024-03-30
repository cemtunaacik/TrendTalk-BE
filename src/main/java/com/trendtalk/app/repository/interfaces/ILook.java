package com.trendtalk.app.repository.interfaces;

import com.trendtalk.app.repository.entity.Look;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILook extends JpaRepository<Look, Long> {
    // Custom queries for the Look entity can be defined here.
}
