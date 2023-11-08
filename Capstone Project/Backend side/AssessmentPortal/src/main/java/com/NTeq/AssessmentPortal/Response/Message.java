package com.NTeq.AssessmentPortal.Response;
/**
 * A utility class containing constant messages used for response.
 * This class provides standardized messages to ensure consistency across the
 * application's responses and logs.
 */
public final class Message {
    /**
     * Constant message: Validation failed for method arguments.
     */
    public static final String METHOD_ARGUMENT_NOT_VALID =
            "Validation failed for method arguments.";
    /**
     * Constant message: Resource already exists.
     */
    public static final String ALREADY_EXISTS =
            "Resource already exists.";
    /**
     * Constant message: Email address is already exists.
     * Indicates that the provided email address already exists in the system.
     */
    public static final String DUPLICATE_EMAIL =
            "Email address is already exists.";

    /**
     * Constant message: Login failed. Invalid credentials.
     * Indicates that the login attempt failed due to invalid credentials.
     */
    public static final String LOGIN_FAILED = "Login failed."
            + " Invalid credentials.";

    /**
     * Constant message: Resource not found.
     * Indicates that the requested resource could not be found.
     */
    public static final String RESOURCE_NOT_FOUND = "Resource not found.";

    /**
     * Constant message: Invalid email domain.
     * Indicates that the provided email domain is invalid.
     */
    public static final String USER_EMAIL_DOMAIN = "Invalid email domain.";

    /**
     * Constant message: User does not exist.
     * Indicates that the specified user does not exist in the system.
     */
    public static final String USER_NOT_FOUND = "User does not exist.";

    /**
     * Constant message: Candidate Method invoke.
     * Indicates that a method related to candidate operations has invoked.
     */
    public static final String USER_METHOD_INVOKE = "Candidate Method invoke.";

    /**
     * Constant message: Login method invoke.
     * Indicates that the login method has been invoked.
     */
    public static final String LOGIN_METHOD_INVOKE = "Login method invoke.";

    /**
     * Constant message: Login successfully.
     * Indicates a successful login attempt.
     */
    public static final String LOGIN_SUCCESSFULLY = "Login successfully.";

    /**
     * Constant message: Retrieving list of Candidates.
     * Indicates the process of retrieving a list of candidates.
     */
    public static final String GET_USERS = "Retrieving list of Candidates.";

    /**
     * Constant message: Retrieved list of candidates.
     * Indicates the successful retrieval of a list of candidates.
     */
   public static final String RETRIVED_USERS =
           "Retrieved list of candidates.";


    /**
     * Constant message: Candidate Register successfully.
     * Indicates that a candidate has been registered successfully.
     */
    public static final String REGISTERED_SUCCESSFULLY = "Candidate"
            + " Register successfully.";

    /**
     * Constant message: Category created successfully.
     * Indicates that a new category has been created successfully.
     */
    public static final String CATEGORY_CREATED_SUCCESSFULLY = "Category"
            + " created successfully.";

    /**
     * Constant message: Category updated successfully.
     * Indicates that an existing category has been updated successfully.
     */
    public static final String CATEGORY_UPDATED_SUCCESSFULLY = "Category "
            + "updated successfully.";

    /**
     * Constant message: Category deleted successfully.
     * Indicates that a category has been deleted successfully.
     */
    public static final String CATEGORY_DELETED_SUCCESSFULLY = "Category "
            + "deleted successfully.";

    /**
     * Constant message: Category already exists.
     * Indicates that the specified category already exists in the system.
     */
    public static final String CATEGORY_ALREADY_EXISTS = "Category already"
            + " exists.";

    /**
     * Constant message: Category does not exist.
     * Indicates that the requested category does not exist in the system.
     */
    public static final String CATEGORY_NOT_FOUND = "Category does not exist.";

    /**
     * Constant message: Add category method invoke.
     * Indicates that the add category method has been invoked.
     */
    public static final String ADD_CATEGORY = "Add category method invoke.";

    /**
     * Constant message: Received a request to get category with ID :{}.
     * Indicates a request to retrieve a category by its ID.
     */
    public static final String GET_CATEGORY_BY_ID = "Received a request"
            + " to get category with ID :{}.";

    /**
     * Constant message: Successfully fetched category with ID {}.
     * Indicates successful retrieval of a category by its ID.
     */
    public static final String GET_CATEGORY_SUCESSFULLY = "Successfully"
            + " fetched category with ID {}.";

