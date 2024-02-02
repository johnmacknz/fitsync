package fitnesstracker.exceptions;

public class ExerciseServiceException extends RuntimeException {
    public ExerciseServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
