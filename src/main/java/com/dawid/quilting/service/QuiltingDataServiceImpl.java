package com.dawid.quilting.service;

import com.dawid.quilting.entity.ProductionWorker;
import com.dawid.quilting.entity.QuiltingData;
import com.dawid.quilting.repository.ProductionWorkerRepository;
import com.dawid.quilting.repository.QuiltingDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class QuiltingDataServiceImpl implements QuiltingDataService {

    private final QuiltingDataRepository quiltingDataRepository;
    private final ProductionWorkerRepository productionWorkerRepository;

    @Autowired
    public QuiltingDataServiceImpl(QuiltingDataRepository quiltingDataRepository, ProductionWorkerRepository productionWorkerRepository) {
        this.quiltingDataRepository = quiltingDataRepository;
        this.productionWorkerRepository = productionWorkerRepository;
    }

    @Override
    @Transactional
    public void addQuiltingData(QuiltingData quiltingData) {
        quiltingDataRepository.save(quiltingData);
    }

    @Override
    @Transactional
    public Optional<QuiltingData> getQuiltingDataByDateAndOperator(LocalDate date, ProductionWorker operator) {
        return Optional.ofNullable(quiltingDataRepository.getByDateAndOperator(date, operator));
    }

    @Override
    @Transactional
    public List<ProductionWorker> getAllProductionWorkers() {
        return productionWorkerRepository.findAll();
    }

    @Override
    @Transactional
    public ProductionWorker getProductionWorker(int id) {
        return productionWorkerRepository.getOne(id);
    }

    @Override
    @Transactional
    public void removeQuiltedData(QuiltingData quiltingData) {
        quiltingDataRepository.delete(quiltingData);
    }


}
