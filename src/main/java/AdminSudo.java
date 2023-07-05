import org.springframework.security.crypto.bcrypt.BCrypt;

public class AdminSudo extends Usuarios {
    public AdminSudo(String nome, String senha, String cpf, String email) {
        super(nome, senha, cpf, email);
        setNome(nome);
        setSenha(senha);
        setCpf(cpf);
        setEmail(email);
    }

    public AdminSudo() {
    }

    public void adicionaVendedor() {
        String nome = getNome();
        String emal = getEmail();
        String cpf = getCpf();

        AcessosDbAdmin novoVendedor = new AcessosDbAdmin();
        novoVendedor.adicionaVendedorDb(nome, emal, cpf);
    }

    public void mostraVendedor() {
        AcessosDbAdmin listaVendedores = new AcessosDbAdmin();
        listaVendedores.mostraVendedores();

    }

    public void mostraCliente() {
        AcessosDbAdmin listaClientes = new AcessosDbAdmin();
        listaClientes.mostraClientes();

    }

    public void mostraVendas() {
        AcessosDbAdmin listaVendas = new AcessosDbAdmin();
        listaVendas.mostraVendas();

    }

    public void mostraVendasPorVendedor(String email) {
        AcessosDbAdmin listaVendas = new AcessosDbAdmin();
        listaVendas.mostraVendasVendedor(email);

    }

    public void criaSenha(String email, String senha) {
        //Gerando salto
        String saltoAutomatico = BCrypt.gensalt();

        //Encriptando senha
        String senhaHash = BCrypt.hashpw(senha, saltoAutomatico);

        AcessosDbAdmin senhaNova = new AcessosDbAdmin();
        senhaNova.criaSenha(email, senhaHash);
    }
}
