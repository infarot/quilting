package com.dawid.quilting.service;


import com.dawid.quilting.entity.ProductionWorker;
import com.dawid.quilting.entity.QuiltingData;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface QuiltingDataService {

    void addQuiltingData(QuiltingData quiltingData);

    Optional<QuiltingData> getQuiltingDataByDate(LocalDate date);

    List<ProductionWorker> getAllProductionWorkers();

    Optional<ProductionWorker> getProductionWorker(int id);

    void removeQuiltedData(QuiltingData quiltingData);


}
