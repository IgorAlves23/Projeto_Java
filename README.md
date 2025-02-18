# Avaliação Java / Spring: API Rest para Controle de Contatos ☕️

Este projeto consiste em uma API REST desenvolvida para gerenciar o cadastro de **Pessoas** e seus respectivos **Contatos**. O objetivo principal é permitir a realização de operações CRUD (Criar, Ler, Atualizar, Deletar) sobre as entidades **Pessoa** e **Contato**.

## Funcionalidades

A API permite as seguintes operações:

### Pessoas
- **Criar Pessoa**: Cadastro de uma nova pessoa.
- **Ler Pessoa**: Consultar os dados de uma pessoa específica.
- **Atualizar Pessoa**: Atualizar as informações de uma pessoa cadastrada.
- **Deletar Pessoa**: Excluir uma pessoa e seus contatos.

### Contatos
- **Criar Contato**: Cadastro de um novo contato para uma pessoa.
- **Ler Contato**: Consultar os dados de um contato específico.
- **Atualizar Contato**: Atualizar as informações de um contato existente.
- **Deletar Contato**: Excluir um contato de uma pessoa.

### Tecnologias Utilizadas

- **Java - JDK 21**
-  **Maven - Versão 3.9.9**
-  **Spring Boot - Versão 3.4.2**
-  **Spring Data JPA**
-  **Banco de Dados H2**
-  **Swagger**

### Clone do Repositorio
```bash
   git clone https://github.com/IgorAlves23/Projeto_Java.git.
```
### Acessando o Swegger
para acessar o Swegger da Aplicação ulitlize o link:

[Link do Swegger](http://localhost:8080/swagger-ui.html)

### Tipos de Contatos
- **Telefone = 0**
- **Celular = 1**
- **Email = 2**
- **Rede Social = 3**
  
### Pontos finais da API

#### Pessoas
- POST /pessoas : Cria uma nova pessoa.
- GET /pessoas/{id} : Recupera os dados de uma pessoa por ID.
- GET /api/pessoas/maladireta/{id} : retorna os dados de uma Pessoa por ID para
mala direta
- GET /api/pessoas : lista todas as Pessoas
- PUT /pessoas/{id} : Atualiza as informações de uma pessoa.
- DELETE /pessoas/{id} : Excluir uma pessoa.

#### Contatos
- POST /contato : Crie um novo contato para uma pessoa.
- GET /contatos/{id} : Recupera os dados de um contato específico.
- GET /api/contatos/lista/{pessoaid} (lista todos os Contatos de uma Pessoa)
- PUT /contatos/{id} : Atualiza as informações de um contato.
- DELETE /contatos/{id} : Excluir um contato.
