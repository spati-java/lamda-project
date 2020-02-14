package objectstream;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;

public class App implements RequestHandler<PersonRequest, PersonResponse> {

    private static final String key_name = "futureofthenas.pdf";
    private static final String bucket_name = "pdm-ml-sourav";

    public PersonResponse handleRequest(PersonRequest req, Context context) {
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion("us-east-1").build();
        S3Object object = s3.getObject(bucket_name, key_name);
        System.out.println(object.getBucketName());
        return new PersonResponse(req.firstName);
    }
}
