import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AcessosDbAdmin extends Usuarios{//Classe com todos os acessos e manipulação da base de dados
    private String mysqlQuery;
    private String conexaoServidor = "jdbc:mysql://149.56.20.143:3306/marcamar_catalisa";
    private String conexaoUsuario = "marcamar_catalistico";
    private String conexaoSenha = "1248C4t4l1z4!";

    public AcessosDbAdmin() {}

    //Funções gerais


    //Funções de administração
    public void adicionaVendedorDb(String nome, String email, String cpf){
        try {
            //Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
            Connection conexao = DriverManager.getConnection(conexaoServidor,conexaoUsuario,conexaoSenha);

            String usuario = email;

            mysqlQuery = "INSERT INTO tb_vendedor (usuario, email, cpf, nome) " +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement statement = conexao.prepareStatement(mysqlQuery);
            statement.setString(1,usuario);
            statement.setString(2,email);
            statement.setString(3,cpf);
            statement.setString(4,nome);


            statement.execute();

            conexao.close();

            System.out.println("Vendedor adicionado com sucesso!");


        } catch (Exception e) {
            System.err.println("Deu ruim...");
            // printStackTrace method
            // prints line numbers + call stack
            e.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(e);
        }

    }
    public void mostraUsuarios(){}
    public void mostraVendedores() {
        try {
            //Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
            Connection conexao = DriverManager.getConnection(conexaoServidor,conexaoUsuario,conexaoSenha);

            mysqlQuery = "SELECT usuario, email, cpf, nome " +
                    "FROM tb_vendedor";

            PreparedStatement statement = conexao.prepareStatement(mysqlQuery);

            ResultSet lista = statement.executeQuery();

            while (lista.next()) {
                System.out.println("Nome: " + lista.getString("nome"));
                System.out.println("e-mail: " + lista.getString("email"));
                System.out.println("CPF: " + lista.getString("cpf"));
                System.out.println("--");
            }

            conexao.close();

        } catch (Exception e) {
            System.err.println("Deu ruim...");
            // printStackTrace method
            // prints line numbers + call stack
            e.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(e);
        }

    }
    public void adicionaCliente(String vendedor, String nomeCliente, String emailCliente, String cpfCliente){
        try {
            //Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
            Connection conexao = DriverManager.getConnection(conexaoServidor,conexaoUsuario,conexaoSenha);

            mysqlQuery = "INSERT INTO tb_cliente (usuario, nome, email, cpf ) " +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement statement = conexao.prepareStatement(mysqlQuery);
            statement.setString(1,vendedor);
            statement.setString(2,nomeCliente);
            statement.setString(3,emailCliente);
            statement.setString(4,cpfCliente);


            statement.execute();

            conexao.close();

            System.out.println("Cliente adicionado com sucesso!");


        } catch (Exception e) {
            System.err.println("Deu ruim...");
            // printStackTrace method
            // prints line numbers + call stack
            e.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(e);
        }
    }
    public void mostraClientes(){
        try {
            //Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
            Connection conexao = DriverManager.getConnection(conexaoServidor,conexaoUsuario,conexaoSenha);

            mysqlQuery = "SELECT usuario, email, cpf, nome " +
                    "FROM tb_cliente";

            PreparedStatement statement = conexao.prepareStatement(mysqlQuery);

            ResultSet lista = statement.executeQuery();

            while (lista.next()) {
                System.out.println("Nome: " + lista.getString("nome"));
                System.out.println("e-mail: " + lista.getString("email"));
                System.out.println("CPF: " + lista.getString("cpf"));
                System.out.println("Atendido por: " + lista.getString("usuario"));
                System.out.println("--");
            }

            conexao.close();

        } catch (Exception e) {
            System.err.println("Deu ruim...");
            // printStackTrace method
            // prints line numbers + call stack
            e.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(e);
        }
    }

    public void mostraVendas(){
        try {
            //Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
            Connection conexao = DriverManager.getConnection(conexaoServidor,conexaoUsuario,conexaoSenha);

            mysqlQuery = "SELECT usuario, nome, email, cliente, vendedor, data, hora " +
                    "FROM tb_cliente INNER JOIN tb_registrovenda " +
                    "WHERE tb_registrovenda.cliente = tb_cliente.cpf " +
                    "ORDER BY data, hora";

            PreparedStatement statement = conexao.prepareStatement(mysqlQuery);

            ResultSet lista = statement.executeQuery();

            while (lista.next()) {
                System.out.println("Nome: " + lista.getString("tb_cliente.nome"));
                System.out.println("e-mail: " + lista.getString("tb_cliente.email"));
                System.out.println("CPF: " + lista.getString("tb_registrovenda.cliente"));
                System.out.println("Atendido por: " + lista.getString("tb_cliente.usuario"));
                System.out.println("Data: " + lista.getDate("tb_registrovenda.data"));
                System.out.println("Hora: " + lista.getTime("tb_registrovenda.hora"));
                System.out.println("--");
            }

            conexao.close();

        } catch (Exception e) {
            System.err.println("Deu ruim...");
            // printStackTrace method
            // prints line numbers + call stack
            e.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(e);
        }
    }


    public void mostraVendasVendedor(String email){
        try {
            //Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
            Connection conexao = DriverManager.getConnection(conexaoServidor,conexaoUsuario,conexaoSenha);

            mysqlQuery = "SELECT usuario, nome, email, cliente, vendedor, data, hora " +
                    "FROM tb_cliente INNER JOIN tb_registrovenda " +
                    "WHERE tb_registrovenda.cliente = tb_cliente.cpf " +
                    "AND tb_registrovenda.vendedor = '" + email + "' " +
                    "ORDER BY data, hora";

            PreparedStatement statement = conexao.prepareStatement(mysqlQuery);

            ResultSet lista = statement.executeQuery();
            if(lista.next() == true){
                while (lista.next()) {
                    System.out.println("Nome: " + lista.getString("tb_cliente.nome"));
                    System.out.println("e-mail: " + lista.getString("tb_cliente.email"));
                    System.out.println("CPF: " + lista.getString("tb_registrovenda.cliente"));
                    System.out.println("Atendido por: " + lista.getString("tb_cliente.usuario"));
                    System.out.println("Data: " + lista.getDate("tb_registrovenda.data"));
                    System.out.println("Hora: " + lista.getTime("tb_registrovenda.hora"));
                    System.out.println("--");
                }
            }else {
                System.out.println("- vendedor não localizado -");
            }


            conexao.close();

        } catch (Exception e) {
            System.err.println("Deu ruim...");
            // printStackTrace method
            // prints line numbers + call stack
            e.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(e);
        }
    }

    public void criaSenha(String email, String senha){
        try {
            //Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
            Connection conexao = DriverManager.getConnection(conexaoServidor,conexaoUsuario,conexaoSenha);

            mysqlQuery = "INSERT INTO tb_login (usuario, senha, nivel ) " +
                    "VALUES (?, ?, ?)";

            PreparedStatement statement = conexao.prepareStatement(mysqlQuery);
            statement.setString(1,email);
            statement.setString(2,senha);
            statement.setInt(3,1);

            statement.execute();

            conexao.close();

            System.out.println("Senha criada com sucesso!");


        } catch (Exception e) {
            System.err.println("Deu ruim...");
            // printStackTrace method
            // prints line numbers + call stack
            e.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(e);
        }
    }
}
