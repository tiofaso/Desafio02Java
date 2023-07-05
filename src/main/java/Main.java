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

                                        System.out.println("Digite uma senha para o vendedor:");
                                        Scanner entrada = new Scanner(System.in);
                                        String senha = entrada.nextLine();

                                        adm.criaSenha(emailVendedor, senha);
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
                                adm.mostraCliente();
                                break;
                            case 4: //Mostrar todas as vendas
                                System.out.println(">> MOSTRAR TODAS AS VENDAS");
                                adm.mostraVendas();
                                break;
                            case 5: //Mostrar vendas por vendedor
                                System.out.println(">> PESQUISAR VENDAS POR VENDEDOR");

                                Scanner entrada = new Scanner(System.in);

                                System.out.println("Digite o e-mail do vendedor:");
                                String email = entrada.nextLine();

                                Validacoes validaEmail = new Validacoes();

                                if(validaEmail.verificaEmail(email) == true){
                                    adm.mostraVendasPorVendedor(email);
                                }else{                                }
                                while (validaEmail.verificaEmail(email) == false){
                                    System.out.println("AVISO - É preciso digitar um e-mail válido!");
                                    System.out.println("Digite o e-mail do vendedor:");
                                    email = entrada.nextLine();
                                }


                                break;
                        }//end switch

                        sair = admin.menuSair();//Menu para sair do sistema
                        break;
                    case "1": //Vendedor
                        System.out.println("> VENDEDOR");

                        LeitorTeclado vendedor = new LeitorTeclado();
                        int opcaoVendedor = vendedor.menuTecladoVendedor();

                        AdminVendedor vend = new AdminVendedor();
                        //----
                        switch (opcaoVendedor) {
                            case 1: //Cadastrar cliente
                                System.out.println(">> CADASTRAR CLIENTE");

                                Scanner cadastraCliente = new Scanner(System.in);

                                System.out.println("Digite o nome do cliente:");
                                String nomeCliente = cadastraCliente.nextLine();

                                System.out.println("Digite o e-mail do cliente:");
                                String emailCliente = cadastraCliente.nextLine();

                                //Verificando e-mail
                                Validacoes emailValida = new Validacoes();
                                while (emailValida.verificaEmail(emailCliente) == false) {
                                    System.out.println("Digite um e-mail VÁLIDO do cliente:");
                                    emailCliente = cadastraCliente.nextLine();
                                }

                                //Verificando se e-mail existe
                                if(emailValida.verificaEmailDb(emailCliente,1) == false) {
                                    System.out.println("Digite o CPF completo do cliente (ex: 111.111.111-11):");
                                    String cpfCliente = cadastraCliente.nextLine();

                                    //Verificando se CPF já existe
                                    Validacoes cpfValida = new Validacoes();
                                    if(cpfValida.verificaCpfDb(cpfCliente,1) == false) {
                                        String usrVendedor = vend.getLogin();
                                        vend.setNome(nomeCliente);
                                        vend.setEmail(emailCliente);
                                        vend.setCpf(cpfCliente);

                                        vend.adicionaCliente(usrVendedor, nomeCliente, cpfCliente, emailCliente);
                                    }else {
                                        System.out.println("Cliente já cadastrado!");
                                    }
                                    //-----
                                }else {
                                    System.out.println("Cliente já cadastrado!");
                                }

                                break;
                            case 2: //Cadastrar venda
                                System.out.println(">> CADASTRAR VENDA");

                                Scanner cadastraVenda = new Scanner(System.in);

                                System.out.println("Digite o cpf do cliente (ex: 111.111.111.-11)");
                                String cpfCliente = cadastraVenda.nextLine();

                                //Verificando se CPF já existe
                                Validacoes cpfValida = new Validacoes();
                                if(cpfValida.verificaCpfDbVendedor(cpfCliente, vend.getLogin()) == true) {

                                    System.out.println("Digite o valor da venda:");
                                    Double valorVendaCliente = cadastraVenda.nextDouble();

                                    AdminVendedor venda = new AdminVendedor();
                                    venda.adicionaVenda(venda.getLogin(), cpfCliente,valorVendaCliente);

                                }else {
                                    System.out.println("Cliente não cadastrado no seu portifolio!");
                                }

                                break;
                            case 3: //Mostrar todas as suas vendas
                                System.out.println(">> MOSTRAR TODAS AS SUAS VENDAS");
                                AdminVendedor minhasVendas = new AdminVendedor();
                                minhasVendas.mostraMinhasVendas();
                                break;
                            case 4: //Mostrar todos os seus clientes
                                System.out.println(">> MOSTRAR TODOS OS SEUS CLIENTES");
                                AdminVendedor meusClientes = new AdminVendedor();
                                meusClientes.mostraMeusClientes();

                                break;
                            case 5://Pesquisa vendas por CPF
                                System.out.println(">> PESQUISAR VENDAS POR CPF");

                                Scanner pesquisaVenda = new Scanner(System.in);

                                System.out.println("Digite o cpf do cliente (ex: 111.111.111.-11)");
                                String cpf = pesquisaVenda.nextLine();

                                //Verificando se CPF existe
                                Validacoes cpfExiste = new Validacoes();
                                if(cpfExiste.verificaCpfDbVendedor(cpf, vend.getLogin()) == true) {

                                    AdminVendedor novaPesquisaCpf = new AdminVendedor();

                                    novaPesquisaCpf.pesquisaVendas(cpf);

                                }else {
                                    System.out.println("Cliente não cadastrado no seu portifolio ou inexistente!");
                                }



                                break;
                        }//end switch
                        //----
                        sair = vendedor.menuSair();//Menu para sair do sistema
                        break;
                }//End switch
            }//End while
        }//end sistema

    }//end static
}//end main
