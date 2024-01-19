package TestCase;

import Endpoints.UserEndpoints;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import payloads.CreateUserPOJO;

import java.io.IOException;

public class UserTesCase {
    public static Faker fr=null;
    public static   CreateUserPOJO   createPOJO=null;

    @BeforeGroups("user")
    public void userData()
    {
       fr= new Faker();
       createPOJO=new CreateUserPOJO();
    }

    @Test(groups ={"user"})
    public void userCreationWithValidData() throws IOException, ParseException {
       createPOJO.setId(fr.idNumber().hashCode());
       createPOJO.setUsername(fr.name().username());
       createPOJO.setFirstName(fr.name().firstName());
       createPOJO.setLastName(fr.name().lastName());
       createPOJO.setEmail(fr.internet().emailAddress());
       createPOJO.setPassword(fr.internet().password());
       createPOJO.setPhone(fr.phoneNumber().cellPhone());
       createPOJO.setUserStatus(0);
       UserEndpoints cr=new UserEndpoints();
      Response response= cr.createUserMethod(createPOJO);
      response.then().statusCode(200);
      System.out.println(response.getBody().asString());
    }

}
