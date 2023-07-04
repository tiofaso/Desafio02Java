import java.util.Scanner;
public class LeitorTeclado {//Funções de leitura de teclado
    private int valorDigitado;
    public int menuTecladoAdmin(){//Teclado do admin do sistema, com acesso global
        System.out.printf("Selecione abaixo uma opção:\n");
        System.out.println("1 - Cadastrar venda");
        System.out.println("2 - Cadastrar usuário");
        System.out.println("3 - Alterar venda");
        System.out.println("4 - Alterar usuário");
        System.out.println("5 - Mostrar todos usuários");
        System.out.println("8 - Mostrar todas as vendas");

        Scanner entrada = new Scanner(System.in);

        valorDigitado = entrada.nextInt();
        return valorDigitado;

    }

    public int menuTecladoVendedor(){//Teclado do vendedor, com acesso restrito
        System.out.printf("Selecione abaixo uma opção:\n");
        System.out.println("1 - Cadastrar venda");
        System.out.println("2 - Alterar venda");
        System.out.println("3 - Mostrar todas as suas vendas");
        System.out.println("4 - Mostrar todos os seus clientes");

        Scanner entrada = new Scanner(System.in);

        valorDigitado = entrada.nextInt();
        return valorDigitado;

    }

    public String menuSair(){
        System.out.println("\nDeseja sair do programa? [N - Não | S - Sim]");
        Scanner entrada = new Scanner(System.in);
        String sair = entrada.next();
        return sair;
    }

    public int menuErroAdmin(){
        System.out.println("> AVISO! - É preciso escolher uma opção!\n");
        System.out.println("1 - Cadastrar venda");
        System.out.println("2 - Cadastrar usuário");
        System.out.println("3 - Alterar venda");
        System.out.println("4 - Alterar usuário");
        System.out.println("5 - Mostrar todos usuários");
        System.out.println("8 - Mostrar todas as vendas");

        Scanner entrada = new Scanner(System.in);

        valorDigitado = entrada.nextInt();

        return valorDigitado;
    }

    public int menuErroVendedor(){
        System.out.println("> AVISO! - É preciso escolher uma opção!\n");
        System.out.println("1 - Cadastrar venda");
        System.out.println("2 - Alterar venda");
        System.out.println("3 - Mostrar todas as suas vendas");
        System.out.println("4 - Mostrar todos os seus clientes");

        Scanner entrada = new Scanner(System.in);

        valorDigitado = entrada.nextInt();

        return valorDigitado;
    }
}
