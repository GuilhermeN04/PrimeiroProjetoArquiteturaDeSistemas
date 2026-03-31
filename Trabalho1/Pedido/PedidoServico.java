public class PedidoServico {
    private PedidoRepositorio repo = new PedidoRepositorio();
    private int contador = 1;

    public void criar(String descricao) {
        repo.salvar(new Pedido(contador++,descricao));
    }

    public void listar() {
        for(Pedido p : repo.listar()) {
            System.out.println(p.getId()+" - "+p.getDescricao());
        }
    }

    public void atualizar(int id,String desc) {
        Pedido p = repo.buscar(id);

        if(p!=null)
            p.setDescricao(desc);
    }

    public void deletar(int id) {
        repo.remover(id);
    }
}