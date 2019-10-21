package com.codegym.service.Impl;

import com.codegym.model.TypeProduct;
import com.codegym.repository.TypeProdecuRepository;
import com.codegym.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;

public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeProdecuRepository typeProdecuRepository;


    @Override
    public Iterable<TypeProduct> findAll() {
        return typeProdecuRepository.findAll();
    }

    @Override
    public TypeProduct findById(Long id) {
        return typeProdecuRepository.findOne(id);
    }

    @Override
    public void save(TypeProduct typeProduct) {
typeProdecuRepository.save(typeProduct);
    }

    @Override
    public void delete(Long id) {
typeProdecuRepository.delete(id);
    }
}
