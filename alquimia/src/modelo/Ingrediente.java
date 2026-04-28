package modelo;

import java.util.Scanner;

public class Ingrediente {
    private int qtdI;
    private int qtdB;
    private String[] ingredientes;
    private String[] base;

    public Ingrediente() {
        this.ingredientes = new String[]{
                "Mirtilo",
                "Morango",
                "Amora",
                "Flor de Lotus",
                "Raiz de Mandragora",
                "Cogumelo Vermelho",
                "Cogumelo Verde",
                "Essencia de Fogo",
                "Essencia de Gelo",
                "Asa de morcego"
        };
        this.qtdI = ingredientes.length;
        this.base = new String[]{
                "Agua",
                "Oleo",
                "Toxina"
        };
        this.qtdB = base.length;

    }

    public void listaDeComponentes(){
        System.out.println("Ingredientes:");
        for (int i = 0; i<qtdI; i++){
            System.out.println(this.ingredientes[i]);
        }
    }

    public String[] getIngredientes() {
        return ingredientes;
    }
}

