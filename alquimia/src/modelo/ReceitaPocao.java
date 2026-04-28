package modelo;

public class ReceitaPocao {

    public static String verificarReceita(Pocao p) {

        if (p.getComponentes().size() < 3)
            return "Falha na mistura";

        String ing1 = p.getComponentes().get(0).getIngrediente().getNome();
        String ing2 = p.getComponentes().get(1).getIngrediente().getNome();
        String base = p.getComponentes().get(2).getIngrediente().getNome();

        if (ing1.equalsIgnoreCase("Cogumelo Vermelho") &&
            ing2.equalsIgnoreCase("Morango") &&
            base.equalsIgnoreCase("Agua"))
            return "Poção de Vida";

        if (ing1.equalsIgnoreCase("Asa de morcego") &&
            ing2.equalsIgnoreCase("Raiz de Mandragora") &&
            base.equalsIgnoreCase("Agua"))
            return "Poção de Força";

        if (ing1.equalsIgnoreCase("Flor de Lotus") &&
            ing2.equalsIgnoreCase("Amora") &&
            base.equalsIgnoreCase("Agua"))
            return "Poção de Velocidade";

        if (ing1.equalsIgnoreCase("Essencia de Gelo") &&
            ing2.equalsIgnoreCase("Cogumelo Verde") &&
            base.equalsIgnoreCase("Oleo"))
            return "Poção de Resistência";

        if (ing1.equalsIgnoreCase("Mirtilo") &&
            ing2.equalsIgnoreCase("Flor de Lotus") &&
            base.equalsIgnoreCase("Toxina"))
            return "Poção de Resistência a Veneno";

        if (ing1.equalsIgnoreCase("Flor de Lotus") &&
            ing2.equalsIgnoreCase("Asa de morcego") &&
            base.equalsIgnoreCase("Oleo"))
            return "Poção de Invisibilidade";

        if (ing1.equalsIgnoreCase("Mirtilo") &&
            ing2.equalsIgnoreCase("Essencia de Fogo") &&
            base.equalsIgnoreCase("Agua"))
            return "Poção de Visão Noturna";

        if (ing1.equalsIgnoreCase("Cogumelo Verde") &&
            ing2.equalsIgnoreCase("Toxina") &&
            base.equalsIgnoreCase("Toxina"))
            return "Poção de Veneno";

        return "Falha na mistura";
    }
}