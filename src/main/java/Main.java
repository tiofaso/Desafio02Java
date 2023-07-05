import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("+---------------------------+");
        System.out.println("| SISTEMA DE VENDA LOJA ZUP |");
        System.out.println("+---------------------------+");

        System.out.println("\nSeja bem-vinde!");

        //Login do sistema
        Login login = new Login();
        String area = login.fazLogin(); //Retorna o tipo de acesso que o usuário tem

        if(area.equals("null")) {
            System.out.println("Usuário ou senha inválidos");
        }
        else {//Begin sistema
            String sair = "n"; //Flag do looping para sair do sisterma

            while (sair.equals("n") || sair.equals("N")) {//Looping para manter o usuário dentro do sistema
                switch (area) {
                    case "0": //Administrador
                        System.out.println("> ADMINISTRADOR");
                        LeitorTeclado admin = new LeitorTeclado();
                        int opcaoAdmin = admin.menuTecladoAdmin();

                        AdminSudo adm = new AdminSudo();

                        switch (opcaoAdmin) {
                            case 1: //Cadastrar vendedor
                                System.out.println(">> CADASTRAR VENDEDORES");

                                Scanner cadastraVendedor = new Scanner(System.in);

                                System.out.println("Digite o nome do vendedor:");
                                String nomeVendedor = cadastraVendedor.nextLine();

                                System.out.println("Digite o e-mail do vendedor:");
                                String emailVendedor = cadastraVendedor.nextLine();

                                //Verificando e-mail
                                Validacoes emailValida = new Validacoes();
                                while (emailValida.verificaEmail(emailVendedor) == false) {
                                    System.out.println("Digite um e-mail VÁLIDO do vendedor:");
                                    emailVendedor = cadastraVendedor.nextLine();
                                }

                                //Verificando se e-mail existe
                                if(emailValida.verificaEmailDb(emailVendedor,0) == false) {
                                    System.out.println("Digite o CPF completo do vendedor (ex: 111.111.111-11):");
                                    String cpfVendedor = cadastraVendedor.nextLine();

                                    //Verificando se CPF já existe
                                    Validacoes cpfValida = new Validacoes();
                                    if(cpfValida.verificaCpfDb(cpfVendedor,0) == false) {
                                        adm.setNome(nomeVendedor);
                                        adm.setEmail(emailVendedor);
                                        adm.setCpf(cpfVendedor);

                                        adm.adicionaVendedor();
                                    }else {
                                        System.out.println("Vendedor já cadastrado!");
                                    }
                                    //-----
                                }else {
                                    System.out.println("Vendedor já cadastrado!");
                                }

                                break;
                            case 2: //Mostrar todos os vendedores
                                System.out.println(">> MOSTRAR TODOS OS VENDEDORES");

                                adm.mostraVendedor();
                                break;
                            case 3: //Mostrar todos os clientes
                                System.out.println(">> MOSTRAR TODOS OS CLIENTES");
                                break;
                            case 4: //Mostrar todas as vendas
                                System.out.println(">> MOSTRAR TODAS AS VENDAS");
                                break;
                        }//end switch




                        sair = admin.menuSair();//Menu para sair do sistema
                        break;
                    case "1": //Vendedor
                        System.out.println("> VENDEDOR");
//                        LeitorTeclado vendedor = new LeitorTeclado();
//                        vendedor.menuTecladoVendedor();
//
//                        String login = "cleberson.isac@lojazup.com.br";
//                        String clienteNome = "Bianca Tainá Fonseca";
//                        String clienteCpf = "040.229.790-38";
//                        String clienteEmail = "bia.fonseca@yahoo.com";
//
//                        AdminVendedor vendedorBase = new AdminVendedor();
//                        vendedorBase.setLogin(login);
//
//                        vendedorBase.adicionaCliente(clienteNome,clienteCpf,clienteEmail);
//
//
//                        sair = vendedor.menuSair();//Menu para sair do sistema
                        break;
                }//End switch
            }//End while
        }//end sistema

    }//end static
}//end main
