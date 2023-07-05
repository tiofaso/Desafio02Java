package TestandoRecursos;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class TesteHash {//Classe para testar criação de hash usando java.security
    public static void main(String[] args) {
        String senhaPlana = "123456hanoi";
        String saltoAutomatico;
        String senhaHashSalto;

        //Gerando salto
        saltoAutomatico = BCrypt.gensalt();

        //Encriptando senha
        senhaHashSalto = BCrypt.hashpw(senhaPlana, saltoAutomatico);
        Boolean teste = BCrypt.checkpw(senhaPlana, senhaHashSalto);

        if(BCrypt.checkpw(senhaPlana, senhaHashSalto) == true) {
            System.out.println("Senha: " + senhaPlana);
            System.out.println("Salto: " + saltoAutomatico);
            System.out.println("Salto + Hash: " + senhaHashSalto);
        }else{
            System.out.println("Login inválido");
        }
    }

}
