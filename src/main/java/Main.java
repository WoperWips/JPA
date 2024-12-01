package main.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        boolean continuar = true;

        while (continuar) {
            Produto produto = new Produto();

            System.out.print("Digite o nome do produto: ");
            if (scanner.hasNextLine()) {
                produto.setNome(scanner.nextLine()); // Lê e define o nome do produto
            } else {
                System.out.println("Nenhuma linha encontrada. Encerrando.");
                break;
            }

            System.out.print("Digite o preço do produto: ");
            if (scanner.hasNextDouble()) {
                produto.setPreco(scanner.nextDouble()); // Lê e define o preço do produto
                scanner.nextLine(); // Consome a quebra de linha que sobra
            } else {
                System.out.println("Entrada inválida para o preço. Encerrando.");
                break;
            }

            // Adiciona o produto ao "banco de dados"
            produtoDAO.criar(produto);

            // Pergunta se deseja adicionar mais produtos
            System.out.print("Deseja adicionar outro produto? (sim/não): ");
            if (scanner.hasNextLine()) {
                continuar = scanner.nextLine().equalsIgnoreCase("sim"); // Lê a resposta do usuário
            } else {
                System.out.println("Nenhuma linha encontrada. Encerrando.");
                break;
            }
        }

        // Lista todos os produtos armazenados
        System.out.println("Lista de produtos no banco de dados:");
        produtoDAO.listarTodos().forEach(p ->
            System.out.println(p.getNome() + " - " + p.getPreco())); // Imprime nome e preço de cada produto

        scanner.close(); // Fecha o Scanner
    }
}