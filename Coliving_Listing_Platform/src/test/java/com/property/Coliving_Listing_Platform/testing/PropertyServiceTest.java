package com.property.Coliving_Listing_Platform.testing;

import com.property.Coliving_Listing_Platform.models.Property;
import com.property.Coliving_Listing_Platform.repository.PropertyRepository;
import com.property.Coliving_Listing_Platform.service.PropertyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class PropertyServiceTest {

    @Mock
    private PropertyRepository propertyRepository;
    private PropertyService propertyService;

    @BeforeEach
    void setUp() {
        this.propertyService= new PropertyService(this.propertyRepository);
    }

    @Test
    void saveProperty() {
        Property property = new Property();
        property.setPropertyName("Isthara coliving");
        when(propertyRepository.save(property)).thenReturn(property);
        assertEquals(property,propertyService.saveProperty(property));
    }

    @Test
    void getProperties() {
        propertyService.getProperties();
        verify(propertyRepository).findAll();
    }

    @Test
    void getProperty() {
        propertyService.getProperty(UUID.fromString("61c53992-f0aa-4592-9740-70f7a0de5aa5"));
        assertThat(propertyRepository.findById(UUID.fromString("61c53992-f0aa-4592-9740-70f7a0de5aa5")));
    }

    @Test
    void deleteProperty() {
        Property property = new Property();
        property.setPropertyName("Isthara coliving");
        propertyService.deleteProperty(property.getPropertyId());
        verify(propertyRepository, times(1)).deleteById(property.getPropertyId());
    }

    @Test
    void listingWithPagination() {
        List<Property> propertyList = (List<Property>) propertyRepository.findAll();
        for(Property property : propertyList){
            assertThat(propertyList).isNotNull();
        }
    }

    @Test
    void findPropertyByRegexpName() {
        List<Property> propertyList = propertyRepository.findPropertyByRegexpName("Isthara Coliving");
        for(Property property : propertyList){
            String name = property.getPropertyName();
            assertThat(name).isEqualTo("Isthara Coliving");
        }
    }

    @Test
    void findPropertyByCity() {
        List<Property> propertyList = propertyRepository.findPropertyByCity("Hyderabad");
        for(Property property : propertyList){
            String name = property.getAddress().getCity();
            assertThat(name).isEqualTo("Hyderabad");
        }
    }

    @Test
    void filterProperty() {
        List<Property> propertyList = propertyRepository.findPropertyByCity("Hyderabad");
        for(Property property: propertyList){
            String name = property.getAddress().getCity();
            assertThat(name).isEqualTo("Hyderabad");
        }
    }
}