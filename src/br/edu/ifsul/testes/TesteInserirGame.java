
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
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
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
            Genero obj = new Genero();
            obj.setDescricao("Acao");
            Game ga = new Game();
            ga.setAno("1990");
            ga.setJogabilidade("Multiplayer");
            ga.setNome("Mario");
            ga.setId(1);
          //  ga.setGenero(obj);
            List<Game> games = new ArrayList<>();
            games.add(ga);
            obj.setGames(games);
            
            
            em.getTransaction().begin();
            em.persist(obj); // inserir
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
