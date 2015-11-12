/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Game;
import br.edu.ifsul.modelo.Plataforma;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jupassamani
 * @email juliapassamani@me.com
 */
public class TesteInserirGamePlataforma {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("TrabalhoSegundaEtapaPU");
            em = emf.createEntityManager();
            Game g = em.find(Game.class, 2);
            Plataforma p = em.find(Plataforma.class, 1);
            p.getContem().add(g);
            
            
            em.getTransaction().begin();
            em.persist(p); // inserir
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
