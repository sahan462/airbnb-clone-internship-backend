package com.codezosh.airbnbclonedemo.service;

import com.codezosh.airbnbclonedemo.Repository.PropertyRepository;
import com.codezosh.airbnbclonedemo.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public Property save(Property property) {
        return propertyRepository.save(property);
    }

    public Optional<Property> findById(Long id) {
        return propertyRepository.findById(id);
    }

    public List<Property> findAll() {
        return propertyRepository.findAll();
    }

    public void deleteById(Long id) {
        propertyRepository.deleteById(id);
    }

    public List<Property> findByUserId(Long userId) {
        return propertyRepository.findByUserId(userId);
    }
}
