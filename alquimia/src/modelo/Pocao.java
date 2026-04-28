package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import persistencia.BancoDados;

public class Pocao extends Entidade {
    private String nomePocao;
    private List<Componente> componentes;

    public Pocao(int id, String nomePocao) {
        super(id);
        this.nomePocao = nomePocao;
        this.componentes = new ArrayList<>();
    }

    public void adicionarComponente(Ingrediente ing, int qtd) {
        this.componentes.add(new Componente(ing, qtd));
    }

    public void removerComponente(int index) {
        if (index >= 0 && index < componentes.size()) {
            this.componentes.remove(index);
        }
    }

    @Override
    public boolean salvar() {
        return super.salvar((Map) BancoDados.bancoPocao);
    }

    @Override
    public boolean atualizar() {
        return super.atualizar((Map) BancoDados.bancoPocao);
    }

    @Override
    public boolean apagar(int id) {
        return super.apagar(id, (Map) BancoDados.bancoPocao);
    }

    @Override
    public boolean carregar(int id) {
        Pocao p = (Pocao) super.carregar(id, (Map) BancoDados.bancoPocao);
        if (p != null) {
            this.nomePocao = p.nomePocao;
            this.componentes = p.componentes;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Poção [ID: " + getId() + " | Nome: " + nomePocao + " | Itens: " + componentes + "]";
    }

    public static List<Pocao> carregarTodos() {
        return new ArrayList<>(BancoDados.bancoPocao.values());
    }
}