package com.digitalnewagency.task.api;

import com.digitalnewagency.task.service.CaseService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/cases")
public class CaseController {

    private final CaseService caseService;

    public CaseController(CaseService caseService) {
        this.caseService = caseService;
    }

    @ResponseStatus(NO_CONTENT)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    void addCase(@RequestBody CaseDto caseDto) {
        caseService.addCase(caseDto);
    }

}
