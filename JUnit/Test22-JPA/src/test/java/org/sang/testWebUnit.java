package org.sang;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;
import net.sourceforge.jwebunit.junit.WebTester;

public class testWebUnit extends TestCase {
	
	private WebTester tester;
	
	public testWebUnit(String name) {
		super(name);
		tester = new WebTester();
	}
	
	public void setUp() throws Exception {
		tester.setBaseUrl("https://www.google.com");
	}

	@Test
	public void test() {
		tester.beginAt("/search?q=jwebunit+download");
		//fail("Not yet implemented");
	}

}
