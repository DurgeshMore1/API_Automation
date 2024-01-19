package Endpoints;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.CreateUserPOJO;

import java.util.ArrayList;
import java.util.List;



import static Endpoints.Routes.createUserUrl;
import static io.restassured.RestAssured.*;


public class UserEndpoints {
    public static Response createUserMethod(CreateUserPOJO user) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List list=new ArrayList<CreateUserPOJO>();
        list.add(user);
        mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        Response response= given().contentType(ContentType.JSON).accept(ContentType.JSON).
        body(list).
        when().post(createUserUrl);
        return response;
    }
    public static getuser()
    {

    }
}
