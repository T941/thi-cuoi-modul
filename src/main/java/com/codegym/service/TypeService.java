package com.codegym.service;

import com.codegym.model.TypeProduct;

public interface TypeService {
    Iterable<TypeProduct> findAll();

    TypeProduct findById(Long id);

    void save(TypeProduct typeProduct);

    void delete(Long id);
}
