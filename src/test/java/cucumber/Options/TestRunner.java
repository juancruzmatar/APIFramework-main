package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features", plugin = { "json:target/cucumber-reports/cucumber.json",
        "pretty", "html:target/html-report/cucumber-html-reports.html",
        "junit:target/cucumber-reports/cucumber.xml"  },glue= {"stepDefinations"},tags = "@AddPlace")
public class TestRunner {
//tags= {"@DeletePlace"}  compile test verify
}
