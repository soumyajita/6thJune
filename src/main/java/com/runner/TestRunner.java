package com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
	features="src/main/java/com/features",
    glue= "com.stepdefination",
	monochrome= true,
	dryRun=false,
	tags = "@run",
	plugin= {"pretty","html:target/report.html"}
)

public class TestRunner {

}



