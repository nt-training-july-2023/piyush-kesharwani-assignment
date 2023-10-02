package com.NTeq.AssessmentPortal.Response;

public class Message {
    public static final String METHOD_ARGUMENT_NOT_VALID = "Validation failed for method arguments.";
    public static final String ALREADY_EXISTS = "Resource already exists.";
    public static final String DUPLICATE_EMAIL = "Email address is already exists.";
    public static final String LOGIN_FAILED = "Login failed. Invalid credentials.";
    public static final String RESOURCE_NOT_FOUND = "Resource not found.";
    public static final String USER_EMAIL_DOMAIN = "Invalid email domain.";
    public static final String USER_NOT_FOUND = "User does not exist.";
    public static final String USER_METHOD_INVOKE = "Candidate Method invoke";
    public static final String LOGIN_METHOD_INVOKE = "Login method invoke";
    public static final String LOGIN_SUCCESSFULLY = "Login successfully";
    public static final String GET_USERS = "Retrieving list of Candidates";
    public static final String RETRIVED_USERS = "Retrieved list of candidates";

    public static final String REGISTERED_SUCCESSFULLY = "Candidate Register successfully.";

    public static final String CATEGORY_CREATED_SUCCESSFULLY = "Category created successfully.";
    public static final String CATEGORY_UPDATED_SUCCESSFULLY = "Category updated successfully.";
    public static final String CATEGORY_DELETED_SUCCESSFULLY = "Category deleted successfully.";
    public static final String CATEGORY_ALREADY_EXISTS = "Category already exists.";
    public static final String CATEGORY_NOT_FOUND = "Category does not exist.";
    public static final String ADD_CATEGORY = "Add category method invoke";
    public static final String GET_CATEGORY_BY_ID = "Received a request to get category with ID :{}";
    public static final String GET_CATEGORY_SUCESSFULLY = "successfully fetched category with ID {}";
    public static final String GET_CATEGORIES = "Get Categories method invoke";
    public static final String RETRIVED_CATEGORIES = "Retrieved Categories";
    public static final String UPDATE_CATEGORY = "Received a request to update category with ID :{}";
    public static final String DELETE_CATEGORY = "Received a request to delete category with ID :{}";
    public static final String GET_QUIZZES_BY_CATEGORY = "Getting quizzes for category with ID: {}";
    public static final String RETRIVED_QUIZZES_SUCCESFULLY = "Quizzes retrieved successfully for category with ID: {}";

    public static final String QUIZ_CREATED_SUCCESSFULLY = "Quiz created successfully.";
    public static final String QUIZ_UPDATED_SUCCESSFULLY = "Quiz updated successfully.";
    public static final String QUIZ_DELETED_SUCCESSFULLY = "Quiz deleted successfully.";
    public static final String QUIZ__ALREADY_EXISTS = "Quiz already exists.";
    public static final String QUIZ_NOT_FOUND = "Quiz does not exist.";
    public static final String ADD_QUIZ = "Add quiz method invoke";
    public static final String GET_QUIZ_BY_ID = "Received a request to get quiz with ID :{}";
    public static final String GET_QUIZ_SUCESSFULLY = "successfully fetched quiz with ID {}";
    public static final String GET_QUIZZES = "Get quizzes method invoke";
    public static final String RETRIVED_QUIZZES = "Retrived quizzes";
    public static final String UPDATE_QUIZ = "Received a request to update quiz with ID :{}";
    public static final String DELETE_QUIZ = "Received a request to delete quiz with ID :{}";
    public static final String GET_QUESTION_BY_QUIZ = "Getting questions for quiz with ID: {}";
    public static final String RETRIVED_QUESTION_BY_QUIZ = "Retrieved all questions for quiz with ID :{}";

    public static final String QUESTION_CREATED_SUCCESSFULLY = "Question created successfully.";
    public static final String QUESTION_UPDATED_SUCCESSFULLY = "Question updated successfully.";
    public static final String QUESTION_DELETED_SUCCESSFULLY = "Question deleted successfully.";
    public static final String CORRECT_OPTION_ERROR = "Correct Answer Not Match with any options.";
    public static final String QUESTION_NOT_FOUND = "Question does not exist.";
    public static final String ADD_QUESTION = "Add question method invoke";
    public static final String GET_QUESTION_BY_ID = "Received a request to get question with ID :{}";
    public static final String GET_QUESTION_SUCESSFULLY = "successfully fetched question with ID {}";
    public static final String GET_QUESTIONS = "Get questions method invoke";
    public static final String RETRIVED_QUESTIONS = "Retrived questions";
    public static final String UPDATE_QUESTION = "Received a request to update question with ID :{}";
    public static final String DELETE_QUESTION = "Received a request to delete question with ID :{}";

    public static final String RESULT_CREATED_SUCCESSFULLY = "Result created successfully.";
    public static final String RESULT_UPDATED_SUCCESSFULLY = "Result updated successfully.";
    public static final String RESULT_DELETED_SUCCESSFULLY = "Result deleted successfully.";
    public static final String RESULT_NOT_FOUND = "Result does not exist.";
    public static final String ADD_RESULT = "Add Result method invoked";
    public static final String GET_RESULTS = "Get results method invoked";
    public static final String RETRIVED_RESULT = "Retrieved Results Successfully";
    public static final String GET_RESULT_BY_EMAIL = "Getting result by email: {}";
    public static final String RETRIVED_RESULT_BY_EMAIL = "Successfully fetched result with email {}";
    

    private Message() {
    }
}
