package com.codegym.formatter;


import com.codegym.model.TypeProduct;
import com.codegym.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class TypeFormatter implements Formatter<TypeProduct> {

    private TypeService typeService;

    @Autowired
    public TypeFormatter(TypeService typeService) {
        this.typeService = typeService;
    }

    @Override
    public TypeProduct parse(String text, Locale locale) throws ParseException {
        return typeService.findById(Long.parseLong(text));
    }

    @Override
    public String print(TypeProduct object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
