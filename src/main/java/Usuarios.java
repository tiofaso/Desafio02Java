public abstract  class Usuarios {
    //Atributos
    private String login; //identificador do usuário (email)
    private String nome; //nome do usuário
    private int acesso; //nível de acesso do usuário (1 vendedor/2 cliente/0 admin)
    private String senha; //senha do usuário
    private String cpf; //cpf do usuário
    private String email; //e-mail do usuário (para diferenciar do login)

    //construtor


    public Usuarios(String nome, String senha, String cpf, String email) {
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.email = email;
    }

    public Usuarios() {}

    //Métodos
    public Boolean login(String login, String senha){return null;}
    public void mostraUsuario(String login){}

    //Getters & Setters
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
