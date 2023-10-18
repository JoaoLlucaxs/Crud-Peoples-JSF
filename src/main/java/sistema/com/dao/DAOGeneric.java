package sistema.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import sistema.com.jpaUtil.JPAUtil;

public class DAOGeneric<A> {
	
	public void salvar(A entidade) {
		EntityManager entitymanager=JPAUtil.getEntityManager();
		EntityTransaction transaction=entitymanager.getTransaction();
		transaction.begin();
		
		entitymanager.persist(entidade);
		
		transaction.commit();
		
		entitymanager.close();
		
	}
	
	public A merge(A entidade) {
		EntityManager entitymanager=JPAUtil.getEntityManager();
		EntityTransaction transaction=entitymanager.getTransaction();
		transaction.begin();
		
		A retornaMerge=entitymanager.merge(entidade);
		
		transaction.commit();
		entitymanager.close();
		
		return retornaMerge;
		
	}
}
