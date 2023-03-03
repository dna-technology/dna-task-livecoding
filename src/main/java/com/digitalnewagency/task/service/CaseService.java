package com.digitalnewagency.task.service;

import com.digitalnewagency.task.api.CaseDto;
import com.digitalnewagency.task.persistence.Case;
import com.digitalnewagency.task.persistence.CaseRepository;
import org.springframework.stereotype.Component;

@Component
public class CaseService {

    CaseRepository caseRepository;

    public CaseService(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    public void addCase(CaseDto caseDto) {
        Case caseModel = new Case();
        caseModel.setUserId(caseDto.getUserId());
        caseModel.setLatitude(Double.valueOf(caseDto.getLatitude()));
        caseModel.setLongitude(Double.valueOf(caseDto.getLongitude()));
        caseRepository.save(caseModel);
    }

}
