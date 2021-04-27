package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {
	public static void main(String[] args) {
		/*
		 * Pessoa p1 = new Pessoa (null, "carlos", "carlos@gmail"); Pessoa p2 = new
		 * Pessoa (null,"Joaquie", "joaquie@hotmail"); Pessoa p3 = new Pessoa
		 * (null,"Ana","ana@uol.com");
		 */
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();		
		
		//SALVAR DADOS NO BD PHPMYADMIN
		/*
		 * em.getTransaction().begin(); em.persist(p1); em.persist(p2); em.persist(p3);
		 * em.getTransaction().commit();
		 */
		
		//BUSCAR O OBJETO PELO ID NO BD
		/*
		 * Pessoa p = em.find(Pessoa.class, 2);
		 * 
		 * System.out.println(p); 
		 */
		
		//REMOVER OBJETO NO BD - tem que estar monitorada
		Pessoa p = em.find(Pessoa.class, 2);
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("FINISH!!!!");
		
		em.close();
		emf.close();
		
		/*System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);*/
	}
}
