import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositorio {
    private List<Produto> produtos = new ArrayList<>();

    public void salvar(Produto p) {
        produtos.add(p);
    }

    public List<Produto> listar() {
        return produtos;
    }

    public Produto buscar(int id) {
        for(Produto p : produtos) {
            if(p.getId() == id)
                return p;
        }
        return null;
    }

    public void remover(int id) {
        produtos.removeIf(p -> p.getId() == id);
    }
}