
package br.edu.ifsul.testes;


import br.edu.ifsul.modelo.Game;
import br.edu.ifsul.modelo.Genero;
import java.util.ArrayList;
import java.util.List;
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
            emf = Persistence.createEntityManagerFactory("TrabalhoSegundaEtapaPU");
            em = emf.createEntityManager();
            Game g = new Game();
            g.setAno("2000");
            g.setGenero(em.find(Genero.class, 1));
            g.setJogabilidade("Multiplayer");
            g.setNome("Resident Evil 4");
            
            em.getTransaction().begin();
            em.persist(g); // inserir
            em.getTransaction().commit();
        } catch(Exception e){
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
