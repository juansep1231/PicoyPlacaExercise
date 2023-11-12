/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steps;

import static org.junit.Assert.assertEquals;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Car;
import model.DateTime;
import model.PicoYPlaca;

/**
 *
 * @author Juan Posso
 */
public class PicoYPlacaTestSteps {
    
private Car car;
private DateTime dateAndTime;
private PicoYPlaca picoYplaca;
private boolean restriction;

@Given("a car with plate {string}")
public void a_car_with_plate(String carPlate) {
    car = new Car(carPlate);
}
@Given("a valid date {string} and time {string}")
public void a_valid_date_and_time(String date, String time) {
    dateAndTime = new DateTime(date, time);
}
@When("the program check the restriction")
public void the_program_check_the_restriction() {
    picoYplaca = new PicoYPlaca(this.car, this.dateAndTime);
    this.restriction = picoYplaca.checkPlateRestriction();
}
@Then("the restriction is {string}")
public void the_restriction_is(String restriction) {
   String strRestriction = String.valueOf(this.restriction);
   assertEquals(restriction,strRestriction);
}
}
