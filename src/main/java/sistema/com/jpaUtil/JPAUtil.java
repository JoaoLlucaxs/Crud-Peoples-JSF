package sistema.com.jpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory factory=null;
	
	static { // criando uma única vez o objeto responsável por prover
		if(factory == null) {
			factory=Persistence.createEntityManagerFactory("pos-jsf");
		}
		
	}
	
	//porque coloco static? Para ele ser um método únic
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
