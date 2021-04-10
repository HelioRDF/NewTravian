package main;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src\\test\\java\\funcionalidades\\teste.feature"},			
		glue="executar",
		plugin = { "pretty",
		"html:target/report-html.html",
		"json:target/report-html.json" }, 
		monochrome = true, 
		snippets = SnippetType.CAMELCASE, 
		dryRun = false)
public class RunnerTest {

}
