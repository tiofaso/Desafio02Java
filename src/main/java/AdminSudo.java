public class AdminSudo extends Usuarios{
    public AdminSudo(String nome, String senha, String cpf, String email) {
        super(nome, senha, cpf, email);
        setNome(nome);
        setSenha(senha);
        setCpf(cpf);
        setEmail(email);
    }

    public AdminSudo(){}

    public void adicionaVendedor() {
        String nome = getNome();
        String emal = getEmail();
        String cpf = getCpf();

        AcessosDbAdmin novoVendedor = new AcessosDbAdmin();
        novoVendedor.adicionaVendedorDb(nome, emal, cpf);
    }

    public void mostraVendedor(){
        AcessosDbAdmin listaVendedores = new AcessosDbAdmin();
        listaVendedores.mostraVendedores();

    }
}
