package dao;

import model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProdutoDAO {

    // Fábrica de gerenciadores de entidade, configurada com a unidade de persistência "produtoPU"
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("produtoPU");

    // Método para criar um novo registro de Produto no banco de dados
    public void criar(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin(); // Inicia a transação
            em.persist(produto); // Persiste o objeto Produto no banco
            em.getTransaction().commit(); // Confirma a transação
        } catch (Exception e) {
            em.getTransaction().rollback(); // Desfaz a transação em caso de erro
            throw new RuntimeException("Erro ao criar o produto: " + e.getMessage(), e);
        } finally {
            em.close(); // Fecha o gerenciador de entidades
        }
    }

    // Método para ler um Produto do banco de dados a partir do ID
    public Produto ler(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID não pode ser nulo.");
        }
        EntityManager em = emf.createEntityManager();
        try {
            Produto produto = em.find(Produto.class, id); // Busca o Produto pelo ID
            if (produto == null) {
                System.out.println("Produto com ID " + id + " não encontrado.");
            }
            return produto;
        } finally {
            em.close(); // Fecha o gerenciador de entidades
        }
    }

    // Método para listar todos os Produtos do banco de dados
    public List<Produto> listarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("FROM Produto", Produto.class).getResultList(); // Busca todos os produtos
        } finally {
            em.close(); // Fecha o gerenciador de entidades
        }
    }

    // Método para atualizar um Produto existente no banco de dados
    public void atualizar(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin(); // Inicia a transação
            em.merge(produto); // Atualiza o objeto Produto no banco
            em.getTransaction().commit(); // Confirma a transação
        } catch (Exception e) {
            em.getTransaction().rollback(); // Desfaz a transação em caso de erro
            throw new RuntimeException("Erro ao atualizar o produto: " + e.getMessage(), e);
        } finally {
            em.close(); // Fecha o gerenciador de entidades
        }
    }

    // Método para excluir um Produto do banco de dados a partir do ID
    public void excluir(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID não pode ser nulo.");
        }
        EntityManager em = emf.createEntityManager();
        try {
            Produto produto = em.find(Produto.class, id); // Busca o Produto pelo ID
            if (produto != null) { // Verifica se o Produto foi encontrado
                em.getTransaction().begin(); // Inicia a transação
                em.remove(produto); // Remove o Produto do banco
                em.getTransaction().commit(); // Confirma a transação
            } else {
                System.out.println("Produto com ID " + id + " não encontrado.");
            }
        } catch (Exception e) {
            em.getTransaction().rollback(); // Desfaz a transação em caso de erro
            throw new RuntimeException("Erro ao excluir o produto: " + e.getMessage(), e);
        } finally {
            em.close(); // Fecha o gerenciador de entidades
        }
    }

    // Método para encerrar a fábrica de gerenciadores ao final da aplicação
    public static void fecharEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
