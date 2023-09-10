package org.sang;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class Test23Test {
	
	@Autowired
	private PersonRepository personRepo;

	//@Test
	public void test01() {
		//fail("Not yet implemented");
		List<Person> persons = personRepo.findAll();
		for (Person s : persons) {
			System.out.println(s.toString());
		}
	}


}
