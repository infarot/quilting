package com.dawid.quilting.controller;

import com.dawid.quilting.constant.Cover;
import com.dawid.quilting.entity.ProductionWorker;
import com.dawid.quilting.entity.QuiltedIndex;
import com.dawid.quilting.entity.QuiltingData;
import com.dawid.quilting.service.QuiltingDataService;
import com.dawid.quilting.wrapper.QuiltingReportWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuiltingDataController {

    private final QuiltingDataService quiltingDataService;

    @Autowired
    public QuiltingDataController(QuiltingDataService quiltingDataService) {
        this.quiltingDataService = quiltingDataService;
    }

    @GetMapping("/")
    public ModelAndView home(ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        return modelAndView;
    }


    @GetMapping("/showAddReportForm")
    public ModelAndView showFormForAdd(ModelAndView model) {
        model.setViewName("addQuiltingReport");
        QuiltingReportWrapper quiltingReportWrapper = new QuiltingReportWrapper();
        model.addObject("quiltingReport", quiltingReportWrapper);

        List<ProductionWorker> productionWorkers = quiltingDataService.getAllProductionWorkers();
        model.addObject("productionWorkers", productionWorkers);

        return model;
    }


    @PostMapping("/addReport")
    public ModelAndView addQuiltingReport(@Valid QuiltingReportWrapper quiltingReportWrapper, BindingResult result) {
        ModelAndView model = new ModelAndView();
        if (result.hasErrors()) {
            model.addObject("quiltingReport", quiltingReportWrapper);
            List<ProductionWorker> productionWorkers = quiltingDataService.getAllProductionWorkers();
            model.addObject("productionWorkers", productionWorkers);
            model.setViewName("addQuiltingReport");
            return model;
        }
        //parse date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate convertedDate = LocalDate.parse(quiltingReportWrapper.getDate(), formatter).plusDays(1);
        //create list of indices
        List<QuiltedIndex> quiltedIndices = new ArrayList<>();
        //create or get quilting data
        QuiltingData quiltingData = quiltingDataService.getQuiltingDataByDate(convertedDate).orElseGet(QuiltingData::new);
        quiltingDataService.removeQuiltedData(quiltingData);
        quiltingData.setDate(convertedDate);
        quiltingData.setOperator(quiltingDataService.getProductionWorker(quiltingReportWrapper.getOperatorId()));

        //lazy fetch of pickers
        ProductionWorker pickerQ1 = quiltingDataService.getProductionWorker(quiltingReportWrapper.getPickerId());
        ProductionWorker pickerQ2 = quiltingDataService.getProductionWorker(quiltingReportWrapper.getPicker2Id());
        ProductionWorker pickerQ3 = quiltingDataService.getProductionWorker(quiltingReportWrapper.getPicker3Id());
        //fill indices list - first quilter
        if (quiltingReportWrapper.getMa75() != null) {
            if (quiltingReportWrapper.getMa75o() == null)
                quiltingReportWrapper.setMa75o(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MALFORS_75.toString(), quiltingReportWrapper.getMa75(), quiltingReportWrapper.getMa75o(), pickerQ1, quiltingData, 1));
        }
        if (quiltingReportWrapper.getMa80() != null) {
            if (quiltingReportWrapper.getMa80o() == null)
                quiltingReportWrapper.setMa80o(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MALFORS_80.toString(), quiltingReportWrapper.getMa80(), quiltingReportWrapper.getMa80o(), pickerQ1, quiltingData, 1));
        }
        if (quiltingReportWrapper.getMa90() != null) {
            if (quiltingReportWrapper.getMa90o() == null)
                quiltingReportWrapper.setMa90o(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MALFORS_90.toString(), quiltingReportWrapper.getMa90(), quiltingReportWrapper.getMa90o(), pickerQ1, quiltingData, 1));
        }
        if (quiltingReportWrapper.getMa140() != null) {
            if (quiltingReportWrapper.getMa140o() == null)
                quiltingReportWrapper.setMa140o(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MALFORS_140.toString(), quiltingReportWrapper.getMa140(), quiltingReportWrapper.getMa140o(), pickerQ1, quiltingData, 1));
        }
        if (quiltingReportWrapper.getMa160() != null) {
            if (quiltingReportWrapper.getMa160o() == null)
                quiltingReportWrapper.setMa160o(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MALFORS_160.toString(), quiltingReportWrapper.getMa160(), quiltingReportWrapper.getMa160o(), pickerQ1, quiltingData, 1));
        }
        if (quiltingReportWrapper.getMo75() != null) {
            if (quiltingReportWrapper.getMo75o() == null)
                quiltingReportWrapper.setMo75o(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MOSHULT_75.toString(), quiltingReportWrapper.getMo75(), quiltingReportWrapper.getMo75o(), pickerQ1, quiltingData, 1));
        }
        if (quiltingReportWrapper.getMo80() != null) {
            if (quiltingReportWrapper.getMo80o() == null)
                quiltingReportWrapper.setMo80o(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MOSHULT_80.toString(), quiltingReportWrapper.getMo80(), quiltingReportWrapper.getMo80o(), pickerQ1, quiltingData, 1));
        }
        if (quiltingReportWrapper.getMo90() != null) {
            if (quiltingReportWrapper.getMo90o() == null)
                quiltingReportWrapper.setMo90o(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MOSHULT_90.toString(), quiltingReportWrapper.getMo90(), quiltingReportWrapper.getMo90o(), pickerQ1, quiltingData, 1));
        }
        if (quiltingReportWrapper.getMo140() != null) {
            if (quiltingReportWrapper.getMo140o() == null)
                quiltingReportWrapper.setMo140o(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MOSHULT_140.toString(), quiltingReportWrapper.getMo140(), quiltingReportWrapper.getMo140o(), pickerQ1, quiltingData, 1));
        }
        if (quiltingReportWrapper.getMo160() != null) {
            if (quiltingReportWrapper.getMo160o() == null)
                quiltingReportWrapper.setMo160o(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MOSHULT_160.toString(), quiltingReportWrapper.getMo160(), quiltingReportWrapper.getMo160o(), pickerQ1, quiltingData, 1));
        }
        //second quilter
        if (quiltingReportWrapper.getMa752() != null) {
            if (quiltingReportWrapper.getMa75o2() == null)
                quiltingReportWrapper.setMa75o2(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MALFORS_75.toString(), quiltingReportWrapper.getMa752(), quiltingReportWrapper.getMa75o2(), pickerQ2, quiltingData, 2));
        }
        if (quiltingReportWrapper.getMa802() != null) {
            if (quiltingReportWrapper.getMa80o2() == null)
                quiltingReportWrapper.setMa80o2(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MALFORS_80.toString(), quiltingReportWrapper.getMa802(), quiltingReportWrapper.getMa80o2(), pickerQ2, quiltingData, 2));
        }
        if (quiltingReportWrapper.getMa902() != null) {
            if (quiltingReportWrapper.getMa90o2() == null)
                quiltingReportWrapper.setMa90o2(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MALFORS_90.toString(), quiltingReportWrapper.getMa902(), quiltingReportWrapper.getMa90o2(), pickerQ2, quiltingData, 2));
        }
        if (quiltingReportWrapper.getMa1402() != null) {
            if (quiltingReportWrapper.getMa140o2() == null)
                quiltingReportWrapper.setMa140o2(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MALFORS_140.toString(), quiltingReportWrapper.getMa1402(), quiltingReportWrapper.getMa140o2(), pickerQ2, quiltingData, 2));
        }
        if (quiltingReportWrapper.getMa1602() != null) {
            if (quiltingReportWrapper.getMa160o2() == null)
                quiltingReportWrapper.setMa160o2(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MALFORS_160.toString(), quiltingReportWrapper.getMa1602(), quiltingReportWrapper.getMa160o2(), pickerQ2, quiltingData, 2));
        }
        if (quiltingReportWrapper.getMo752() != null) {
            if (quiltingReportWrapper.getMo75o2() == null)
                quiltingReportWrapper.setMo75o2(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MOSHULT_75.toString(), quiltingReportWrapper.getMo752(), quiltingReportWrapper.getMo75o2(), pickerQ2, quiltingData, 2));
        }
        if (quiltingReportWrapper.getMo802() != null) {
            if (quiltingReportWrapper.getMo80o2() == null)
                quiltingReportWrapper.setMo80o2(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MOSHULT_80.toString(), quiltingReportWrapper.getMo802(), quiltingReportWrapper.getMo80o2(), pickerQ2, quiltingData, 2));
        }
        if (quiltingReportWrapper.getMo902() != null) {
            if (quiltingReportWrapper.getMo90o2() == null)
                quiltingReportWrapper.setMo90o2(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MOSHULT_90.toString(), quiltingReportWrapper.getMo902(), quiltingReportWrapper.getMo90o2(), pickerQ2, quiltingData, 2));
        }
        if (quiltingReportWrapper.getMo1402() != null) {
            if (quiltingReportWrapper.getMo140o2() == null)
                quiltingReportWrapper.setMo140o2(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MOSHULT_140.toString(), quiltingReportWrapper.getMo1402(), quiltingReportWrapper.getMo140o2(), pickerQ2, quiltingData, 2));
        }
        if (quiltingReportWrapper.getMo1602() != null) {
            if (quiltingReportWrapper.getMo160o2() == null)
                quiltingReportWrapper.setMo160o2(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MOSHULT_160.toString(), quiltingReportWrapper.getMo1602(), quiltingReportWrapper.getMo160o2(), pickerQ2, quiltingData, 2));
        }
        //third quilter
        if (quiltingReportWrapper.getMa753() != null) {
            if (quiltingReportWrapper.getMa75o3() == null)
                quiltingReportWrapper.setMa75o3(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MALFORS_75.toString(), quiltingReportWrapper.getMa753(), quiltingReportWrapper.getMa75o3(), pickerQ3, quiltingData, 3));
        }
        if (quiltingReportWrapper.getMa803() != null) {
            if (quiltingReportWrapper.getMa80o3() == null)
                quiltingReportWrapper.setMa80o3(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MALFORS_80.toString(), quiltingReportWrapper.getMa803(), quiltingReportWrapper.getMa80o3(), pickerQ3, quiltingData, 3));
        }
        if (quiltingReportWrapper.getMa903() != null) {
            if (quiltingReportWrapper.getMa90o3() == null)
                quiltingReportWrapper.setMa90o3(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MALFORS_90.toString(), quiltingReportWrapper.getMa903(), quiltingReportWrapper.getMa90o3(), pickerQ3, quiltingData, 3));
        }
        if (quiltingReportWrapper.getMa1403() != null) {
            if (quiltingReportWrapper.getMa140o3() == null)
                quiltingReportWrapper.setMa140o3(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MALFORS_140.toString(), quiltingReportWrapper.getMa1403(), quiltingReportWrapper.getMa140o3(), pickerQ3, quiltingData, 3));
        }
        if (quiltingReportWrapper.getMa1603() != null) {
            if (quiltingReportWrapper.getMa160o3() == null)
                quiltingReportWrapper.setMa160o3(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MALFORS_160.toString(), quiltingReportWrapper.getMa1603(), quiltingReportWrapper.getMa160o3(), pickerQ3, quiltingData, 3));
        }
        if (quiltingReportWrapper.getMo753() != null) {
            if (quiltingReportWrapper.getMo75o3() == null)
                quiltingReportWrapper.setMo75o3(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MOSHULT_75.toString(), quiltingReportWrapper.getMo753(), quiltingReportWrapper.getMo75o3(), pickerQ3, quiltingData, 3));
        }
        if (quiltingReportWrapper.getMo803() != null) {
            if (quiltingReportWrapper.getMo80o3() == null)
                quiltingReportWrapper.setMo80o3(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MOSHULT_80.toString(), quiltingReportWrapper.getMo803(), quiltingReportWrapper.getMo80o3(), pickerQ3, quiltingData, 3));
        }
        if (quiltingReportWrapper.getMo903() != null) {
            if (quiltingReportWrapper.getMo90o3() == null)
                quiltingReportWrapper.setMo90o3(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MOSHULT_90.toString(), quiltingReportWrapper.getMo903(), quiltingReportWrapper.getMo90o3(), pickerQ3, quiltingData, 3));
        }
        if (quiltingReportWrapper.getMo1403() != null) {
            if (quiltingReportWrapper.getMo140o3() == null)
                quiltingReportWrapper.setMo140o3(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MOSHULT_140.toString(), quiltingReportWrapper.getMo1403(), quiltingReportWrapper.getMo140o3(), pickerQ3, quiltingData, 3));
        }
        if (quiltingReportWrapper.getMo1603() != null) {
            if (quiltingReportWrapper.getMo160o3() == null)
                quiltingReportWrapper.setMo160o3(0);
            quiltedIndices.add(new QuiltedIndex(Cover.MOSHULT_160.toString(), quiltingReportWrapper.getMo1603(), quiltingReportWrapper.getMo160o3(), pickerQ3, quiltingData, 3));
        }

        quiltingData.setQuiltedIndices(quiltedIndices);
        //save to db
        quiltingDataService.addQuiltingData(quiltingData);

        model.setViewName("home");
        return model;
    }
}
