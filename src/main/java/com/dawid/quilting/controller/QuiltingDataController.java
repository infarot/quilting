package com.dawid.quilting.controller;

import com.dawid.quilting.entity.ProductionWorker;
import com.dawid.quilting.entity.QuiltedIndex;
import com.dawid.quilting.entity.QuiltingData;
import com.dawid.quilting.exception.ResourceNotFoundException;
import com.dawid.quilting.service.QuiltingDataService;
import com.dawid.quilting.wrapper.QuiltingReportWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/showAddReportForm")
    public String showFormForAdd(Model model) {

        QuiltingReportWrapper quiltingReportWrapper = new QuiltingReportWrapper();
        model.addAttribute("quiltingReport", quiltingReportWrapper);

        List<ProductionWorker> productionWorkers = quiltingDataService.getAllProductionWorkers();
        model.addAttribute("productionWorkers", productionWorkers);
        return "addQuiltingReport";
    }


    @PostMapping("/addReport")
    public String addQuiltingReport(@RequestParam("operatorId") Integer operatorId,
                                    @RequestParam("date") String date,
                                    @RequestParam("pickerId") Integer pickerId,
                                    @RequestParam("ma75") Integer ma75,
                                    @RequestParam("ma75o") Integer ma75o,
                                    @RequestParam("ma80") Integer ma80,
                                    @RequestParam("ma80o") Integer ma80o,
                                    @RequestParam("ma90") Integer ma90,
                                    @RequestParam("ma90o") Integer ma90o,
                                    @RequestParam("ma140") Integer ma140,
                                    @RequestParam("ma140o") Integer ma140o,
                                    @RequestParam("ma160") Integer ma160,
                                    @RequestParam("ma160o") Integer ma160o,
                                    @RequestParam("mo75") Integer mo75,
                                    @RequestParam("mo75o") Integer mo75o,
                                    @RequestParam("mo80") Integer mo80,
                                    @RequestParam("mo80o") Integer mo80o,
                                    @RequestParam("mo90") Integer mo90,
                                    @RequestParam("mo90o") Integer mo90o,
                                    @RequestParam("mo140") Integer mo140,
                                    @RequestParam("mo140o") Integer mo140o,
                                    @RequestParam("mo160") Integer mo160,
                                    @RequestParam("mo160o") Integer mo160o,
                                    @RequestParam("picker2Id") Integer picker2Id,
                                    @RequestParam("ma752") Integer ma752,
                                    @RequestParam("ma75o2") Integer ma75o2,
                                    @RequestParam("ma802") Integer ma802,
                                    @RequestParam("ma80o2") Integer ma80o2,
                                    @RequestParam("ma902") Integer ma902,
                                    @RequestParam("ma90o2") Integer ma90o2,
                                    @RequestParam("ma1402") Integer ma1402,
                                    @RequestParam("ma140o2") Integer ma140o2,
                                    @RequestParam("ma1602") Integer ma1602,
                                    @RequestParam("ma160o2") Integer ma160o2,
                                    @RequestParam("mo752") Integer mo752,
                                    @RequestParam("mo75o2") Integer mo75o2,
                                    @RequestParam("mo802") Integer mo802,
                                    @RequestParam("mo80o2") Integer mo80o2,
                                    @RequestParam("mo902") Integer mo902,
                                    @RequestParam("mo90o2") Integer mo90o2,
                                    @RequestParam("mo1402") Integer mo1402,
                                    @RequestParam("mo140o2") Integer mo140o2,
                                    @RequestParam("mo1602") Integer mo1602,
                                    @RequestParam("mo160o2") Integer mo160o2,
                                    @RequestParam("picker3Id") Integer picker3Id,
                                    @RequestParam("ma753") Integer ma753,
                                    @RequestParam("ma75o3") Integer ma75o3,
                                    @RequestParam("ma803") Integer ma803,
                                    @RequestParam("ma80o3") Integer ma80o3,
                                    @RequestParam("ma903") Integer ma903,
                                    @RequestParam("ma90o3") Integer ma90o3,
                                    @RequestParam("ma1403") Integer ma1403,
                                    @RequestParam("ma140o3") Integer ma140o3,
                                    @RequestParam("ma1603") Integer ma1603,
                                    @RequestParam("ma160o3") Integer ma160o3,
                                    @RequestParam("mo753") Integer mo753,
                                    @RequestParam("mo75o3") Integer mo75o3,
                                    @RequestParam("mo803") Integer mo803,
                                    @RequestParam("mo80o3") Integer mo80o3,
                                    @RequestParam("mo903") Integer mo903,
                                    @RequestParam("mo90o3") Integer mo90o3,
                                    @RequestParam("mo1403") Integer mo1403,
                                    @RequestParam("mo140o3") Integer mo140o3,
                                    @RequestParam("mo1603") Integer mo1603,
                                    @RequestParam("mo160o3") Integer mo160o3) {
        //parse date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate convertedDate = LocalDate.parse(date, formatter);
        //create list of indices
        List<QuiltedIndex> quiltedIndices = new ArrayList<>();
        //create or get quilting data
        QuiltingData quiltingData = quiltingDataService.getQuiltingDataByDate(convertedDate).orElseGet(QuiltingData::new);
        quiltingDataService.removeQuiltedData(quiltingData);
        quiltingData.setDate(convertedDate);
        quiltingData.setOperator(quiltingDataService.getProductionWorker(operatorId).orElseThrow(ResourceNotFoundException::new));
        ProductionWorker pickerQ1 = quiltingDataService.getProductionWorker(pickerId).orElseThrow(ResourceNotFoundException::new);
        ProductionWorker pickerQ2 = quiltingDataService.getProductionWorker(picker2Id).orElseThrow(ResourceNotFoundException::new);
        ProductionWorker pickerQ3 = quiltingDataService.getProductionWorker(picker3Id).orElseThrow(ResourceNotFoundException::new);
        //fill indices list - first quilter
        if (ma75 != null) {
            if (ma75o == null)
                ma75o = 0;
            quiltedIndices.add(new QuiltedIndex("Malfors 75", ma75, ma75o, pickerQ1, quiltingData, 1));
        }

        if (ma80 != null) {
            if (ma80o == null)
                ma80o = 0;
            quiltedIndices.add(new QuiltedIndex("Malfors 80", ma80, ma80o, pickerQ1, quiltingData, 1));
        }
        if (ma90 != null) {
            if (ma90o == null)
                ma90o = 0;
            quiltedIndices.add(new QuiltedIndex("Malfors 90", ma90, ma90o, pickerQ1, quiltingData, 1));
        }
        if (ma140 != null) {
            if (ma140o == null)
                ma140o = 0;
            quiltedIndices.add(new QuiltedIndex("Malfors 140", ma140, ma140o, pickerQ1, quiltingData, 1));
        }
        if (ma160 != null) {
            if (ma160o == null)
                ma160o = 0;
            quiltedIndices.add(new QuiltedIndex("Malfors 160", ma160, ma160o, pickerQ1, quiltingData, 1));
        }
        if (mo75 != null) {
            if (mo75o == null)
                mo75o = 0;
            quiltedIndices.add(new QuiltedIndex("Moshult 75", mo75, mo75o, pickerQ1, quiltingData, 1));
        }
        if (mo80 != null) {
            if (mo80o == null)
                mo80o = 0;
            quiltedIndices.add(new QuiltedIndex("Moshult 80", mo80, mo80o, pickerQ1, quiltingData, 1));
        }
        if (mo90 != null) {
            if (mo90o == null)
                mo90o = 0;
            quiltedIndices.add(new QuiltedIndex("Moshult 90", mo90, mo90o, pickerQ1, quiltingData,1));
        }
        if (mo140 != null) {
            if (mo140o == null)
                mo140o = 0;
            quiltedIndices.add(new QuiltedIndex("Moshult 140", mo140, mo140o, pickerQ1, quiltingData,1));
        }
        if (mo160 != null) {
            if (mo160o == null)
                mo160o = 0;
            quiltedIndices.add(new QuiltedIndex("Moshult 160", mo160, mo160o, pickerQ1, quiltingData,1 ));
        }
        // second quilter
        if (ma752 != null) {
            if (ma75o2 == null)
                ma75o2 = 0;
            quiltedIndices.add(new QuiltedIndex("Malfors 75", ma752, ma75o2, pickerQ2, quiltingData, 2));
        }

        if (ma802 != null) {
            if (ma80o2 == null)
                ma80o2 = 0;
            quiltedIndices.add(new QuiltedIndex("Malfors 80", ma802, ma80o2, pickerQ2, quiltingData, 2));
        }
        if (ma902 != null) {
            if (ma90o2 == null)
                ma90o2 = 0;
            quiltedIndices.add(new QuiltedIndex("Malfors 90", ma902, ma90o2, pickerQ2, quiltingData, 2));
        }
        if (ma1402 != null) {
            if (ma140o2 == null)
                ma140o2 = 0;
            quiltedIndices.add(new QuiltedIndex("Malfors 140", ma1402, ma140o2, pickerQ2, quiltingData, 2));
        }
        if (ma1602 != null) {
            if (ma160o2 == null)
                ma160o2 = 0;
            quiltedIndices.add(new QuiltedIndex("Malfors 160", ma1602, ma160o2, pickerQ2, quiltingData, 2));
        }
        if (mo752 != null) {
            if (mo75o2 == null)
                mo75o2 = 0;
            quiltedIndices.add(new QuiltedIndex("Moshult 75", mo752, mo75o2, pickerQ2, quiltingData, 2));
        }
        if (mo802 != null) {
            if (mo80o2 == null)
                mo80o2 = 0;
            quiltedIndices.add(new QuiltedIndex("Moshult 80", mo802, mo80o2, pickerQ2, quiltingData, 2));
        }
        if (mo902 != null) {
            if (mo90o2 == null)
                mo90o2 = 0;
            quiltedIndices.add(new QuiltedIndex("Moshult 90", mo902, mo90o2, pickerQ2, quiltingData,2));
        }
        if (mo1402 != null) {
            if (mo140o2 == null)
                mo140o2 = 0;
            quiltedIndices.add(new QuiltedIndex("Moshult 140", mo1402, mo140o2, pickerQ2, quiltingData,2));
        }
        if (mo1602 != null) {
            if (mo160o2 == null)
                mo160o2 = 0;
            quiltedIndices.add(new QuiltedIndex("Moshult 160", mo1602, mo160o2, pickerQ2, quiltingData,2));
        }
        //third quilter
        if (ma753 != null) {
            if (ma75o3 == null)
                ma75o3 = 0;
            quiltedIndices.add(new QuiltedIndex("Malfors 75", ma753, ma75o3, pickerQ3, quiltingData, 3));
        }

        if (ma803 != null) {
            if (ma80o3 == null)
                ma80o3 = 0;
            quiltedIndices.add(new QuiltedIndex("Malfors 80", ma803, ma80o3, pickerQ3, quiltingData, 3));
        }
        if (ma903 != null) {
            if (ma90o3 == null)
                ma90o3 = 0;
            quiltedIndices.add(new QuiltedIndex("Malfors 90", ma903, ma90o3, pickerQ3, quiltingData, 3));
        }
        if (ma1403 != null) {
            if (ma140o3 == null)
                ma140o3 = 0;
            quiltedIndices.add(new QuiltedIndex("Malfors 140", ma1403, ma140o3, pickerQ3, quiltingData, 3));
        }
        if (ma1603 != null) {
            if (ma160o3 == null)
                ma160o3 = 0;
            quiltedIndices.add(new QuiltedIndex("Malfors 160", ma1603, ma160o3, pickerQ3, quiltingData, 3));
        }
        if (mo753 != null) {
            if (mo75o3 == null)
                mo75o3 = 0;
            quiltedIndices.add(new QuiltedIndex("Moshult 75", mo753, mo75o3, pickerQ3, quiltingData, 3));
        }
        if (mo803 != null) {
            if (mo80o3 == null)
                mo80o3 = 0;
            quiltedIndices.add(new QuiltedIndex("Moshult 80", mo803, mo80o3, pickerQ3, quiltingData, 3));
        }
        if (mo903 != null) {
            if (mo90o3 == null)
                mo90o3 = 0;
            quiltedIndices.add(new QuiltedIndex("Moshult 90", mo903, mo90o3, pickerQ3, quiltingData,3));
        }
        if (mo1403 != null) {
            if (mo140o3 == null)
                mo140o3 = 0;
            quiltedIndices.add(new QuiltedIndex("Moshult 140", mo1403, mo140o3, pickerQ3, quiltingData,3));
        }
        if (mo1603 != null) {
            if (mo160o3 == null)
                mo160o3 = 0;
            quiltedIndices.add(new QuiltedIndex("Moshult 160", mo1603, mo160o3, pickerQ3, quiltingData,3));
        }

        quiltingData.setQuiltedIndices(quiltedIndices);
        //save to db
        quiltingDataService.addQuiltingData(quiltingData);

        return "home";
    }
}
