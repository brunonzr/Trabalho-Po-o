package modelo;

import java.util.ArrayList;
import java.util.List;
import persistencia.BancoDados;

public class Caldeirao extends Entidade<Caldeirao> {

    private String nome;
    private boolean status;

    public Caldeirao() { super(); }

    public Caldeirao(int id, String nome, boolean status) {
        super(id);
        this.nome = nome;
        this.status = status;
    }

    public String getNome() { return nome; }
    public boolean isStatus() { return status; }

    @Override
    public boolean salvar() {
        return super.salvarNoBanco(BancoDados.bancoCaldeirao);
    }

    @Override
    public boolean atualizar() {
        return super.atualizarNoBanco(BancoDados.bancoCaldeirao);
    }

    @Override
    public boolean apagar(int id) {
        return super.apagarDoBanco(id, BancoDados.bancoCaldeirao);
    }

    @Override
    public boolean carregar(int id) {
        Caldeirao c = super.carregarDoBanco(id, BancoDados.bancoCaldeirao);
        if (c != null) {
            this.nome = c.nome;
            this.status = c.status;
            this.setId(c.getId());
            this.setPersistido(true);
            return true;
        }
        return false;
    }

    @Override
    public List<Caldeirao> carregarTodos() {
        return new ArrayList<>(BancoDados.bancoCaldeirao.values());
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " | Nome: " + nome + " | Status: " + status;
    }
}