package modelo;

public class ReceitaPocao {

    private static final String[] POCOES = {
        "Poção de Vida",
        "Poção de Força",
        "Poção de Velocidade",
        "Poção de Resistência",
        "Poção de Resistência a Veneno",
        "Poção de Invisibilidade",
        "Poção de Visão Noturna",
        "Poção de Veneno"
    };

    public static String criarPocao(String ingrediente1, String ingrediente2, String base) {

        // Poção de Vida
        if (ingrediente1.equalsIgnoreCase("Cogumelo Vermelho") &&
            ingrediente2.equalsIgnoreCase("Morango") &&
            base.equalsIgnoreCase("Agua")) {
            return POCOES[0];
        }

        // Poção de Força
        if (ingrediente1.equalsIgnoreCase("Asa de morcego") &&
            ingrediente2.equalsIgnoreCase("Raiz de Mandragora") &&
            base.equalsIgnoreCase("Agua")) {
            return POCOES[1];
        }

        // Poção de Velocidade
        if (ingrediente1.equalsIgnoreCase("Flor de Lotus") &&
            ingrediente2.equalsIgnoreCase("Amora") &&
            base.equalsIgnoreCase("Agua")) {
            return POCOES[2];
        }

        // Poção de Resistência
        if (ingrediente1.equalsIgnoreCase("Essencia de Gelo") &&
            ingrediente2.equalsIgnoreCase("Cogumelo Verde") &&
            base.equalsIgnoreCase("Oleo")) {
            return POCOES[3];
        }

        // Poção de Resistência a Veneno
        if (ingrediente1.equalsIgnoreCase("Mirtilo") &&
            ingrediente2.equalsIgnoreCase("Flor de Lotus") &&
            base.equalsIgnoreCase("Toxina")) {
            return POCOES[4];
        }

        // Poção de Invisibilidade
        if (ingrediente1.equalsIgnoreCase("Flor de Lotus") &&
            ingrediente2.equalsIgnoreCase("Asa de morcego") &&
            base.equalsIgnoreCase("Oleo")) {
            return POCOES[5];
        }

        // Poção de Visão Noturna
        if (ingrediente1.equalsIgnoreCase("Mirtilo") &&
            ingrediente2.equalsIgnoreCase("Essencia de Fogo") &&
            base.equalsIgnoreCase("Agua")) {
            return POCOES[6];
        }

        // Poção de Veneno
        if (ingrediente1.equalsIgnoreCase("Cogumelo Verde") &&
            ingrediente2.equalsIgnoreCase("Toxina") &&
            base.equalsIgnoreCase("Toxina")) {
            return POCOES[7];
        }

        return "Falha na mistura";
    }
}