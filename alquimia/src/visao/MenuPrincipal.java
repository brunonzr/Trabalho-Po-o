package visao;

import java.util.Scanner;
import persistencia.BancoDados;
import modelo.*;

public class MenuPrincipal {

    private static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        BancoDados.bancoIngrediente.put(1, new Ingrediente(1, "Mirtilo"));

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- ⚗️ MESTRE ALQUIMISTA ---");
            System.out.println("1. Ingredientes | 2. Caldeirões | 3. Poções | 0. Sair");
            opcao = Integer.parseInt(scanner.nextLine());

            if (opcao != 0) menuCRUD(opcao);
        }
    }

    private static void menuCRUD(int tipo) {
        int op = -1;
        while (op != 0) {
            System.out.println("\n1 Inserir | 2 Atualizar | 3 Apagar | 4 Listar");
            op = Integer.parseInt(scanner.nextLine());

            switch (op) {
                case 1 -> inserir(tipo);
                case 2 -> atualizar(tipo);
                case 3 -> apagar(tipo);
                case 4 -> listar(tipo);
            }
        }
    }

    private static void inserir(int tipo) {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (tipo == 1) {
            System.out.print("Nome: ");
            new Ingrediente(id, scanner.nextLine()).salvar();
        }
    }

    private static void atualizar(int tipo) {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (tipo == 1) {
            Ingrediente i = new Ingrediente(0, "");
            if (i.carregar(id)) {
                System.out.print("Novo nome: ");
                i = new Ingrediente(id, scanner.nextLine());
                i.setPersistido(true);
                i.atualizar();
            }
        }
    }

    private static void apagar(int tipo) {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (tipo == 1) new Ingrediente(0, "").apagar(id);
    }

    private static void listar(int tipo) {
        if (tipo == 1)
            BancoDados.bancoIngrediente.values().forEach(System.out::println);
    }
}