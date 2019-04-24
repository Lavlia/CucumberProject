package runner;

import cucumber.api.cli.Main;
import org.testng.annotations.Test;

public class RerunTestRunner {

    //Runner for failed tests
    @Test
    public void rerunTestRunner() {

        Main.main(new String[]{"--threads", "3",
                "-p", "json:target/parallel-report-rerun/cucumber.json",
                "-p", "html:target/parallel-report",
                "-g", "stepDefinition", "@rerun.text",});
    }
}
