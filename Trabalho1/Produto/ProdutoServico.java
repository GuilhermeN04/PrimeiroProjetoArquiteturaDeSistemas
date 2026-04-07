public class ProdutoServico {
    private ProdutoRepositorio repo;
    private int contador = 1;

    public ProdutoServico(ProdutoRepositorio repo) {
        this.repo = repo;
    }

    public void criar(String nome, double preco) {
        Produto p = new Produto(contador++, nome, preco);
        repo.salvar(p);
    }

    public void listar() {
        for(Produto p : repo.listar()) {
            System.out.println(p.getId()+" - "+p.getNome()+" - "+p.getPreco());
        }
    }

    public void atualizar(int id, String nome) {
        Produto p = repo.buscar(id);
        if(p != null)
            p.setNome(nome);
    }

    public void deletar(int id) {
        repo.remover(id);
    }
}