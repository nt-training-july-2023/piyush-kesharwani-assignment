package com.NTeq.AssessmentPortal.Services;

import java.util.List;
import java.util.Map;

import com.NTeq.AssessmentPortal.Dto.CandidateDto;

public interface CandidateService {
    public String addCandidate(CandidateDto cdDto);

    public Map<String, String> loginCandidate(CandidateDto inCandidateDto);

    public List<CandidateDto> getAllCandidate();
}
