import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UsuarioRepositorio usuarioRepo = new UsuarioRepositorio();
        ProdutoRepositorio produtoRepo = new ProdutoRepositorio();
        PedidoRepositorio pedidoRepo = new PedidoRepositorio();

        UsuarioServico usuarioService = new UsuarioServico(usuarioRepo);
        ProdutoServico produtoService = new ProdutoServico(produtoRepo);
        PedidoServico pedidoService = new PedidoServico(pedidoRepo, usuarioRepo, produtoRepo);

        UsuarioControlador usuario = new UsuarioControlador(usuarioService);
        ProdutoControlador produto = new ProdutoControlador(produtoService);
        PedidoControlador pedido = new PedidoControlador(pedidoService);

        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n===== SISTEMA =====");
            System.out.println("1 Usuarios");
            System.out.println("2 Produtos");
            System.out.println("3 Pedidos");
            System.out.println("0 Sair");

            op = sc.nextInt();

            switch(op) {
                case 1:
                    usuario.menu();
                    break;
                case 2:
                    produto.menu();
                    break;
                case 3:
                    pedido.menu();
                    break;
            }

        } while(op != 0);

        sc.close();
    }
}