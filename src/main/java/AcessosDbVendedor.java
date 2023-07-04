import java.sql.*;

public class AcessosDbVendedor extends Usuarios{//Classe com todos os acessos e manipulação da base de dados
    private String mysqlQuery;
    private String conexaoServidor = "jdbc:mysql://149.56.20.143:3306/marcamar_catalisa";
    private String conexaoUsuario = "marcamar_catalistico";
    private String conexaoSenha = "1248C4t4l1z4!";

    public AcessosDbVendedor() {}

    //Funções gerais
    public void adicionaCliente(String vendedor, String nomeCliente, String emailCliente, String cpfCliente){
        try {
            //Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
            Connection conexao = DriverManager.getConnection(conexaoServidor,conexaoUsuario,conexaoSenha);

            mysqlQuery = "INSERT INTO tb_cliente (usuario, email, cpf, nome ) " +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement statement = conexao.prepareStatement(mysqlQuery);
            statement.setString(1,vendedor);
            statement.setString(2,emailCliente);
            statement.setString(3,cpfCliente);
            statement.setString(4,nomeCliente);

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
    public void mostraClientes(){}

    //Funções de venda
    public void mostraMeusClientes(){}
    public void mostraMinhasVendas(){}

}
