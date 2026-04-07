import java.util.List;

public class PedidoServico {
    private PedidoRepositorio repo;
    private UsuarioRepositorio usuarioRepo;
    private ProdutoRepositorio produtoRepo;
    private int contador = 1;

    public PedidoServico(PedidoRepositorio repo, UsuarioRepositorio usuarioRepo, ProdutoRepositorio produtoRepo) {
        this.repo = repo;
        this.usuarioRepo = usuarioRepo;
        this.produtoRepo = produtoRepo;
    }

    public void criar(String descricao, int usuarioId) {
        Usuario usuario = usuarioRepo.buscarPorId(usuarioId);
        if (usuario == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }
        Pedido pedido = new Pedido(contador++, descricao, usuario);
        repo.salvar(pedido);
        System.out.println("✅ Pedido criado com sucesso! ID: " + (contador-1));
    }

    public void adicionarItemAoPedido(int pedidoId, int produtoId, int quantidade) {
        Pedido pedido = repo.buscar(pedidoId);
        if (pedido == null) {
            System.out.println("Pedido não encontrado!");
            return;
        }
        Produto produto = produtoRepo.buscar(produtoId);
        if (produto == null) {
            System.out.println("Produto não encontrado!");
            return;
        }
        pedido.adicionarItem(produto, quantidade);
        System.out.println("Item adicionado ao pedido!");
    }

    public void listar() {
        List<Pedido> pedidos = repo.listar();
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }
        for(Pedido p : pedidos) {
            System.out.println("\nPedido " + p.getId() + " - " + p.getDescricao());
            System.out.println("Cliente: " + p.getUsuario().getNome());
            System.out.println("Itens:");
            for(ItemPedido item : p.getItens()) {
                System.out.println("   " + item);
            }
            System.out.println("Total: R$ " + String.format("%.2f", p.getValorTotal()));
        }
    }

    public void atualizar(int id, String novaDescricao) {
        Pedido p = repo.buscar(id);
        if(p != null) p.setDescricao(novaDescricao);
    }

    public void deletar(int id) {
        repo.remover(id);
    }
}