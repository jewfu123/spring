package org.sang;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest 
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes=Test22JpaApplicationTests.class)
public class testDBTest {
	
	@Autowired
    private PersonRepository personRepository;
	
	//@Test
	//@DisplayName("List All")
	public void test01() {
		//fail("Not yet implemented");
		List<Person> pbls = personRepository.findByAddress("beijing");
		for (Person person : pbls) {
			System.out.println(person.getName());
			System.out.println(person.getAddress());
			System.out.println(person.getAge());
		}
	}
	
	//@Test
	public void test02() {
		//fail("Not yet implemented");
		List<Person> pbls = personRepository.findAll();
		for (Person person : pbls) {
			System.out.println(person.getName());
			System.out.println(person.getAddress());
			System.out.println(person.getAge());
		}
		
	}

	
	@Test
	@DisplayName("Equals")
	public void test03() {
		int i1 = 1;
		int i2 = 3;
		assertEquals(4, i1+i2);
	}
	
	//execute before class
   @BeforeClass
   public static void beforeClass() {
      System.out.println("in before class");
   }

   //execute after class
   @AfterClass
   public static void  afterClass() {
      System.out.println("in after class");
   }

   //execute before test
   @Before
   public void before() {
      System.out.println("in before");
   }

   //execute after test
   @After
   //@DisplayName("After..")
   public void after() {
      System.out.println("in after");
   }

   //test case
   @Test
   public void test() {
      System.out.println("in test");
   }

   //test case ignore and will not execute
   @Ignore
   public void ignoreTest() {
      System.out.println("in ignore test");
   }
   

}
