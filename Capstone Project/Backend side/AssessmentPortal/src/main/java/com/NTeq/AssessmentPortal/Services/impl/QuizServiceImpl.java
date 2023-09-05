package com.NTeq.AssessmentPortal.Services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NTeq.AssessmentPortal.Dto.QuizDto;
import com.NTeq.AssessmentPortal.Entity.Quiz;
import com.NTeq.AssessmentPortal.Repositories.QuizRepository;
import com.NTeq.AssessmentPortal.Services.QuizService;

@Service
public class QuizServiceImpl implements QuizService{
    @Autowired
    QuizRepository quizRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String addQuiz(QuizDto quizDto) {
        Quiz quiz = this.dtoToQuiz(quizDto);
        quizRepository.save(quiz);
        return "Quiz added successfully";
    }

    @Override
    public List<QuizDto> getAllQuiz() {
        List<Quiz> qz = quizRepository.findAll();
        return qz.stream()
                .map(this::quizToDto)
                .collect(Collectors.toList());
       
    }

    @Override
    public QuizDto getQuizById(long QuizId) {
        Optional<Quiz> quizfound = quizRepository
                .findById(QuizId);
        if (quizfound.isPresent()) {
            Quiz qz = quizfound.get();
            QuizDto quizDto = this.quizToDto(qz);
            return quizDto;
        } else {
            throw new RuntimeException(
                    "Quiz not found for id" + QuizId);
        }
    }

    @Override
    public String updateQuiz(long quizId, QuizDto quizDto) {
        Quiz qz = this.dtoToQuiz(quizDto);
        qz.setQuizId(quizId);
        quizRepository.save(qz);
        return "Updated successfully..";
    }

    @Override
    public void deleteQuiz(long quizId) {
        quizRepository.deleteById(quizId);
        
    }
    
    /**
     * Converts a quiz entity to its corresponding DTO.
     * @param quiz The Quiz entity.
     * @return The corresponding QuizDto.
     */
    public final QuizDto quizToDto(final Quiz quiz) {
        QuizDto quizDto = modelMapper.map(quiz, QuizDto.class);
        return quizDto;
    }

    /**
     * Converts a QuizDto to its corresponding entity.
     * @param quizDto The QuizDto.
     * @return The corresponding Quiz entity.
     */
    public final Quiz dtoToQuiz(final QuizDto quizDto) {
        Quiz quiz = this.modelMapper.map(quizDto, Quiz.class);
        return quiz;
    }
    

}
