package modelo;

public class Componente {
    private Ingrediente ingrediente;
    private int quantidade;

    public Componente(Ingrediente ingrediente, int quantidade) {
        this.ingrediente = ingrediente;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    public Ingrediente getIngrediente() { return ingrediente; }
    public void setIngrediente(Ingrediente ingrediente) { this.ingrediente = ingrediente; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    @Override
    public String toString() {
        return ingrediente.getNome() + " (Qtd: " + quantidade + ")";
    }
}