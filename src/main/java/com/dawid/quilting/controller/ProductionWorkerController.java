package com.dawid.quilting.controller;

import com.dawid.quilting.entity.ProductionWorker;
import com.dawid.quilting.repository.ProductionWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductionWorkerController {
    final private ProductionWorkerRepository  productionWorkerRepository;

    @Autowired
    public ProductionWorkerController(ProductionWorkerRepository productionWorkerRepository) {
        this.productionWorkerRepository = productionWorkerRepository;
    }

    @GetMapping("/productionWorkerList")
    public ModelAndView showProductionWorkers(ModelAndView modelAndView){
        modelAndView.addObject("productionWorkers", productionWorkerRepository.findAll());
        modelAndView.setViewName("listProductionWorkers");
        return modelAndView;
    }

    @GetMapping("/showFormForAddProductionWorker")
    public ModelAndView showAddForm(ModelAndView modelAndView){
        modelAndView.addObject("productionWorker", new ProductionWorker());
        modelAndView.setViewName("addProductionWorker");
        return modelAndView;
    }

}
