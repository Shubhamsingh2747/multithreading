//
//
//import execption.ErrorResponseDTO;
//import execption.UserNotFoundException;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.time.LocalDateTime;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    // Handle custom exception
//    @ExceptionHandler(UserNotFoundException.class)
//    public ResponseEntity<ErrorResponseDTO> handleUserNotFoundException(
//            UserNotFoundException ex,
//            HttpServletRequest request) {
//
//        ErrorResponseDTO error = new ErrorResponseDTO(
//                LocalDateTime.now(),
//                HttpStatus.NOT_FOUND.value(),
//                "NOT_FOUND",
//                ex.getMessage(),
//                request.getRequestURI()
//        );
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }
//
//    // Handle all other exceptions
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponseDTO> handleGenericException(
//            Exception ex,
//            HttpServletRequest request) {
//
//        ErrorResponseDTO error = new ErrorResponseDTO(
//                LocalDateTime.now(),
//                HttpStatus.INTERNAL_SERVER_ERROR.value(),
//                "INTERNAL_SERVER_ERROR",
//                ex.getMessage(),
//                request.getRequestURI()
//        );
//
//        return new ResponseEntity<>(error,
//                HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}