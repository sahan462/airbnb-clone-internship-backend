package com.codezosh.airbnbclonedemo.controller;

import com.codezosh.airbnbclonedemo.model.Property;
import com.codezosh.airbnbclonedemo.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public ResponseEntity<Property> createProperty( @RequestBody Property property) {
        Property savedProperty = propertyService.save(property);
        return ResponseEntity.ok(savedProperty);
    }

    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {
        List<Property> properties = propertyService.findAll();
        return ResponseEntity.ok(properties);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        Optional<Property> property = propertyService.findById(id);
        if (property.isPresent()) {
            return ResponseEntity.ok(property.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable Long id, @RequestBody Property propertyDetails) {
        Optional<Property> property = propertyService.findById(id);
        if (property.isPresent()) {
            Property updatedProperty = property.get();
            updatedProperty.setName(propertyDetails.getName());
            updatedProperty.setDescription(propertyDetails.getDescription());
            updatedProperty.setAddress(propertyDetails.getAddress());
            updatedProperty.setPricePerNight(propertyDetails.getPricePerNight());
            updatedProperty.setNumberOfBedrooms(propertyDetails.getNumberOfBedrooms());
            updatedProperty.setNumberOfBathrooms(propertyDetails.getNumberOfBathrooms());
            updatedProperty.setDrinkAllowed(propertyDetails.isDrinkAllowed());
            updatedProperty.setPetAllowed(propertyDetails.isPetAllowed());
            updatedProperty.setMaxCheckoutTimeInNights(propertyDetails.getMaxCheckoutTimeInNights());
            updatedProperty.setExtraCharges(propertyDetails.getExtraCharges());

            propertyService.save(updatedProperty);
            return ResponseEntity.ok(updatedProperty);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        propertyService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Property>> getUserProperties(@PathVariable Long userId) {
        List<Property> properties = propertyService.findByUserId(userId);
        return ResponseEntity.ok(properties);
    }
}
