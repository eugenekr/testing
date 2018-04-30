package runner;

import org.testng.ITestNGListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;

/**
 * Created by HP on 2/2/2018.
 */
public class Runner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        ITestNGListener iTestNGListener = new TestListenerAdapter();
        testNG.addListener(iTestNGListener);
//        testNG.addListener(new CustomListener());

        final XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("gmail suite");
        xmlSuite.setSuiteFiles(new ArrayList<String>(){{
            add(".src/main/java/test/suites/TEST_SUITE.xml");
        }});

        testNG.setXmlSuites(new ArrayList<XmlSuite>(){{
            add(xmlSuite);
        }});
        testNG.run();
    }
}
