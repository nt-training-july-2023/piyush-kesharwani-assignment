package com.NTeq.AssessmentPortal.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NTeq.AssessmentPortal.Dto.CandidateDto;
import com.NTeq.AssessmentPortal.Services.impl.CandidateServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    CandidateServiceImpl candidateService;

    @PostMapping(path = "/register")
    public String saveUser(@RequestBody CandidateDto cdDto) {

        return candidateService.addCandidate(cdDto);
    }

    @PostMapping(path = "/login")
    public Map<String, String> loginCandidate(@RequestBody CandidateDto cdDto) {
        Map<String, String> response = candidateService.loginCandidate(cdDto);
        return response;
    }

    @GetMapping(path = "/all")
    public List<CandidateDto> allCandidate() {
        return candidateService.getAllCandidate();
    }

}
