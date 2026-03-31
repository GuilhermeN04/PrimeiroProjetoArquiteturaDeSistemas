import java.util.Scanner;

public class UsuarioControlador {
    private UsuarioServico service = new UsuarioServico();
    private Scanner sc = new Scanner(System.in);

    public void menu() {
        int op;

        do {
            System.out.println("\n1 - Criar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Deletar");
            System.out.println("0 - Sair");

            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.next();
                    System.out.print("Email: ");
                    String email = sc.next();
                    service.criarUsuario((int)(Math.random()*1000), nome, email);
                    break;

                case 2:
                    service.listarUsuarios();
                    break;

                case 3:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Novo nome: ");
                    String novoNome = sc.next();
                    service.atualizarUsuario(id, novoNome);
                    break;

                case 4:
                    System.out.print("ID: ");
                    int idDel = sc.nextInt();
                    service.deletarUsuario(idDel);
                    break;
            }
        } while (op != 0);
    }
}