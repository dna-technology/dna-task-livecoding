package com.digitalnewagency.task.service;

import com.digitalnewagency.task.api.CovidCaseDto;
import com.digitalnewagency.task.persistence.CovidCase;
import com.digitalnewagency.task.persistence.CovidCaseRepository;
import org.springframework.stereotype.Component;

@Component
public class CovidCaseService {

    CovidCaseRepository caseRepository;

    public CovidCaseService(CovidCaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    public void addCase(CovidCaseDto caseDto) {
        CovidCase caseModel = new CovidCase();
        caseModel.setUserId(caseDto.getUserId());
        caseRepository.save(caseModel);
    }

}
