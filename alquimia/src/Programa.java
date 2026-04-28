package modelo;

import java.util.Scanner;
import modelo.Pocao;


public class Programa {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- MESTRE ALQUIMISTA ---");
            System.out.println("1. Gerenciar Ingredientes");
            System.out.println("2. Gerenciar Caldeirões");
            System.out.println("3. Criar Poções (Transação)");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            if (opcao != 0) {
                menuEntidade(opcao);
            }
        }
    }

    private static void menuEntidade(int tipoEntidade) {
        int subOpcao = -1;
        String nomeEntidade = (tipoEntidade == 3) ? "Poção" : "Entidade " + tipoEntidade;

        while (subOpcao != 0) {
            System.out.println("\n-- Menu: " + nomeEntidade + " --");
            System.out.println("1. Inserir");
            System.out.println("2. Alterar");
            System.out.println("3. Apagar");
            System.out.println("4. Visualizar por ID");
            System.out.println("5. Visualizar Todos");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            subOpcao = scanner.nextInt();

            switch (subOpcao) {
                case 1 -> inserir(tipoEntidade);
                case 5 -> visualizarTodos(tipoEntidade);
            }
        }
    }

    private static void inserir(int tipo) {
        if (tipo == 3) { // Caso específico para a Transação (Poção)
            System.out.print("ID da Poção: ");
            int id = scanner.nextInt();
            System.out.print("Nome da Poção: ");
            String nome = scanner.next();

            Pocao novaPocao = new Pocao(id, nome);

            System.out.println("Adicionar ingredientes? (s/n)");
            if (scanner.next().equalsIgnoreCase("s")) {
                System.out.print("ID do Ingrediente: ");
                int idIng = scanner.nextInt();
                System.out.print("Quantidade: ");
                int qtd = scanner.nextInt();
            }
            novaPocao.salvar();
            System.out.println("Poção criada com sucesso!");
        }
    }

    private static void visualizarTodos(int tipo) {
        System.out.println("Listando todos os registros...");
        // Chama o método carregarTodos()
    }
}