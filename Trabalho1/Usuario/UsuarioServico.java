public class UsuarioServico {
    private UsuarioRepositorio repo = new UsuarioRepositorio();

    public void criarUsuario(int id, String nome, String email) {
        Usuario u = new Usuario(id, nome, email);
        repo.salvar(u);
    }

    public void listarUsuarios() {
        for (Usuario u : repo.listar()) {
            System.out.println(u.getId() + " - " + u.getNome());
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
}