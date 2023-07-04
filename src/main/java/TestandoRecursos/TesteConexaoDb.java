package TestandoRecursos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexaoDb {//Classe para testar se conexão remota com db funciona
    public static void main(String[] args) {
        try {
            //Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
            Connection conexao = DriverManager.getConnection("jdbc:mysql://149.56.20.143:3306/marcamar_catalisa",
                                       "marcamar_catalistico","1248C4t4l1z4!");
            System.out.println("Funcionou!");
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
