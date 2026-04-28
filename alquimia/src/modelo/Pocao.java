package modelo;

import java.util.ArrayList;
import java.util.List;
import persistencia.BancoDados;

public class Pocao extends Entidade<Pocao> {
    private String nomePocao;
    private List<Componente> componentes;

    public Pocao(int id, String nomePocao) {
        super(id);
        this.nomePocao = nomePocao;
        this.componentes = new ArrayList<>();
    }

    public void adicionarComponente(Ingrediente ing, int qtd) {
        componentes.add(new Componente(ing, qtd));
    }

    @Override
    public boolean salvar() {
        return super.salvarNoBanco(BancoDados.bancoPocao);
    }

    @Override
    public boolean atualizar() {
        return super.atualizarNoBanco(BancoDados.bancoPocao);
    }

    @Override
    public boolean apagar(int id) {
        return super.apagarDoBanco(id, BancoDados.bancoPocao);
    }

    @Override
    public boolean carregar(int id) {
        Pocao dados = super.carregarDoBanco(id, BancoDados.bancoPocao);
        if (dados != null) {
            this.setId(dados.getId()); // <-- FALTAVA ISSO
            this.nomePocao = dados.nomePocao;
            this.componentes = dados.componentes;
            this.setPersistido(true);
            return true;
        }
        return false;
    }

    @Override
    public List<Pocao> carregarTodos() {
        return new ArrayList<>(BancoDados.bancoPocao.values());
    }

    @Override
    public String toString() {
        return "Poção [ID: " + getId() + " | Nome: " + nomePocao + " | Itens: " + componentes + "]";
    }
}