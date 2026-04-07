import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private String descricao;
    private Usuario usuario;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(int id, String descricao, Usuario usuario) {
        this.id = id;
        this.descricao = descricao;
        this.usuario = usuario;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        itens.add(new ItemPedido(produto, quantidade));
    }

    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public Usuario getUsuario() { return usuario; }
    public List<ItemPedido> getItens() { return itens; }

    public double getValorTotal() {
        return itens.stream().mapToDouble(ItemPedido::getSubtotal).sum();
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}