package com.digitalnewagency.task.api;

import com.digitalnewagency.task.service.CovidCaseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/cases")
public class CovidCasesController {

    private final CovidCaseService caseService;

    public CovidCasesController(CovidCaseService caseService) {
        this.caseService = caseService;
    }

    @ResponseStatus(NO_CONTENT)
    @PostMapping
    void addCase(@RequestBody CovidCaseDto caseDto) {
        caseService.addCase(caseDto);
    }

}
