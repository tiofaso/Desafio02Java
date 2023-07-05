public class AdminVendedor extends Usuarios{
    public AdminVendedor(String nome, String senha, String cpf, String email) {
        super(nome, senha, cpf, email);
        setNome(nome);
        setSenha(senha);
        setCpf(cpf);
        setEmail(email);
    }


    public AdminVendedor(){}

    public void adicionaCliente(String vendedor,String clienteNOme, String clientCpf, String clienteEmail) {
        String login = getLogin();
        String nome = clienteNOme;
        String email = clienteEmail;
        String cpf = clientCpf;

        AcessosDbVendedor novoCliente = new AcessosDbVendedor();
        novoCliente.adicionaCliente(login, nome, email,cpf);
    }

    public void mostraMeusClientes(){
        AcessosDbVendedor listaClientes = new AcessosDbVendedor();
        listaClientes.mostraMeusClientes(getLogin());

    }

    public void adicionaVenda(String login, String cpfCliente, double valor){
        AcessosDbVendedor novaVenda = new AcessosDbVendedor();
        novaVenda.adicionarVenda(login,cpfCliente,valor);
    }

    public void mostraMinhasVendas(){
        AcessosDbVendedor listaVendas = new AcessosDbVendedor();
        listaVendas.mostraMinhasVendas(getLogin());

    }

    public void pesquisaVendas(String cpf){
        AcessosDbVendedor pesquisaVendas = new AcessosDbVendedor();
        pesquisaVendas.pesquisaVendasCpf(cpf);

    }
}
