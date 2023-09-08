package com.NTeq.AssessmentPortal.Services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NTeq.AssessmentPortal.Dto.QuizDto;
import com.NTeq.AssessmentPortal.Entity.Quiz;
import com.NTeq.AssessmentPortal.Exceptions.AlreadyExistException;
import com.NTeq.AssessmentPortal.Exceptions.ResourceNotFound;
import com.NTeq.AssessmentPortal.Repositories.QuizRepository;
import com.NTeq.AssessmentPortal.Services.QuizService;
/**
 * Service implementation for managing Quiz-related operations.
 */
@Service
public class QuizServiceImpl implements QuizService {
    /**
     * Repository for Quiz data. Injected by Spring using @Autowired.
     */
    @Autowired
    private QuizRepository quizRepository;
    /**
     * Object Mapper for DTO-entity mapping.Injected by Spring using @Autowired.
     */
    @Autowired
    private ModelMapper modelMapper;
    /**
     * Adds a new quiz using the provided QuizDto.
     * @param quizDto The QuizDto containing quiz information.
     * @return A message indicating the success of the operation.
     */
    @Override
    public final String addQuiz(final QuizDto quizDto) {
        Optional<Quiz> existingQuiz = quizRepository.findByQuizName(
                quizDto.getQuizName());
        if (existingQuiz.isPresent()) {
            throw new AlreadyExistException("Quiz already exists");
        }
        Quiz quiz = this.dtoToQuiz(quizDto);
        quizRepository.save(quiz);
        return "Quiz added successfully";
    }
    /**
     * Retrieves a list of all quizzes as QuizDto objects.
     * @return A List of QuizDto objects representing all quizzes.
     */
    @Override
    public final List<QuizDto> getAllQuiz() {
        List<Quiz> qz = quizRepository.findAll();
        return qz.stream()
                .map(this::quizToDto)
                .collect(Collectors.toList());
    }
    /**
     * Retrieves a quiz by its unique identifier.
     * @param quizId The ID of the quiz to retrieve.
     * @return The QuizDto representing the requested quiz.
     * @throws RuntimeException if the quiz with the specified ID is not found.
     */
    @Override
    public final QuizDto getQuizById(final long quizId) {
        Optional<Quiz> quizfound = quizRepository
                .findById(quizId);
        if (quizfound.isPresent()) {
            Quiz qz = quizfound.get();
            QuizDto quizDto = this.quizToDto(qz);
            return quizDto;
        } else {
            throw new ResourceNotFound(
                    "Quiz not found for id" + quizId);
        }
    }
    /**
     * Updates an existing quiz using the provided QuizDto and quiz ID.
     * @param quizId  The ID of the quiz to update.
     * @param quizDto The QuizDto containing updated quiz information.
     * @return A message indicating the success of the update operation.
     */
    @Override
    public final String updateQuiz(final long quizId, final QuizDto quizDto) {
        Quiz qz = this.dtoToQuiz(quizDto);
        qz.setQuizId(quizId);
        quizRepository.save(qz);
        return "Updated successfully..";
    }
    /**
     * Deletes a quiz by its unique identifier.
     * @param quizId The ID of the quiz to delete.
     */
    @Override
    public final void deleteQuiz(final long quizId) {
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
