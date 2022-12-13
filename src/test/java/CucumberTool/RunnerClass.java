package CucumberTool;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( //right click on you feature file that you want to execure, copy path
        features = "src\\test\\java\\CucumberTool\\Login.feature\\"
)


// "src\\test\\java\\CucumberTool\\Login.feature"  -this path should work for everyone



public class RunnerClass {

}
