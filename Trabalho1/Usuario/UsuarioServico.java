public class UsuarioServico {
    private UsuarioRepositorio repo;

    public UsuarioServico(UsuarioRepositorio repo) {
        this.repo = repo;
    }

    public void criarUsuario(int id, String nome, String email) {
        Usuario u = new Usuario(id, nome, email);
        repo.salvar(u);
    }

    public void listarUsuarios() {
        for (Usuario u : repo.listar()) {
            System.out.println(u.getId() + " - " + u.getNome() + " - " + u.getEmail());
        }
    }

    public void atualizarUsuario(int id, String nome) {
        Usuario u = repo.buscarPorId(id);
        if (u != null) {
            u.setNome(nome);
        }
    }

    public void deletarUsuario(int id) {
        repo.remover(id);
    }

    public Usuario buscarPorId(int id) {
        return repo.buscarPorId(id);
    }
}