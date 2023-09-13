package com.NTeq.AssessmentPortal.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NTeq.AssessmentPortal.Dto.QuestionDto;
import com.NTeq.AssessmentPortal.Services.impl.QuestionServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/question")
public class QuestionController {


    @Autowired
    private QuestionServiceImpl questionService;

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionDto questionDto) {
        String result = questionService.addQuestion(questionDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<QuestionDto> getQuestionById(@PathVariable long questionId) {
        QuestionDto question = questionService.getQuestionById(questionId);
        if (question != null) {
            return new ResponseEntity<>(question, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{questionId}")
    public ResponseEntity<QuestionDto> updateQuestion(
            @PathVariable long questionId, @RequestBody QuestionDto questionDto) {
        try {
            questionService.updateQuestion(questionId, questionDto);
            return ResponseEntity.ok().body(questionDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status((HttpStatus.INTERNAL_SERVER_ERROR))
                    .build();
        }
    }


    @DeleteMapping("/{questionId}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable long questionId) {
        questionService.deleteQuestion(questionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
