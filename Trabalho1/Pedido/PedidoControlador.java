import java.util.Scanner;

public class PedidoControlador {
    private PedidoServico service = new PedidoServico();
    private Scanner sc = new Scanner(System.in);

    public void menu() {
        int op;

        do{
            System.out.println("\n--- PEDIDO ---");
            System.out.println("1 Criar");
            System.out.println("2 Listar");
            System.out.println("3 Atualizar");
            System.out.println("4 Deletar");
            System.out.println("0 Voltar");

            op = sc.nextInt();

            switch(op) {
                case 1:
                    System.out.print("Descricao: ");
                    String desc = sc.next();

                    service.criar(desc);
                break;

                case 2:
                    service.listar();
                break;

                case 3:
                    System.out.print("ID: ");
                    int id = sc.nextInt();

                    System.out.print("Nova desc: ");
                    String nova = sc.next();

                    service.atualizar(id,nova);
                break;

                case 4:
                    System.out.print("ID: ");
                    int del = sc.nextInt();

                    service.deletar(del);
                break;
            }

        }while(op!=0);
    }
}
