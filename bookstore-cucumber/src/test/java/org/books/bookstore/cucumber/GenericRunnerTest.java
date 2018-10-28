package org.books.bookstore.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)

@CucumberOptions(features={"src/test/resources/features/"}, 
glue={"org.books.bookstore.cucumber.stepdefinitions"},
monochrome = true,
plugin = { "pretty" })
public class GenericRunnerTest {
	
}
    