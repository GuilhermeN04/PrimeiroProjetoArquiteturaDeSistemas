import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UsuarioControlador usuario = new UsuarioControlador();
        ProdutoControlador produto = new ProdutoControlador();
        PedidoControlador pedido = new PedidoControlador();

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

        }while(op!=0);

        sc.close();
    }
}