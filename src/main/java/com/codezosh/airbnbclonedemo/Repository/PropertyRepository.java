package com.codezosh.airbnbclonedemo.Repository;

import com.codezosh.airbnbclonedemo.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByUserId(Long userId);
}
