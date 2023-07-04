public class AdminVendedor extends Usuarios{
    public AdminVendedor(String nome, String senha, String cpf, String email) {
        super(nome, senha, cpf, email);
        setNome(nome);
        setSenha(senha);
        setCpf(cpf);
        setEmail(email);
    }

    public AdminVendedor(){}

    public void adicionaCliente(String clienteNOme, String clientCpf, String clienteEmail) {
        String vendedor = getLogin();
        String nome = clienteNOme;
        String email = clienteEmail;
        String cpf = clientCpf;

        AcessosDbVendedor novoCliente = new AcessosDbVendedor();
        novoCliente.adicionaCliente(vendedor, nome, email,cpf);
    }

}
