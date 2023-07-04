import java.util.Scanner;

public class Login {
    String usuario;
    String senha;

    public String fazLogin() {//Realiza o login no sistema
        System.out.println("Por favor digite o seu usuário:");
        Scanner entrada = new Scanner(System.in);

        int correto = 0; //flag para colocar o usuário em looping até digitar e-mail corretamente

        while (correto == 0) {
            usuario = entrada.nextLine();

            Validacoes validaEmail = new Validacoes();

            if (validaEmail.verificaEmail(usuario) == false) {
                System.out.println("Digite um e-mail em formato válido (ex: usuario@site.com.br)");
            } else {
                correto = 1;
            }//end if
        }//end while

        System.out.println("Digite a sua senha:");

        correto = 0; //Zerando a flag para entrar no looping para evitar senha em branco

        while (correto == 0) {
            senha = entrada.nextLine();

            if (senha.isBlank()) {
                System.out.println("É preciso digitar uma senha");
            } else {
                correto = 1;
            }
        }//end while

        //Verificando dados digitados na base
        Validacoes validaLogin = new Validacoes();
        return validaLogin.checkLoginDb(usuario,senha);
    }//end fazLogin


}//end login