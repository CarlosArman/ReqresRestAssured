package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

public class testStepDef {

    private String baseURI;
    private String pathURI;
    private HashMap<String, String> header = new HashMap<>();
    private Response response;
    private Scenario scenario;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("consulto el endpoint {string} con path {string}")
    public void consultoElEndpointConPath(String baseURI, String path) {
        this.baseURI = baseURI;
        RestAssured.baseURI = baseURI;
        this.pathURI = path;
    }

    @And("con header {string}:{string}")
    public void conHeader(String key, String value) {
        header.put(key, value);
    }

    @When("obtengo el response")
    public void obtengoElResponse() {
        response = RestAssured.given().headers(header).get(pathURI);
        System.out.println("Response" + response.getBody().asString());
        scenario.log(response.getBody().asString());
    }

    @Then("valido que el status sea {int}")
    public void validoQueElStatusSea(int status) {
        Assertions.assertEquals(response.getStatusCode(), status);
        scenario.log("Status " + response.getStatusCode());
    }
}
