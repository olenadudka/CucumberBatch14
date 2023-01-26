package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all feature files
        features ="src/test/resources/features/",
        glue="APISteps", //to  connect step def with feature files
        //when you set dry run to true, it stops actual execution
        //it will quickly scan all the gherkin steps whether they are implemented or not
        dryRun=false,
        //when we set dry run to false, it starts execution again
        tags="@api", //if we need to execute just 1 scenario or 2 "@sprint3 or @sprint1"

        //to remove irrelevant information from console you need to set monochrome to true

        monochrome =true,
        //pretty keaword prints the steps in the console to increase readability
        //to generate the report we need plugin of runner class
        plugin={"pretty", "html:target/cucumber.html", "json:target/cucumber.json",
                //this failed.txt file holds all the scenarios which are failed during the execution
                "rerun:target/failed.txt"}

)
        public class APIRunner {
}
