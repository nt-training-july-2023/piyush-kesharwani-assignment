package com.NTeq.AssessmentPortal.Services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.NTeq.AssessmentPortal.Entity.Candidate;
import com.NTeq.AssessmentPortal.Exceptions.DuplicateEmail;
import com.NTeq.AssessmentPortal.Repositories.CandidateRepository;
import com.NTeq.AssessmentPortal.Services.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService{
    
	@Autowired
	CandidateRepository candidateRepository;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public String addCandidate(Candidate cd) {
		if(cd !=null && cd.getEmail()!=null && cd.getPassword()!=null) {
			
			Optional<Candidate> existingCdByEmail = candidateRepository.findByEmail(cd.getEmail());
			if(existingCdByEmail.isPresent()) {
				throw new DuplicateEmail("Email already exits");
			}
			Candidate newCd = new Candidate(
				0, cd.getFirstName(),
				cd.getLastName(),
				cd.getEmail(),
				this.passwordEncoder.encode(cd.getPassword()),
				"user",
				cd.getPhoneNumber()
				);
			try {
				candidateRepository.save(newCd);
			}catch(Exception e) {
				throw e;
			}
			return newCd.getEmail() + " registered successfully";
			
		}else {
			return ("registration object cannot be null");
		 }
	}
	
	@Override
	public List<Candidate> getAllCandidate(){
		return candidateRepository.findAll();
	}
	
	@Override
	public Map<String,String> loginCandidate(Candidate inCandidate){
		Map<String,String> response = new HashMap<>();
		
		Candidate foundCandidate = candidateRepository.getByEmail(inCandidate.getEmail());
		
		if(foundCandidate!=null){
			String password = inCandidate.getPassword();
			String encodedPassword = foundCandidate.getPassword();
			
			Boolean isCorrect = passwordEncoder.matches(password, encodedPassword);
			
			if(isCorrect){
				Optional<Candidate> candidateRegistration = candidateRepository
						.findByEmailAndPassword(inCandidate.getEmail(), encodedPassword);

				if(candidateRegistration.isPresent()) {
					response.put("message", "Login Successfully");
					response.put("status", "true");
					response.put("role", foundCandidate.getUserRole());
				}else{
					response.put("status", "false");
					response.put("message", "Login Failed");
				}
			} else{
				response.put("status", "false");
				response.put("message", "Password Not Match");
			}
		}else{
			response.put("status", "false");
			response.put("message", "User does not Exists");
		}
		return response;
	}
	   
}
