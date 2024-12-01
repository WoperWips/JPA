package main.java;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProdutoDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("produtoPU");
    private EntityManager em;

    public ProdutoDAO() {
        em = emf.createEntityManager();
    }

    public void criar(Produto produto) {
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
    }

    public List<Produto> listarTodos() {
        return em.createQuery("from Produto", Produto.class).getResultList();
    }
}