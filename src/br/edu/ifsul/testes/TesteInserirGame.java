
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Game;
import br.edu.ifsul.modelo.Genero;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jupassamani
 * @email juliapassamani@me.com
 */
public class TesteInserirGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("TrabalhoSegundaEtapa");
            em = emf.createEntityManager();
            Genero gen = new Genero();
            gen.setDescricao("Acao");
            
            em.getTransaction().begin();
            em.persist(gen); // inserir
            em.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Erro: "+e.getMessage());
            if (em.getTransaction().isActive() == false){
                em.getTransaction().commit();
            }
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }

}
