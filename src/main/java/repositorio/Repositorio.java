package repositorio;

import java.util.List;

public interface Repositorio<T> {
    void salvar(T entidade);

    List<T> buscarTodos();
}
