package org.sang;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test22JpaApplicationTests {

	@Test
	public void contextLoads() {
		Result result = JUnitCore.runClasses(testDBTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}

}
