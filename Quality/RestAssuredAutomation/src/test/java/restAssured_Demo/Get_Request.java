package restAssured_Demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Get_Request {
  @Test
  public void getweatherdetails() {
	  
	  //Specify base uri
	  RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	  
	  //Request opbject
	  RequestSpecification httpRequest = RestAssured.given();
	  
	  //Response object 
	  Response response = httpRequest.request(Method.GET,"/Hyderabad");
	  
	  //Print response in the console window
	  String responseBody = response.getBody().asString();
	  System.out.println("Response Body is :" +responseBody);
	  
	  //Status code validation
	  int StatusCode = response.getStatusCode();
	  System.out.println("status code is:" +StatusCode);
	  Assert.assertEquals(StatusCode, 200);
	  
	  //Status line validation
	  String Statusline = response.getStatusLine();
	  System.out.println("status line is:" +Statusline);
	  Assert.assertEquals(Statusline,"HTTP/1.1 200 OK");
	  
  }
}
