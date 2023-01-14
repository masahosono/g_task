package presentation.user.shared;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class HttpStatusCodeConverter {

    public HttpStatus from(RuntimeException exception) {

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
