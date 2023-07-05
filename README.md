# Desafio 02 - Módulo 03 (Catalisa)

O programa aqui apresentado emula um sistema de cadastro e exibição de dados e vendas para clientes com os seus respectivos vendedores.

Para a execução desse projeto em seu maior potencial foi optado por conectar o mesmo a uma base remota MySQL disponibilizada pelo site do autor. Abaixo segue o diagrama da supracitada:

!(https://raw.githubusercontent.com/tiofaso/Desafio02Java/main/src/main/java/uml/desafio02db.drawio.png)

## Como se opera o programa
O programa trabalha com dois níveis de acesso:

 1. **nível 0:** exclusivo para o administrador do programa
 2. **nível 1:** para todos os vendedores da plataforma

No nível 0 é possível adicionar vendedores à plataforma, ver todos os vendedores e clientes cadastrados pelos vendedores, assim como suas vendas.
Já o nível 1 é mais restrito, permitindo que o vendedor visualize apenas as informações pertinentes ao seu login, ou seja, ele só poderá ver os clientes e vendas que ele mesmo fez e cadastrou.

## Segurança
O programa trabalha com encriptação hash com salto feita através do BCrypt. Apenas os vendedores adicionados pelo admin terão acesso à plataforma e a mesma automaticamente impede cadastro de CPFs e emails duplicados em sua base.

## Área de teste
As opções para o admin ter controle total na base foram removidas, permitindo que o mesmo apenas adicione usuários sem poder editar ou apagar nenhum registro. Os vendedores podem apenas adicionar clientes e novas vendas. Para poder testar, utilize os usuários abaixo:

**admin**
 - usuário: tiofaso@zup.com.br
 - senha: 123456faso

**vendedor**
 - usuário: cleberson.isac@lojazup.com.br
 - senha: 123456isac
