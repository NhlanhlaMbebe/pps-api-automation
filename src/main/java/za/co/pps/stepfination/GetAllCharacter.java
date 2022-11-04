package za.co.pps.stepfination;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import za.co.pps.model.MovieCharacter;

import java.io.IOException;
import java.util.Arrays;

public class GetAllCharacter {

    private String url;
    private Response response;
    private ObjectMapper om = new ObjectMapper();

    @Given("^I have an endpoint \"([^\"]*)\"$")
    public void i_have_an_endpoint(String arg1) throws Throwable {
        url = arg1;
    }

    @When("^I get characters$")
    public void iGetCharacters() throws Throwable {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .get(url);
    }

    @Then("^I display them$")
    public void i_display_them() throws Throwable {
        String jsonPath = response.getBody().asString();
        MovieCharacter[] character = om.readValue(jsonPath,  MovieCharacter[].class);

        Arrays.stream(character)
                .forEach(s -> System.out.println("Character name: " + s.getName()
                        + "\nProtrayed: " + s.getPortrayed() +
                        "\n_____________________________________________________\n"));
    }

    @Then("^I display birthday$")
    public void iDisplayBirthday() throws IOException {
        String jsonPath = response.getBody().asString();
        MovieCharacter[] character = om.readValue(jsonPath,  MovieCharacter[].class);
        Arrays.stream(character)
                .forEach(s -> System.out.println( s.getName() + "'s birthday is on " + s.getBirthday()));
    }
}
