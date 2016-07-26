package com.github.gerlof85.dojo.mrrs;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import org.openqa.selenium.By;

public class SelenideTest {
	
	//@Before
	//hier server starten?
/*	
	@Test  //jersey test
	public void selenide() throws Exception {
		  open("/");
		  $(By.tagName("H2")).shouldHave(text("Jersey RESTful Web Application!"));
		  $(By.linkText("Jersey resource")).click();
		  $(By.tagName("pre")).shouldHave(text("Got it!"));
		  
		  //$(By.name("user.name")).setValue("johny");
		 // $("#submit").click();
		 // $(".loading_progress").should(disappear); // Waits until element disappears
		 // $("#username").shouldHave(text("Hello, Johny!")); // Waits until element gets text
	}
	*/
	/*
	@Test
	public void meetingRooms() throws Exception {
		open("/meetingrooms.html");
		$(By.tagName("H1")).shouldHave(text("Meeting rooms"));
		$(By.xpath(("//html/body/table/tbody/tr[2]/td[1]"))).shouldHave(text("A1"));
		$(By.xpath(("//html/body/table/tbody/tr[2]/td[2]"))).shouldHave(text("California"));
		$(By.xpath(("//html/body/table/tbody/tr[2]/td[3]"))).shouldHave(text("12"));
		$(By.xpath(("//html/body/table/tbody/tr[2]/td[4]"))).shouldHave(text("phone, beamer, plant"));
	}
	*/
}
