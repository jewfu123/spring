package com.desafio.jax.ibm.webservice.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.desafio.jax.ibm.webservice.model.Event;

public class EventDAO {

	/*  
	 * M�todo que faz a conex�o com banco de dados e consulta.
	 * */
//	public Event save(Event event) {    
//		EntityManager em = JPAUtil.getEntityManager();
//        try {
//			em.getTransaction().begin();
//			em.persist(event);
//			em.getTransaction().commit();
//        } catch (Exception e) {
//        	em.getTransaction().rollback();
//            e.printStackTrace();
//        } finally {
//			em.close();
//		}
//        return event;
//	}
	
	/*  
	 * M�todo que faz a conex�o com banco de dados e consulta por pessoas.
	 * */
//	public List<Event> findByCpfOrName(String search) {
//		EntityManager em = JPAUtil.getEntityManager();
//		List<Event> events = null;
//        try {
//        	events = em.createQuery("select p from Event p where p.user_id = :user_id", Event.class)
//            		.setParameter("user_id", search)
//            		.getResultList();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//			em.close();
//		}
//        return events;
//	}
	
	public List<Event> findAll() {
		EntityManager em = JPAUtil.getEntityManager();
		List<Event> events = null;
        try {
        	events = em.createQuery("select p from Event p", Event.class)
            		.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
			em.close();
		}
        return events;
	}
}
