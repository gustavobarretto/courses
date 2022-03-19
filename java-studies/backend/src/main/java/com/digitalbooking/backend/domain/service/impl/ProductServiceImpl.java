package com.digitalbooking.backend.domain.service.impl;

import com.digitalbooking.backend.domain.expcetion.ProductNotFoundException;
import com.digitalbooking.backend.domain.filter.ProductFilter;
import com.digitalbooking.backend.domain.model.Category;
import com.digitalbooking.backend.domain.model.Characteristic;
import com.digitalbooking.backend.domain.model.City;
import com.digitalbooking.backend.domain.model.Product;
import com.digitalbooking.backend.domain.repository.ICategoryRepository;
import com.digitalbooking.backend.domain.repository.ICharacteristicRepository;
import com.digitalbooking.backend.domain.repository.ICityRepository;
import com.digitalbooking.backend.domain.repository.IProductRepository;
import com.digitalbooking.backend.domain.repository.specification.ProductSpecification;
import com.digitalbooking.backend.domain.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository repository;
    private final ICategoryRepository categoryRepository;
    private final ICityRepository cityRepository;
    private final ICharacteristicRepository characteristicRepository;

    @Override
    public Product save(Product product) {
        String titleCategory = product.getCategory().getTitle();
        Category category = categoryRepository.findByTitle(titleCategory);
        if(category != null) product.setCategory(category);
        String cityName = product.getCity().getName();
        City city = cityRepository.findByName(cityName);
        if(city != null) product.setCity(city);

        product.setImages(product.getImages() // vinculating the product in all images
                .stream()
                .map(image -> {
                    image.setProduct(product);
                    return image;
                }).collect(Collectors.toSet()));

        product.setCharacteristics(product.getCharacteristics() // vinculating the product in the product's list on the class characteristics
                .stream()
                .map( characteristic -> {
                    // verifying if the characteristic already exists
                    Characteristic c = characteristicRepository.findByName(characteristic.getName());
                    if(c != null) {
                        c.getProducts().add(product);
                        return c;
                    }

                    characteristic.getProducts().add(product);
                    return characteristic;
                }).collect(Collectors.toSet()));

        return product.isNew() ? create(product) : update(product);
    }

    @Override
    public Product findById(String id) {
        return repository.findById(id).orElseThrow( () -> new ProductNotFoundException(id));
    }

    @Override
    public Page<Product> findAll(ProductFilter filter, Pageable pageable) {
        return repository.findAll(ProductSpecification.filterProduct(filter), pageable);
    }

    private Product create(Product p) {
        Product product = repository.save(p);
        repository.flush();
        return product;
    }

    private Product update(Product p) {
        Product product = repository.save(p);
        repository.flush();
        return product;
    }
}
