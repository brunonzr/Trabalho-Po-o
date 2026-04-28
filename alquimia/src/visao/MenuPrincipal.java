package visao;

import java.util.Scanner;
import modelo.*;
import persistencia.BancoDados;

public class MenuPrincipal {

    private static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        carregarIngredientesPadrao();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- ⚗️ MESTRE ALQUIMISTA ---");
            System.out.println("1 Ingredientes | 2 Caldeirões | 3 Poções | 0 Sair");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(scanner.nextLine());

            if (opcao != 0) {
                menuCRUD(opcao);
            }
        }
    }

    // ================= MENU CRUD =================
    private static void menuCRUD(int tipo) {
        int op = -1;

        while (op != 0) {
            System.out.println("\n1 Inserir | 2 Atualizar | 3 Apagar | 4 Listar | 5 Gerenciar Componentes | 0 Voltar");

            op = Integer.parseInt(scanner.nextLine());

            switch (op) {
                case 1 -> inserir(tipo);
                case 2 -> atualizar(tipo);
                case 3 -> apagar(tipo);
                case 4 -> listar(tipo);
                case 5 -> {
                    if (tipo == 3)
                        gerenciarComponentes();
                    else
                        System.out.println("Opção válida apenas para Poções.");
                }
            }
        }
    }

    // ================= INSERIR =================
    private static void inserir(int tipo) {

        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        switch (tipo) {

            case 1 -> {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                Ingrediente i = new Ingrediente(id, nome);
                System.out.println(i.salvar() ? "Salvo!" : "Erro ao salvar.");
            }

            case 2 -> {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Está ativo? (true/false): ");
                boolean status = Boolean.parseBoolean(scanner.nextLine());

                Caldeirao c = new Caldeirao(id, nome, status);
                System.out.println(c.salvar() ? "Salvo!" : "Erro ao salvar.");
            }

            case 3 -> {
                System.out.print("Nome da Poção: ");
                String nome = scanner.nextLine();

                if (BancoDados.bancoCaldeirao.isEmpty()) {
                    System.out.println("Nenhum caldeirão cadastrado!");
                    return;
                }

                System.out.println("\n--- CALDEIRÕES ---");
                BancoDados.bancoCaldeirao.forEach((idC, c) ->
                    System.out.println(idC + " - " + c.getNome() + " | Ativo: " + c.isStatus())
                );

                System.out.print("Escolha o ID do caldeirão: ");
                int idC = Integer.parseInt(scanner.nextLine());

                Caldeirao c = BancoDados.bancoCaldeirao.get(idC);

                if (c == null) {
                    System.out.println("Caldeirão inválido!");
                    return;
                }

                Pocao p = new Pocao(id, nome, c);

                System.out.println(p.salvar() ? "Salvo!" : "Erro ao salvar.");
            }
        }
    }

    // ================= ATUALIZAR =================
    private static void atualizar(int tipo) {

        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        switch (tipo) {

            case 1 -> {
                System.out.print("Novo nome: ");
                String nome = scanner.nextLine();
                Ingrediente i = new Ingrediente(id, nome);
                i.setPersistido(true);
                System.out.println(i.atualizar() ? "Atualizado!" : "Erro.");
            }

            case 2 -> {
                System.out.print("Novo nome: ");
                String nome = scanner.nextLine();
                System.out.print("Status (true/false): ");
                boolean status = Boolean.parseBoolean(scanner.nextLine());

                Caldeirao c = new Caldeirao(id, nome, status);
                c.setPersistido(true);
                System.out.println(c.atualizar() ? "Atualizado!" : "Erro.");
            }

            case 3 -> {
                System.out.print("Novo nome: ");
                String nome = scanner.nextLine();

                Pocao p = new Pocao(0, "", null);
                if (!p.carregar(id)) {
                    System.out.println("Poção não encontrada.");
                    return;
                }

                p.setNome(nome);
                System.out.println(p.atualizar() ? "Atualizado!" : "Erro.");
            }
        }
    }

    // ================= APAGAR =================
    private static void apagar(int tipo) {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean sucesso = switch (tipo) {
            case 1 -> new Ingrediente(0, "").apagar(id);
            case 2 -> new Caldeirao().apagar(id);
            case 3 -> new Pocao(0, "", null).apagar(id);
            default -> false;
        };

        System.out.println(sucesso ? "Apagado!" : "Não encontrado.");
    }

    // ================= LISTAR =================
    private static void listar(int tipo) {

        switch (tipo) {

            case 1 -> BancoDados.bancoIngrediente.values().forEach(System.out::println);

            case 2 -> BancoDados.bancoCaldeirao.values().forEach(System.out::println);

            case 3 -> {
                BancoDados.bancoPocao.values().forEach(p -> {
                    System.out.println(p);
                    System.out.println("Resultado: " + ReceitaPocao.verificarReceita(p));
                    System.out.println("-------------------");
                });
            }
        }
    }

    // ================= GERENCIAR COMPONENTES =================
    private static void gerenciarComponentes() {

        if (BancoDados.bancoPocao.isEmpty()) {
            System.out.println("Nenhuma poção cadastrada.");
            return;
        }

        System.out.print("ID da poção: ");
        int id = Integer.parseInt(scanner.nextLine());

        Pocao p = new Pocao(0, "", null);
        if (!p.carregar(id)) {
            System.out.println("Poção não encontrada.");
            return;
        }

        int op = -1;

        while (op != 0) {
            System.out.println("\n--- GERENCIAR COMPONENTES ---");
            System.out.println("1 Adicionar");
            System.out.println("2 Remover");
            System.out.println("3 Listar");
            System.out.println("4 Verificar Receita");
            System.out.println("0 Voltar");

            op = Integer.parseInt(scanner.nextLine());

            switch (op) {

                case 1 -> {
                    listarIngredientes();

                    System.out.print("ID do ingrediente: ");
                    int idIng = Integer.parseInt(scanner.nextLine());

                    Ingrediente ing = BancoDados.bancoIngrediente.get(idIng);
                    if (ing == null) {
                        System.out.println("Ingrediente inválido.");
                        break;
                    }

                    System.out.print("Quantidade: ");
                    int qtd = Integer.parseInt(scanner.nextLine());

                    p.adicionarComponente(ing, qtd);
                    p.atualizar();

                    System.out.println("Adicionado!");
                }

                case 2 -> {
                    listarComponentes(p);

                    System.out.print("Índice para remover: ");
                    int index = Integer.parseInt(scanner.nextLine());

                    p.removerComponente(index);
                    p.atualizar();

                    System.out.println("Removido!");
                }

                case 3 -> listarComponentes(p);

                case 4 -> {
                    String resultado = ReceitaPocao.verificarReceita(p);
                    System.out.println("Resultado: " + resultado);
                }
            }
        }
    }

    // ================= AUXILIARES =================
    private static void listarIngredientes() {
        System.out.println("\n--- INGREDIENTES ---");
        BancoDados.bancoIngrediente.forEach((id, ing) ->
            System.out.println(id + " - " + ing.getNome())
        );
    }

    private static void listarComponentes(Pocao p) {
        System.out.println("\n--- COMPONENTES ---");

        int i = 0;
        for (Componente c : p.getComponentes()) {
            System.out.println(i + " - " + c);
            i++;
        }
    }

    private static void carregarIngredientesPadrao() {

        new Ingrediente(1, "Cogumelo Vermelho").salvar();
        new Ingrediente(2, "Morango").salvar();
        new Ingrediente(3, "Agua").salvar();
        new Ingrediente(4, "Asa de morcego").salvar();
        new Ingrediente(5, "Raiz de Mandragora").salvar();
        new Ingrediente(6, "Flor de Lotus").salvar();
        new Ingrediente(7, "Amora").salvar();
        new Ingrediente(8, "Essencia de Gelo").salvar();
        new Ingrediente(9, "Cogumelo Verde").salvar();
        new Ingrediente(10, "Oleo").salvar();
        new Ingrediente(11, "Mirtilo").salvar();
        new Ingrediente(12, "Toxina").salvar();
        new Ingrediente(13, "Essencia de Fogo").salvar();
    }
}