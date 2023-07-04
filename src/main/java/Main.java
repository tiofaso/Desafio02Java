public class Main {
    public static void main(String[] args) {
        System.out.println("+---------------------------+");
        System.out.println("| SISTEMA DE VENDA LOJA ZUP |");
        System.out.println("+---------------------------+");

        System.out.println("\nSeja bem-vinde!");

        //Login do sistema
        Login login = new Login();
        String teste = login.fazLogin();

        System.out.println(teste);
    }
}
