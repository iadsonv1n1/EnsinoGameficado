package repositorio;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepo<T> implements Repositorio<T> {

    protected List<T> dados = new ArrayList<>();

    @Override
    public void salvar(T entidade) {
        if (dados.contains(entidade)) {
            System.err.println("Objeto Já Existe Na Lista");
            return;
        }
        dados.add(entidade);
    }

    @Override
    public List<T> buscarTodos() {
        return dados.stream().toList();
    }

}

