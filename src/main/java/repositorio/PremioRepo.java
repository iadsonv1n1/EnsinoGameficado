package repositorio;

import dominio.Aluno;
import dominio.Premio;

public class PremioRepo extends AbstractRepo<Premio>{

    private final static PremioRepo INSTANCE = new PremioRepo();

    public static PremioRepo getInstance() {
        return INSTANCE;
    }

    public Premio buscarPremioPorNome(String nome){
        return dados.stream().filter(c -> c.getNome().equalsIgnoreCase(nome)).findAny().get();
    }

}
