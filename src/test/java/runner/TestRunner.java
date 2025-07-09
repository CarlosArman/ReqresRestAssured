package runner;

import io.cucumber.core.options.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features") // Ruta relativa a src/test/resources
@ConfigurationParameter(
        key = Constants.GLUE_PROPERTY_NAME,
        value = "stepdefinitions" // Paquetes donde están los step definitions y hooks
)
@ConfigurationParameter(
        key = Constants.PLUGIN_PROPERTY_NAME,
        value = "pretty, json:target/report/cucumber-report.json, html:target/report/cucumber-report.html"
)
@ConfigurationParameter(
        key = Constants.FILTER_TAGS_PROPERTY_NAME,
        value = "@Reqres" // Aquí defines el tag que quieres ejecutar
)
public class TestRunner {
}
