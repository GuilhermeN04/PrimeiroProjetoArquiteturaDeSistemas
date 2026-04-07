import java.util.Scanner;

public class ProdutoControlador {
    private ProdutoServico service;
    private Scanner sc = new Scanner(System.in);

    public ProdutoControlador(ProdutoServico service) {
        this.service = service;
    }

    public void menu() {
        int op;

        do{
            System.out.println("\n--- PRODUTO ---");
            System.out.println("1 Criar");
            System.out.println("2 Listar");
            System.out.println("3 Atualizar");
            System.out.println("4 Deletar");
            System.out.println("0 Voltar");

            op = sc.nextInt();

            switch(op) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.next();

                    System.out.print("Preco: ");
                    double preco = sc.nextDouble();

                    service.criar(nome,preco);
                    break;

                case 2:
                    service.listar();
                    break;

                case 3:
                    System.out.print("ID: ");
                    int id = sc.nextInt();

                    System.out.print("Novo nome: ");
                    String novo = sc.next();

                    service.atualizar(id,novo);
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