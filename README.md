<p align="center">
  <img src="/logo.png" alt="Seuphone Logo" />
  <a href="https://fapen.edu.br/" target="_blank"><img src="/logo_fapen.png" width=130 alt="Faculdade Pentágono Logo" /></a>
</p>

<h3 align="center">
  Seuphone - Gerenciamento de Estoque
</h3>

<p align="center">Projeto Articulador e de Inovação (P.A.I.) da faculdade <a href="https://fapen.edu.br/" target="_blank">FAPEN (Faculdade Pentágono)</a> com objetivo de desenvolver um gerenciamento de estoque</p>

##  Preview
<p align="left">
  <img src="/preview-home.png" width=300 alt="Página Inicial" />
  <img src="/preview-login.png" width=300 alt="Página de Login" />
</p>
<p align="left">
  <img src="/preview-painel.png" width=300 alt="Página Painel Administrativo" />
  <img src="/preview-produtos.png" width=300 alt="Página de listagem de Produtos" />
</p>

##  Requisitos

Esse projeto utiliza as ferramentas:
- <a href="https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads- 
5066655.html 
" target="_blank">JDK 11 LTS</a>
- <a href="https://www- 
us.apache.org/dist/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip 
" target="_blank">Apache Maven 3.6.3</a>
- <a href="https://www.eclipse.org/downloads/packages/release/2019-09/r/eclipse-ide- 
enterprise-java-developers
" target="_blank">Eclipse IDE EE 2019-09</a>
- <a href="https://download.springsource.com/release/TOOLS/update/e4.13/" target="_blank">Plugin Spring Tools Suite 3</a>
- <a href="https://www.postgresql.org/download/" target="_blank">PostgreSQL 12</a>


##  Como usar

Após a instalação de todos os requisítos você deve importar o projeto em seu 
Eclipse e aguardar que todas as dependências.

Enquanto carrega as dependências você pode iniciar a criação do banco de dados pelo <b>PGAdmin 4</b>,
normalmente é instalado junto ao Postgresql. Caso não tenha instalado, você pode baixar <a href="https://www.pgadmin.org/download/" target="_blank">clicando aqui</a>.

Crie um banco de dados chamado <b>seuphone</b> vazio, o próprio sistema irá as tabelas automaticamente.

Após a criação do banco, você deve iniciar o projeto ṕelo <b>eclipse</b>, basta clicar no icone de "play" localizado na "Boot Dashboard".

Agora você pode adicionar o usuário <b>Administrador</b> do sistema pelo <b>PGAdmin</b> na seção "Query Tools" com o seguinte código:
```sql
-- Cria o endereço do usuário
INSERT INTO tb_pessoa(cpf, nome, sexo, dt_nascimento, telefone, celular) 
VALUES('11111111111', 'Administrador', 'M', '2000-01-01','1145554555', '11933333333');

-- Credenciais do usuário
INSERT INTO tb_login(login, senha, email, id_pessoa, inativo) VALUES('admin', 
'$2a$10$gmZkZRZx/RuNCNgLBWw3LO0qSOFukn/Q10ixXmHzuhoEm3gcZ7msi',
'admin@seuphone.com.br', 1, false);

-- Cria perfil administrador
INSERT INTO tb_perfil (id_perfil, descricao) VALUES ('ROLE_ADMIN', 'Administrador do Sistema');

-- Adiciona perfil administrador ao usuário criado anteriormente
INSERT INTO tb_login_perfil (id_login, id_perfil) VALUES (1, 'ROLE_ADMIN');
```

Com isso você pode acessar o sistema através da url:
```
http://localhost:8080/
```
Você pode acessar o sistema pelas credenciais criadas anteriormente:
```
Usuário: admin
Senha: 1234
```
