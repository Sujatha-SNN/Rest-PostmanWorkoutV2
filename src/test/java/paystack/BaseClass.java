package paystack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;

public class BaseClass {
	public static String id;
	public void loadURL() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));
			RestAssured.baseURI = "https://"+prop.getProperty("paystack")+"/";
			RestAssured.authentication = RestAssured.oauth2(prop.getProperty("oauthkey_paystack"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
}
