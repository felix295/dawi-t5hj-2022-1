package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo4 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em = fabrica.createEntityManager();
		
		Usuario u = em.find(Usuario.class, 55);
		
		if(u != null) 
		System.out.println(u);
		else
		System.err.println("CODIGO NO EXISTE !!");
		
		em.close();
		
	}

}
