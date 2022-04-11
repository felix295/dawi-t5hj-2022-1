package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo2 {
	
	public static void main(String[] args) {
		//actualiar un usuario
		
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em = fabrica.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario u = new Usuario(55, "maria", "tataje", "mariatataje@gmail.com",
				"2222", "2000/11/01", 1, 2);
		
		em.merge(u);
		
		em.getTransaction().commit();
		
		em.close();
		
		
	}

}
