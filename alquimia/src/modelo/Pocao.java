package modelo;

import java.util.ArrayList;
import java.util.List;
import persistencia.BancoDados;

public class Pocao extends Entidade<Pocao> {

    private String nomePocao;
    private List<Componente> componentes;
    private Caldeirao caldeirao;

    public Pocao(int id, String nomePocao, Caldeirao caldeirao) {
        super(id);
        this.nomePocao = nomePocao;
        this.caldeirao = caldeirao;
        this.componentes = new ArrayList<>();
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void adicionarComponente(Ingrediente ing, int qtd) {
        componentes.add(new Componente(ing, qtd));
    }

    public void removerComponente(int index) {
        if (index >= 0 && index < componentes.size())
            componentes.remove(index);
    }

    public String getNome() {
        return nomePocao;
    }

    public void setNome(String nome) {
        this.nomePocao = nome;
    }

    @Override
    public boolean salvar() {
        if (caldeirao == null || !caldeirao.isStatus()) {
            System.out.println("Caldeirão inválido ou inativo!");
            return false;
        }
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
        Pocao p = super.carregarDoBanco(id, BancoDados.bancoPocao);
        if (p != null) {
            this.nomePocao = p.nomePocao;
            this.componentes = p.componentes;
            this.caldeirao = p.caldeirao;
            this.setId(p.getId());
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
        String nomeCaldeirao = (caldeirao != null) ? caldeirao.getNome() : "Nenhum";

        return "Poção [ID: " + getId() +
               " | Nome: " + nomePocao +
               " | Caldeirão: " + nomeCaldeirao +
               " | Itens: " + componentes + "]";
    }
}