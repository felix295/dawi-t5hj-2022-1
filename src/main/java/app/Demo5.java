package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo5 {
	
	public static void main(String[] args) {
		//eliminar version mejorada
		
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em = fabrica.createEntityManager();
		
		Usuario u = em.find(Usuario.class, 55);
		
		if(u != null) {
			
			em.getTransaction().begin();
		    em.remove(u);
		    em.getTransaction().commit();
		    
		    
		     System.out.println("SE ELIMINO ESTE CODIGO ");
		}else {
		System.err.println("CODIGO NO EXISTE !!");
		    
		}
		
		em.close();
		
	}

}
