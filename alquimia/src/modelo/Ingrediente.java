package modelo;

import persistencia.BancoDados;
import java.util.ArrayList;
import java.util.List;

public class Ingrediente extends Entidade<Ingrediente> {
    private String nome;

    public Ingrediente(int id, String nome) {
        super(id);
        this.nome = nome;
    }

    public String getNome() { return nome; }

    @Override
    public boolean salvar() {
        return super.salvarNoBanco(BancoDados.bancoIngrediente);
    }

    @Override
    public boolean atualizar() {
        return super.atualizarNoBanco(BancoDados.bancoIngrediente);
    }

    @Override
    public boolean apagar(int id) {
        return super.apagarDoBanco(id, BancoDados.bancoIngrediente);
    }

    @Override
    public boolean carregar(int id) {
        Ingrediente dados = super.carregarDoBanco(id, BancoDados.bancoIngrediente);
        if (dados != null) {
            this.setId(dados.getId());
            this.nome = dados.nome;
            this.setPersistido(true);
            return true;
        }
        return false;
    }

    @Override
    public List<Ingrediente> carregarTodos() {
        return new ArrayList<>(BancoDados.bancoIngrediente.values());
    }

    @Override
    public String toString() {
        return super.toString() + " | Nome: " + nome;
    }
}