import org.springframework.security.crypto.bcrypt.BCrypt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacoes {
    private String padraoEmail;
    private static Pattern padrao;
    private String mysqlQuery;
    private String conexaoServidor = "jdbc:mysql://149.56.20.143:3306/marcamar_catalisa";
    private String conexaoUsuario = "marcamar_catalistico";
    private String conexaoSenha = "1248C4t4l1z4!";
    private String resultado;
    public Boolean verificaEmail(String usuario) {//verifica se o usuário digitou um e-mail válido
        padraoEmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        padrao = Pattern.compile(padraoEmail, Pattern.CASE_INSENSITIVE);

        Matcher deuMatch = padrao.matcher(usuario);

        return deuMatch.matches();
    }

    public String checkLoginDb(String usuario, String senha) {//Verifica se usuário estrá na base de dados
        try {
            //Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
            Connection conexao = DriverManager.getConnection(conexaoServidor, conexaoUsuario, conexaoSenha);

            mysqlQuery = "SELECT usuario, senha, nivel FROM tb_login WHERE usuario = '" + usuario + "'";

            PreparedStatement statement = conexao.prepareStatement(mysqlQuery);

            ResultSet lista = statement.executeQuery();

            if (lista.next() == true) {
                String senhaBase = lista.getString("senha");
                if(verificaHash(senha, senhaBase) == true){resultado = lista.getString("nivel");}
                else{resultado = "null";}
            }
            else{
                resultado = "null";
            }

            conexao.close();

        } catch (Exception e) {
            System.err.println("! Deu ruim...");
            // printStackTrace method
            // prints line numbers + call stack
            e.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(e);
        }
        return resultado;
    }//end checkLoginDb

    public Boolean verificaHash(String senha, String senhaBase){//Conversor de hash para senha
        //Verificando senha
        Boolean teste = BCrypt.checkpw(senha, senhaBase);

        return teste;
    }//end montaHash

    public Boolean verificaEmailDb(String email, int area){//Verifica se o cpf já existe na base
        Boolean resultadoEmail = null;

        try {
            //Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
            Connection conexao = DriverManager.getConnection(conexaoServidor, conexaoUsuario, conexaoSenha);

            if(area == 0) {//Pesquisa base de vendedores
                mysqlQuery = "SELECT email FROM tb_vendedor WHERE email = '" + email + "'";
            }else if (area == 1){//Pesquisa base de clientes
                mysqlQuery = "SELECT email FROM tb_cliente WHERE email = '" + email + "'";
            }

            PreparedStatement statement = conexao.prepareStatement(mysqlQuery);

            ResultSet lista = statement.executeQuery();

            if (lista.next() == true) {
                resultadoEmail = true;

            }
            else{
                resultadoEmail = false;
            }

            conexao.close();

        } catch (Exception e) {
            System.err.println("! Deu ruim...");
            // printStackTrace method
            // prints line numbers + call stack
            e.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(e);
        }
        return resultadoEmail;
    }//end verificaCpfRepetido

    public Boolean verificaCpfDb(String cpf, int area){//Verifica se o cpf já existe na base
        Boolean resultadoCpf = null;

        try {
            //Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
            Connection conexao = DriverManager.getConnection(conexaoServidor, conexaoUsuario, conexaoSenha);

            if(area == 0) {//Pesquisa base de vendedores
                mysqlQuery = "SELECT cpf FROM tb_vendedor WHERE cpf = '" + cpf + "'";
            }else if (area == 1){//Pesquisa base de clientes
                mysqlQuery = "SELECT email FROM tb_cliente WHERE cpf = '" + cpf + "'";
            }

            PreparedStatement statement = conexao.prepareStatement(mysqlQuery);

            ResultSet lista = statement.executeQuery();

            if (lista.next() == true) {
                resultadoCpf = true;

            }
            else{
                resultadoCpf = false;
            }

            conexao.close();

        } catch (Exception e) {
            System.err.println("! Deu ruim...");
            // printStackTrace method
            // prints line numbers + call stack
            e.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(e);
        }
        return resultadoCpf;
    }//end verificaCpfRepetido

    public Boolean verificaCpfDbVendedor(String cpf, String login){//Verifica se o cpf já existe na base
        Boolean resultadoCpf = null;

        try {
            //Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
            Connection conexao = DriverManager.getConnection(conexaoServidor, conexaoUsuario, conexaoSenha);

            mysqlQuery = "SELECT email FROM tb_cliente WHERE cpf = '" + cpf + "' AND usuario = '" + login +"'";

            PreparedStatement statement = conexao.prepareStatement(mysqlQuery);

            ResultSet lista = statement.executeQuery();

            if (lista.next() == true) {
                resultadoCpf = true;

            }
            else{
                resultadoCpf = false;
            }

            conexao.close();

        } catch (Exception e) {
            System.err.println("! Deu ruim...");
            // printStackTrace method
            // prints line numbers + call stack
            e.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(e);
        }
        return resultadoCpf;
    }//end verificaCpfRepetido
}
