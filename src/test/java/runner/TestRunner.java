package runner;

import cucumber.api.cli.Main;
import org.testng.annotations.Test;

public class TestRunner {

    //Runner for tests
    @Test
    public void testRunner() {
        Main.main(new String[]{"--threads", "3",
                "-p", "json:target/parallel-report/cucumber.json",
                "-p", "html:target/parallel-report",
                "-p", "rerun:rerun.text",
                "-g", "stepDefinition", "src/test/java/features"});
    }

}
