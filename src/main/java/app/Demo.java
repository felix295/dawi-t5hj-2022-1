package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo {
	
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em = fabrica.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario u = new Usuario(20, "juana", "flores", "juana@gmail.com",
				"5555", "2000/12/01", 2, 1);
		
		em.persist(u);
		
		em.getTransaction().commit();
		
		em.close();
		
	}

}
