package com.dawid.quilting.service;


import com.dawid.quilting.entity.ProductionWorker;
import com.dawid.quilting.entity.QuiltingData;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface QuiltingDataService {

    void addQuiltingData(QuiltingData quiltingData);

    Optional<QuiltingData> getQuiltingDataByDateAndOperator(LocalDate date, ProductionWorker operator);

    List<ProductionWorker> getAllProductionWorkers();

    ProductionWorker getProductionWorker(int id);

    void removeQuiltedData(QuiltingData quiltingData);


}
