package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.TypeProduct;
import com.codegym.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TypeController {
    @Autowired
    private TypeService typeService;


    @GetMapping("/create-type")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/type/create");
        modelAndView.addObject("type", new TypeProduct());
        return modelAndView;
    }

    @PostMapping("/create-type")
    public ModelAndView save(@ModelAttribute TypeProduct typeProduct){
        typeService.save(typeProduct);

        ModelAndView modelAndView = new ModelAndView("/type/create");
        modelAndView.addObject("type", new TypeProduct());
        modelAndView.addObject("message", "New product created successfully");
        return modelAndView;
    }
    //list
    @GetMapping("/types")
    public ModelAndView listCustomers(){
        Iterable<TypeProduct> typeProducts = typeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/type/list");
        modelAndView.addObject("types", typeProducts);
        return modelAndView;

    }
    @GetMapping("/edit-type/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        TypeProduct typeProduct = typeService.findById(id);
        if(typeProduct != null) {
            ModelAndView modelAndView = new ModelAndView("/type/edit");
            modelAndView.addObject("type", typeProduct);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-type")
    public String updateCustomer(@ModelAttribute TypeProduct product){
        typeService.save(product);
        return "redirect:types";
    }
    @GetMapping("/delete-type/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        TypeProduct typeProduct = typeService.findById(id);
        if(typeProduct != null) {
            ModelAndView modelAndView = new ModelAndView("/type/delete");
            modelAndView.addObject("type", typeProduct);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-type")
    public String deleteCustomer(@ModelAttribute TypeProduct typeProduct){
        typeService.delete(typeProduct.getId());
        return "redirect:types";
    }
}