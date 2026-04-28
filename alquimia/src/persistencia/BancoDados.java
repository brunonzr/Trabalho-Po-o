package persistencia;

import modelo.*;
import java.util.HashMap;
import java.util.Map;

public class BancoDados {
    public static Map<Integer, Caldeirao> bancoCaldeirao = new HashMap<>();
    public static Map<Integer, Pocao> bancoPocao = new HashMap<>();
    public static Map<Integer, Ingrediente> bancoIngrediente = new HashMap<>();
}