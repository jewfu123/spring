package org.keycloak.examples.rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.keycloak.examples.rest.EventEntity;

public class showJpa {

	@PersistenceContext
    private EntityManager entityManager;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("show me jpa.");
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("standalonePu");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		
//		EmployeeEntity empo = new EmployeeEntity();
//		empo.setNAME("fuhong");
//		empo.setCARD("a superman");
//		em.getTransaction().commit();
//		
//		em.close();
//		emf.close();
		
//		testEntity.setNAME("fuhong");
//		testEntity.setCARD("a superman");
//
//		entityManager.persist(testEntity);
		
		System.out.println("a record inserted!");
	}

}
