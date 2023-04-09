package deronzier.remi.notesmicroservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class is the exception thrown when a note is not found
 * 
 * @author Rémi Deronzier
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoteNotFoundException extends Exception {
    public NoteNotFoundException(String message) {
        super(message);
    }
}
