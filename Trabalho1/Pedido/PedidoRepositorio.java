import java.util.ArrayList;
import java.util.List;

public class PedidoRepositorio {
    private List<Pedido> pedidos = new ArrayList<>();

    public void salvar(Pedido p) {
        pedidos.add(p);
    }

    public List<Pedido> listar() {
        return pedidos;
    }

    public Pedido buscar(int id) {
        for(Pedido p : pedidos) {
            if(p.getId() == id)
                return p;
        }
        return null;
    }

    public void remover(int id) {
        pedidos.removeIf(p -> p.getId() == id);
    }
}