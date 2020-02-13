package objectstream;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;

public class App implements RequestHandler<PersonRequest, PersonResponse> {
    public PersonResponse handleRequest(PersonRequest req, Context context) {
        return new PersonResponse(req.firstName);
    }
}