import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class AcessosDbVendedor extends Usuarios {//Classe com todos os acessos e manipulação da base de dados
    private String mysqlQuery;
    private String conexaoServidor = "jdbc:mysql://149.56.20.143:3306/marcamar_catalisa";
    private String conexaoUsuario = "marcamar_catalistico";
    private String conexaoSenha = "1248C4t4l1z4!";

    public AcessosDbVendedor() {
    }

    //Funções gerais
    public void adicionaCliente(String vendedor, String nomeCliente, String emailCliente, String cpfCliente) {
        try {
            //Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
            Connection conexao = DriverManager.getConnection(conexaoServidor, conexaoUsuario, conexaoSenha);

            mysqlQuery = "INSERT INTO tb_cliente (usuario, email, cpf, nome ) " +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement statement = conexao.prepareStatement(mysqlQuery);
            statement.setString(1, vendedor);
            statement.setString(2, emailCliente);
            statement.setString(3, cpfCliente);
            statement.setString(4, nomeCliente);

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

    //Funções de venda
    public void mostraMeusClientes(String loginVendedor) {
        try {
            //Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
            Connection conexao = DriverManager.getConnection(conexaoServidor, conexaoUsuario, conexaoSenha);

            mysqlQuery = "SELECT usuario, email, cpf, nome " +
                    "FROM tb_cliente WHERE usuario = '" + loginVendedor + "'" +
                    " ORDER BY nome";

            PreparedStatement statement = conexao.prepareStatement(mysqlQuery);

            ResultSet lista = statement.executeQuery();

            if (lista.next() == true) {
                while (lista.next()) {
                    System.out.println("Nome: " + lista.getString("nome"));
                    System.out.println("e-mail: " + lista.getString("email"));
                    System.out.println("CPF: " + lista.getString("cpf"));
                    System.out.println("--");
                }
            } else {
                System.out.println("- sem itens para exibir -");
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

    public void mostraMinhasVendas(String loginVendedor) {
        try {
            //Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
            Connection conexao = DriverManager.getConnection(conexaoServidor, conexaoUsuario, conexaoSenha);

            mysqlQuery = "SELECT vendedor, cliente, valor, email, data, hora, nome, cpf " +
                    "FROM tb_registrovenda INNER JOIN tb_cliente " +
                    "ON tb_registrovenda.vendedor =  tb_cliente.usuario " +
                    "AND tb_registrovenda.vendedor = '" + loginVendedor + "'" +
                    " AND tb_registrovenda.cliente = tb_cliente.cpf " +
                    " ORDER BY data, hora";

            PreparedStatement statement = conexao.prepareStatement(mysqlQuery);

            ResultSet lista = statement.executeQuery();

            if (lista.next() == true) {
                while (lista.next()) {
                    System.out.println("Nome: " + lista.getString("tb_cliente.nome"));
                    System.out.println("e-mail: " + lista.getString("tb_cliente.email"));
                    System.out.println("CPF: " + lista.getString("tb_cliente.cpf"));
                    System.out.println("Venda: R$" + lista.getString("tb_registrovenda.valor"));
                    System.out.println("Data: " + lista.getString("tb_registrovenda.data"));
                    System.out.println("Hora: " + lista.getString("tb_registrovenda.hora"));
                    System.out.println("--");
                }

            } else {
                System.out.println("- sem itens para exibir -");
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

    public void adicionarVenda(String loginVendedor, String cpfCliente, double valorVenda) {
        try {
            //Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
            Connection conexao = DriverManager.getConnection(conexaoServidor, conexaoUsuario, conexaoSenha);

            mysqlQuery = "INSERT INTO tb_registrovenda (vendedor, cliente, valor, data, hora) " +
                    "VALUES (?, ?, ?, ?, ?)";

            Date data = Date.valueOf(LocalDate.now());
            Time hora = Time.valueOf(LocalTime.now());
            PreparedStatement statement = conexao.prepareStatement(mysqlQuery);
            statement.setString(1, loginVendedor);
            statement.setString(2, cpfCliente);
            statement.setDouble(3, valorVenda);
            statement.setDate(4, data);
            statement.setTime(5, hora);

            statement.execute();

            conexao.close();

            System.out.println("Venda adicionada com sucesso!");


        } catch (Exception e) {
            System.err.println("Deu ruim...");
            // printStackTrace method
            // prints line numbers + call stack
            e.printStackTrace();
            // Prints what exception has been thrown
            System.out.println(e);
        }

    }

    public void pesquisaVendasCpf(String cpf) {
        try {
            //Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
            Connection conexao = DriverManager.getConnection(conexaoServidor, conexaoUsuario, conexaoSenha);

            mysqlQuery = "SELECT vendedor, cliente, valor, email, data, hora, nome, cpf " +
                    "FROM tb_registrovenda INNER JOIN tb_cliente " +
                    "ON tb_registrovenda.cliente =  tb_cliente.cpf " +
                    " AND tb_registrovenda.cliente = '" + cpf + "'" +
                    " ORDER BY data, hora";

            PreparedStatement statement = conexao.prepareStatement(mysqlQuery);

            ResultSet lista = statement.executeQuery();
            if (lista.next() == true) {
                while (lista.next()) {
                    System.out.println("Nome: " + lista.getString("tb_cliente.nome"));
                    System.out.println("e-mail: " + lista.getString("tb_cliente.email"));
                    System.out.println("CPF: " + lista.getString("tb_cliente.cpf"));
                    System.out.println("Venda: R$" + lista.getString("tb_registrovenda.valor"));
                    System.out.println("Data: " + lista.getString("tb_registrovenda.data"));
                    System.out.println("Hora: " + lista.getString("tb_registrovenda.hora"));
                    System.out.println("--");
                }
            } else {
                System.out.println("- sem itens para exibir -");
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
}
