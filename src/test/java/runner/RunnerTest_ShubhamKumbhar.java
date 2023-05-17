package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"features"},glue = "StepDefinations",plugin= {"html:target/reports/report.html"})
public class RunnerTest_ShubhamKumbhar {
}
