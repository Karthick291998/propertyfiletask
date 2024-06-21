package stepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;

import basement.base;
import basement.browser;
import fb.ObjectRespository.fbAccountCreation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class fbcucm extends fbAccountCreation {
	String propertypath="C:\\Users\\karth\\eclipse-workspace\\cuccumber\\src\\test\\resources\\utility.property";
	
	public static base b=new base();
	public static fbAccountCreation fb=new fbAccountCreation();
	@Given("Launch the browserr")
	public void launch_the_browserr()
	{
		b.setup(browser.CHROME,"https://www.facebook.com/r.php?next=https%3A%2F%2Fwww.facebook.com%2F&locale=en_GB&display=page" );
	}
	
	@When("Enter the firstname {string}")
	public void enter_the_firstname(String string) throws Exception {
		//firstname
		String name=b.readproperty(propertypath, "firstname");
		WebElement firstname=b.element("xpath", name);
		b.type(firstname, string);
		//b.type(fb.getFirstname(), string);
	}

	@When("Enter the lastname {string}")
	public void enter_the_lastname(String string) {
		  //last name
		//WebElement lastname=b.element("xpath", "//input[@name='lastname']");
	//	b.type(lastname, string);
		b.type(fb.getLastname(), string);
	}

	@When("Enter the email {string}")
	public void enter_the_email(String string) {
		 //email or num
		WebElement email=b.element("xpath", "//input[@name='reg_email__']");
		b.type(email, string);
		//b.type(fb.getEmail(), string);
	}

	@When("Enter the new password {string}")
	public void enter_the_new_password(String string) {
		 //password
		WebElement pass=b.element("xpath", "//input[@name='reg_passwd__']");
		b.type(pass, string);
		//b.type(fb.getPassword(), string);
	}

	@When("Enter the dateOfBirth {string}")
	public void enter_the_dateOfBirth(String string) {
		  String date=string;
		  String[] str=date.split(" ");
		  WebElement day=b.element("xpath","//select[@id='day']");
		  b.type(day, str[0]);
		 // b.dropdown(fb.getDay(),str[0]);
		  WebElement month=b.element("xpath","//select[@id='month']");
		  b.type(month, str[1]);
		//  b.dropdown(fb.getMonth(),str[1]);
		  WebElement year=b.element("xpath","//select[@id='year']");
		  b.type(year, str[2]);
		//  b.dropdown(fb.getYear(),str[2]);
	}

	@When("Enter the gender {string}")
	public void enter_the_gender(String string) {
		String gender=string;
		  if(gender.equals("male"))
		  {
			b.click(b.element("xpath","//label[text()='Male']"));
			 // b.click(fb.getMale());
				  }
		  else if(gender.equals("female"))
		  {
			  b.click(b.element("xpath","//label[text()='Female']"));
			 // b.click(fb.getFemale());
		  }
		  else
		  {
			  b.click(b.element("xpath","//label[text()='Custom']"));
			 // b.click(fb.getCustom());
		  }
	}
	@Then("click the signup {string}")
	public void click_the_signup(String string) throws InterruptedException, IOException {
		b.click(b.element("xpath","//button[@name='websubmit']"));
		//b.click(fb.getsignup());
		Thread.sleep(2000);
		b.screenshot(string);
	}
	   	


}
