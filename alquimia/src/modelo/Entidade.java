package modelo;

import java.util.List;
import java.util.Map;

public abstract class Entidade<T> {
    private int id;
    private boolean persistido;

    public Entidade() {
        this.id = 0;
        this.persistido = false;
    }

    public Entidade(int id) {
        if (id < 0) throw new IllegalArgumentException("ID nÃ£o pode ser negativo");
        this.id = id;
        this.persistido = false;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public boolean isPersistido() { return persistido; }
    public void setPersistido(boolean persistido) { this.persistido = persistido; }

    @Override
    public String toString() {
        return "ID: " + id + ", Persistido: " + persistido;
    }

    public boolean salvar(Map<Integer, ? super Entidade> banco) {
        if (!this.persistido && !banco.containsKey(this.id)) {
            banco.put(this.id, this);
            this.persistido = true;
            return true;
        }
        return false;
    }

    public boolean atualizar(Map<Integer, ? super Entidade> banco) {
        if (this.persistido && banco.containsKey(this.id)) {
            banco.put(this.id, this);
            return true;
        }
        return false;
    }

    public boolean apagar(int id, Map<Integer, ? super Entidade> banco) {
        if (banco.containsKey(id)) {
            ((Entidade) banco.get(id)).setPersistido(false);
            banco.remove(id);
            return true;
        }
        return false;
    }

    public Entidade carregar(int id, Map<Integer, ? extends Entidade> banco) {
        if (banco.containsKey(id)) {
            return banco.get(id);
        }
        return null;
    }

    public abstract List<T> carregarTodos();
}