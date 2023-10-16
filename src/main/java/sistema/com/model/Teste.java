package sistema.com.model;

import javax.persistence.Persistence;

public class Teste {
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("pos-jsf");
	}
}