    /**
     * Constant message: Get Categories method invoke.
     * Indicates that the get categories method has been invoked.
     */
   public static final String GET_CATEGORIES = "Get Categories method invoke.";

    /**
     * Constant message: Retrieved Categories.
     * Indicates that categories have been successfully retrieved.
     */
    public static final String RETRIVED_CATEGORIES = "Retrieved Categories.";

    /**
     * Constant message: Received a request to update category with ID :{}.
     * Indicates a request to update a category by its ID.
     */
    public static final String UPDATE_CATEGORY = "Received a request to"
            + " update category with ID :{}.";

    /**
     * Constant message: Received a request to delete category with ID :{}.
     * Indicates a request to delete a category by its ID.
     */
    public static final String DELETE_CATEGORY = "Received a request"
            + " to delete category with ID :{}.";

    /**
     * Constant message: Getting quizzes for category with ID: {}.
     * Indicates the process of retrieving quizzes for a specific
     * category by its ID.
     */
    public static final String GET_QUIZZES_BY_CATEGORY = "Getting quizzes"
            + " for category with ID: {}.";

    /**
     * Constant message: Quizzes retrieved successfully for category with ID.
     * Indicates that quizzes have been successfully retrieved for a specific
     *  category by its ID.
     */
    public static final String RETRIVED_QUIZZES_SUCCESFULLY = "Quizzes"
            + " retrieved successfully for category with ID: {}.";


    /**
     * Constant message: Quiz created successfully.
     * Indicates that a new quiz has been created successfully.
     */
    public static final String QUIZ_CREATED_SUCCESSFULLY = "Quiz created"
            + " successfully.";

    /**
     * Constant message: Quiz updated successfully.
     * Indicates that an existing quiz has been updated successfully.
     */
    public static final String QUIZ_UPDATED_SUCCESSFULLY = "Quiz updated"
            + " successfully.";

    /**
     * Constant message: Quiz deleted successfully.
     * Indicates that a quiz has been deleted successfully.
     */
    public static final String QUIZ_DELETED_SUCCESSFULLY = "Quiz deleted"
            + " successfully.";

    /**
     * Constant message: Quiz already exists.
     * Indicates that the specified quiz already exists in the system.
     */
    public static final String QUIZ_ALREADY_EXISTS = "Quiz already exists.";

    /**
     * Constant message: Quiz does not exist.
     * Indicates that the requested quiz does not exist in the system.
     */
    public static final String QUIZ_NOT_FOUND = "Quiz does not exist.";

    /**
     * Constant message: Add quiz method invoke.
     * Indicates that the add quiz method has been invoked.
     */
    public static final String ADD_QUIZ = "Add quiz method invoke.";

    /**
     * Constant message: Received a request to get quiz with ID :{}.
     * Indicates a request to retrieve a quiz by its ID.
     */
    public static final String GET_QUIZ_BY_ID = "Received a request to"
            + " get quiz with ID :{}.";

    /**
     * Constant message: Successfully fetched quiz with ID {}.
     * Indicates successful retrieval of a quiz by its ID.
     */
    public static final String GET_QUIZ_SUCESSFULLY = "Successfully fetched"
            + " quiz with ID {}.";

    /**
     * Constant message: Get quizzes method invoke.
     * Indicates that the get quizzes method has been invoked.
     */
    public static final String GET_QUIZZES = "Get quizzes method invoke.";

    /**
     * Constant message: Retrieved quizzes.
     * Indicates that quizzes have been successfully retrieved.
     */
    public static final String RETRIVED_QUIZZES = "Retrieved quizzes.";

    /**
     * Constant message: Received a request to update quiz with ID :{}.
     * Indicates a request to update a quiz by its ID.
     */
    public static final String UPDATE_QUIZ = "Received a request to"
            + " update quiz with ID :{}.";

    /**
     * Constant message: Received a request to delete quiz with ID :{}.
     * Indicates a request to delete a quiz by its ID.
     */
    public static final String DELETE_QUIZ = "Received a request to"
            + " delete quiz with ID :{}.";

    /**
     * Constant message: Getting questions for quiz with ID: {}.
     * Indicates the process of retrieving questions by its ID.
     */
    public static final String GET_QUESTION_BY_QUIZ = "Getting questions for"
            + " quiz with ID: {}.";

    /**
     * Constant message: Retrieved all questions for quiz with ID :{}.
     * Indicates that all questions have been successfully retrieved by its ID.
     */
    public static final String RETRIVED_QUESTION_BY_QUIZ = "Retrieved all"
            + " questions for quiz with ID :{}.";


