package org.sang;

import static org.junit.jupiter.api.Assertions.*;

import org.jmock.Mockery;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class testjMock extends TestCase {
	
	Mockery context = new Mockery();
	
	public void testOneSubscriberReceivesAMessage() {
        // set up
        final Subscriber subscriber = context.mock(Subscriber.class);

        Publisher publisher = new Publisher();
        publisher.add(subscriber);
        
        final String message = "message";
        
        // expectations
        context.checking(new Expectations() {{
            oneOf (subscriber).receive(message);
        }});

        // execute
        publisher.publish(message);
        
        // verify
        context.assertIsSatisfied();
    }
	
	@Test
	void test() {
		//fail("Not yet implemented");
		// set up
        
	}

}
