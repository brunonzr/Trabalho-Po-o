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
        this.id = id;
        this.persistido = false;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public boolean isPersistido() { return persistido; }
    public void setPersistido(boolean persistido) { this.persistido = persistido; }

    @Override
    public String toString() {
        return "ID: " + id + " | Persistido: " + persistido;
    }

    @SuppressWarnings("unchecked")
    protected boolean salvarNoBanco(Map<Integer, T> banco) {
        if (!persistido && !banco.containsKey(id)) {
            banco.put(id, (T) this);
            persistido = true;
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    protected boolean atualizarNoBanco(Map<Integer, T> banco) {
        if (persistido && banco.containsKey(id)) {
            banco.put(id, (T) this);
            return true;
        }
        return false;
    }

    protected boolean apagarDoBanco(int id, Map<Integer, T> banco) {
        if (banco.containsKey(id)) {
            T obj = banco.get(id);
            if (obj instanceof Entidade<?> e) {
                e.setPersistido(false);
            }
            banco.remove(id);
            return true;
        }
        return false;
    }

    protected T carregarDoBanco(int id, Map<Integer, T> banco) {
        return banco.get(id);
    }

    public abstract boolean salvar();
    public abstract boolean atualizar();
    public abstract boolean apagar(int id);
    public abstract boolean carregar(int id);
    public abstract List<T> carregarTodos();
}