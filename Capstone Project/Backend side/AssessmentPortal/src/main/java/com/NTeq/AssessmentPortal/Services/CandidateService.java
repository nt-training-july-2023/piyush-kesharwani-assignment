package com.NTeq.AssessmentPortal.Services;

import java.util.List;
import java.util.Map;

import com.NTeq.AssessmentPortal.Entity.Candidate;

public interface CandidateService {
	public String addCandidate(Candidate cd);
	public Map<String,String> loginCandidate(Candidate inCandidate);
	public List<Candidate> getAllCandidate();
}
