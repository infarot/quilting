package com.dawid.quilting.controller;

import com.dawid.quilting.entity.ProductionWorker;
import com.dawid.quilting.repository.ProductionWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ProductionWorkerController {
    final private ProductionWorkerRepository productionWorkerRepository;

    @Autowired
    public ProductionWorkerController(ProductionWorkerRepository productionWorkerRepository) {
        this.productionWorkerRepository = productionWorkerRepository;
    }

    @GetMapping("/productionWorkerList")
    public ModelAndView showProductionWorkers(ModelAndView modelAndView) {
        modelAndView.addObject("productionWorkers", productionWorkerRepository.findAll());
        modelAndView.setViewName("listProductionWorkers");
        return modelAndView;
    }

    @GetMapping("/showFormForAddProductionWorker")
    public ModelAndView showAddForm(ModelAndView modelAndView) {
        modelAndView.addObject("productionWorker", new ProductionWorker());
        modelAndView.setViewName("addProductionWorker");
        return modelAndView;
    }

    @PostMapping("/addProductionWorker")
    public ModelAndView addProductionWorker(@Valid @ModelAttribute("productionWorker") ProductionWorker productionWorker, BindingResult result, ModelAndView model) {
        if (result.hasErrors()) {
            model.addObject("productionWorker", productionWorker);
            model.setViewName("addProductionWorker");
            return model;
        }
        productionWorkerRepository.save(productionWorker);
        model.setViewName("home");
        return model;
    }

    @PostMapping("/showFormForUpdate")
    public ModelAndView showFormForUpdate(@RequestParam("productionWorkerId") int id, ModelAndView model) {
        ProductionWorker productionWorker = productionWorkerRepository.getOne(id);
        model.addObject("productionWorker", productionWorker);
        model.setViewName("addProductionWorker");
        return model;
    }

}
