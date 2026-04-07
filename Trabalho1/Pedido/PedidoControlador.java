import java.util.Scanner;

public class PedidoControlador {
    private PedidoServico service;
    private Scanner sc = new Scanner(System.in);

    public PedidoControlador(PedidoServico service) {
        this.service = service;
    }

    public void menu() {
        int op;

        do {
            System.out.println("\n--- PEDIDO ---");
            System.out.println("1 Criar novo pedido");
            System.out.println("2 Adicionar item ao pedido");
            System.out.println("3 Listar pedidos");
            System.out.println("4 Atualizar descrição");
            System.out.println("5 Deletar pedido");
            System.out.println("0 Voltar");

            op = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch(op) {
                case 1:
                    System.out.print("Descrição do pedido: ");
                    String desc = sc.nextLine();
                    System.out.print("ID do Usuário: ");
                    int idUsuario = sc.nextInt();
                    service.criar(desc, idUsuario);
                    break;

                case 2:
                    System.out.print("ID do Pedido: ");
                    int idPedido = sc.nextInt();
                    System.out.print("ID do Produto: ");
                    int idProduto = sc.nextInt();
                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();
                    service.adicionarItemAoPedido(idPedido, idProduto, qtd);
                    break;

                case 3:
                    service.listar();
                    break;

                case 4:
                    System.out.print("ID do pedido: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nova descrição: ");
                    String nova = sc.nextLine();
                    service.atualizar(id, nova);
                    break;

                case 5:
                    System.out.print("ID do pedido: ");
                    int del = sc.nextInt();
                    service.deletar(del);
                    break;
            }

        } while(op != 0);
    }
}