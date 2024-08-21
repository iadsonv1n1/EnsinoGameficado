package repositorio;

import dominio.Professor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class AbstractRepo<T> implements Repositorio<T> {

    protected List<T> data = new ArrayList<>();

    @Override
    public void salvar(T entidade) {
        data.add(entidade);
    }

    @Override
    public List<T> buscarTodos() {
        return data.stream().toList();
    }


}