    /**
     * Constant message: Question created successfully.
     * Indicates that a new question has been created successfully.
     */
    public static final String QUESTION_CREATED_SUCCESSFULLY = "Question"
            + " created successfully.";

    /**
     * Constant message: Question updated successfully.
     * Indicates that an existing question has been updated successfully.
     */
    public static final String QUESTION_UPDATED_SUCCESSFULLY = "Question"
            + " updated successfully.";

    /**
     * Constant message: Question deleted successfully.
     * Indicates that a question has been deleted successfully.
     */
    public static final String QUESTION_DELETED_SUCCESSFULLY = "Question "
            + "deleted successfully.";

    /**
     * Constant message: Correct Answer Not Match with any options.
     * Indicates that the correct answer does not match any of the options.
     */
    public static final String CORRECT_OPTION_ERROR = "Correct Answer"
            + " Not Match with any options.";

    /**
     * Constant message: Question does not exist.
     * Indicates that the requested question does not exist in the system.
     */
    public static final String QUESTION_NOT_FOUND = "Question does not exist.";

    /**
     * Constant message: Add question method invoke.
     * Indicates that the add question method has been invoked.
     */
    public static final String ADD_QUESTION = "Add question method invoke.";

    /**
     * Constant message: Received a request to get question with ID :{}.
     * Indicates a request to retrieve a question by its ID.
     */
    public static final String GET_QUESTION_BY_ID = "Received a request"
            + " to get question with ID :{}.";

    /**
     * Constant message: Successfully fetched question with ID {}.
     * Indicates successful retrieval of a question by its ID.
     */
    public static final String GET_QUESTION_SUCESSFULLY = "Successfully"
            + " fetched question with ID {}.";

    /**
     * Constant message: Get questions method invoke.
     * Indicates that the get questions method has been invoked.
     */
    public static final String GET_QUESTIONS = "Get questions method invoke.";

    /**
     * Constant message: Retrieved questions.
     * Indicates that questions have been successfully retrieved.
     */
    public static final String RETRIVED_QUESTIONS = "Retrieved questions.";

    /**
     * Constant message: Received a request to update question with ID :{}.
     * Indicates a request to update a question by its ID.
     */
    public static final String UPDATE_QUESTION = "Received a request to"
            + " update question with ID :{}.";

    /**
     * Constant message: Received a request to delete question with ID :{}.
     * Indicates a request to delete a question by its ID.
     */
    public static final String DELETE_QUESTION = "Received a request to"
            + " delete question with ID :{}.";

    /**
     * Constant message: Result created successfully.
     * Indicates that a new result has been created successfully.
     */
    public static final String RESULT_CREATED_SUCCESSFULLY = "Result created"
            + " successfully.";

    /**
     * Constant message: Result updated successfully.
     * Indicates that an existing result has been updated successfully.
     */
    public static final String RESULT_UPDATED_SUCCESSFULLY = "Result updated"
            + " successfully.";

    /**
     * Constant message: Result deleted successfully.
     * Indicates that a result has been deleted successfully.
     */
    public static final String RESULT_DELETED_SUCCESSFULLY = "Result deleted"
            + " successfully.";

    /**
     * Constant message: Result does not exist.
     * Indicates that the requested result does not exist in the system.
     */
    public static final String RESULT_NOT_FOUND = "Result does not exist.";

    /**
     * Constant message: Add Result method invoked.
     * Indicates that the add result method has been invoked.
     */
    public static final String ADD_RESULT = "Add Result method invoked.";

    /**
     * Constant message: Get results method invoked.
     * Indicates that the get results method has been invoked.
     */
    public static final String GET_RESULTS = "Get results method invoked.";

    /**
     * Constant message: Retrieved Results Successfully.
     * Indicates that results have been successfully retrieved.
     */
    public static final String RETRIVED_RESULT = "Retrieved Results"
            + " Successfully.";

    /**
     * Constant message: Getting result by email: {}.
     * Indicates a request to retrieve a result by email.
     */
    public static final String GET_RESULT_BY_EMAIL = "Getting result"
            + " by email: {}.";

    /**
     * Constant message: Successfully fetched result with email {}.
     * Indicates successful retrieval of a result by email.
     */
    public static final String RETRIVED_RESULT_BY_EMAIL = "Successfully"
            + " fetched result with email {}.";
    /**
     * Private constructor to prevent instantiation of the utility class.
     */
    private Message() {
    }
    /**
     * Error message indicating that each option must be unique.
     */
    public static final String DUPLICATE_OPTION_ERROR =
            "Each options must be unique";
 }
