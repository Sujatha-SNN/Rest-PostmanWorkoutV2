package paystack;

import static org.hamcrest.Matchers.containsString;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllPaymentPages extends BaseClass {
	@Test(dependsOnMethods = "paymentstack.PaymentStackPayments.createPaymentsPage")
	public void getAllPages() {
		System.out.println("ID" + id);
		loadURL();
		Response response = RestAssured
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.queryParams("perPage", "50")
				.queryParams("page", "1")
				.get("page")
				.then()
				.assertThat()
				.body(containsString(id))
				.extract().response();
		System.out.println(response.getStatusCode());
		response.prettyPrint();
	}
}
