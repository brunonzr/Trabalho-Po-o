package modelo;

import java.util.ArrayList;
import java.util.List;

public class Caldeirao extends Entidade<Caldeirao> {
    private String nome;
    private boolean status;

    private Ingrediente ing1;
    private Ingrediente ing2;
    private Ingrediente base;

    public Caldeirao() {
        super();
        this.nome = "";
        this.status = false;
        this.ing1 = null;
        this.ing2 = null;
        this.base = null;
    }

    public Caldeirao(int id, String nome, boolean status, Ingrediente ing1, Ingrediente ing2, Ingrediente base) {
        super(id);
        this.nome = nome;
        this.status = status;
        this.ing1 = ing1;
        this.ing2 = ing2;
        this.base = base;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    public Ingrediente getIng1() { return ing1; }
    public void setIng1(Ingrediente ing1) { this.ing1 = ing1; }

    public Ingrediente getIng2() { return ing2; }
    public void setIng2(Ingrediente ing2) { this.ing2 = ing2; }

    public Ingrediente getBase() { return base; }
    public void setBase(Ingrediente base) { this.base = base; }

    @Override
    public String toString() {
        String estado = this.status ? "Em Uso" : "Livre";
        String n1 = (ing1 != null) ? ing1.getNome() : "Vazio";
        String n2 = (ing2 != null) ? ing2.getNome() : "Vazio";
        String b = (base != null) ? base.getNome() : "Vazio";

        return super.toString() + ", Nome: " + nome + ", Estado: " + estado +
                ", Ingredientes: [" + n1 + ", " + n2 + "] e Base: " + b;
    }

    public boolean salvar() {
        return super.salvar((Map) BancoDados.bancoCaldeirao);
    }

    public boolean atualizar() {
        return super.atualizar((Map) BancoDados.bancoCaldeirao);
    }

    public boolean apagar(int id) {
        return super.apagar(id, (Map) BancoDados.bancoCaldeirao);
    }

    public boolean carregar(int id) {
        Caldeirao dados = (Caldeirao) super.carregar(id, BancoDados.bancoCaldeirao);
        if (dados != null) {
            this.setId(dados.getId());
            this.nome = dados.nome;
            this.status = dados.status;
            this.ing1 = dados.ing1;
            this.ing2 = dados.ing2;
            this.base = dados.base;
            this.setPersistido(true);
            return true;
        }
        return false;
    }

    @Override
    public List<Caldeirao> carregarTodos() {
        return new ArrayList<>(BancoDados.bancoCaldeirao.values());
    }
}