
// Importações necessárias para utilizar as classes ProdutoDAO e Produto
import dao.ProdutoDAO;
import java.util.Scanner;
import model.Produto;

public class Main { 
    public static void main(String[] args) {
        // Instância de ProdutoDAO para gerenciar os produtos
        ProdutoDAO produtoDAO = new ProdutoDAO(); 
        // Scanner para capturar entrada do usuário
        Scanner scanner = new Scanner(System.in); 

        // Variável para controlar o loop
        String continuar = "sim";

        // Loop para adicionar produtos até o usuário parar
        while (continuar.equalsIgnoreCase("sim")) {
            // Solicita os dados do produto
            Produto produto = new Produto();
            System.out.print("Digite o nome do produto: ");
            produto.setNome(scanner.nextLine()); // Lê e define o nome do produto

            System.out.print("Digite o preço do produto: ");
            produto.setPreco(scanner.nextDouble()); // Lê e define o preço do produto
            scanner.nextLine(); // Consome a quebra de linha que sobra

            // Adiciona o produto ao "banco de dados"
            produtoDAO.criar(produto); 

            // Pergunta se deseja adicionar mais produtos
            System.out.print("Deseja adicionar outro produto? (sim/não): ");
            continuar = scanner.nextLine(); // Lê a resposta do usuário
        }

        // Lista todos os produtos armazenados
        System.out.println("Lista de produtos no banco de dados:");
        produtoDAO.listarTodos().forEach(p -> 
            System.out.println(p.getNome() + " - " + p.getPreco())); // Imprime nome e preço de cada produto

        scanner.close(); // Fecha o Scanner
    }
}
