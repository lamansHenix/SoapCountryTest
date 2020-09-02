import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.model.testsuite.TestSuite;
import com.eviware.soapui.tools.SoapUITestCaseRunner;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class TestingSoapCurrency {
	
	
	@Test
		public void testRunner() throws Exception {
			SoapUITestCaseRunner runner = new SoapUITestCaseRunner();
			runner.setProjectFile("src/test/resources/SoapJunit.xml");
			runner.run();
		}
	
		//@Test
		public void testTestCaseSelecter() throws Exception
		{
			WsdlProject project = new WsdlProject("src/test/resources/SoapJunit.xml");
			System.out.println(project.getTestSuiteByName("Copy of TestSuite 2").getName());
			TestSuite TS = project.getTestSuiteByName("Copy of TestSuite 2");
			
			System.out.println(TS.getTestCaseByName("TestCase 2"));
			TestCase TC = TS.getTestCaseByName("TestCase 2");
		
			
			TestRunner runner = TC.run(new PropertiesMap(), false);
			assertEquals(Status.FINISHED, runner.getStatus());
			
		}
	
}
