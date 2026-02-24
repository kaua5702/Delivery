## DeliveryApp
Um sistema simples de delivery em Java, que permite cadastrar clientes, produtos, criar pedidos, vincular produtos aos pedidos e registrar pagamentos, tudo integrado a um banco de dados SQLite.

## 🚀 Funcionalidades
- Cadastro de Cliente (ID, nome e endereço).
- Cadastro de Produto (nome, preço e categoria).
- Criação de Pedido vinculado a um cliente.
- Associação de Produtos a um pedido.
- Registro de Pagamento (tipo e valor).
- Listagem de clientes, produtos, pedidos, produtos de um pedido e pagamentos.
- Persistência dos dados em banco de dados SQLite.

## 📂 Estrutura do Projeto
com.kauabiscotto.DeliveryApp
├── Cliente.java
├── Produto.java
├── Pedido.java
├── Pagamento.java
├── ClienteDAO.java
├── ProdutoDAO.java
├── PedidoDAO.java
├── PedidoProdutoDAO.java
├── PagamentoDAO.java
├── ConexaoBD.java
├── InicializaBD.java
└── MainDeliveryApp.java


## 🧑‍💻 Exemplo de Uso
Ao executar o MainDeliveryApp, o usuário interage com o sistema por meio de um menu no console:

=== MENU DELIVERY ===

1 - Cadastrar Cliente

2 - Cadastrar Produto

3 - Criar Pedido

4 - Adicionar Produto ao Pedido

5 - Registrar Pagamento

6 - Listar Clientes

7 - Listar Produtos

8 - Listar Pedidos

9 - Listar Produtos de um Pedido

10 - Listar Pagamentos

0 - Sair


## Exemplo de execução
Escolha uma opção: 1

ID do cliente: 1

Nome: Kauã Biscotto

Endereço: Rua das Flores, 123

Cliente salvo no banco!

Escolha uma opção: 2

Nome do produto: Pizza Calabresa

Preço: 39.90

Categoria: Pizza

Produto salvo no banco!

Escolha uma opção: 3

ID do pedido: 1

ID do cliente: 1

Pedido salvo no banco!

Escolha uma opção: 4

ID do pedido: 1

ID do produto: 1

Produto vinculado ao pedido!

Escolha uma opção: 5

ID do pedido: 1

Tipo de pagamento (Cartão/Pix/Dinheiro): Cartão

Valor: 39.90

Pagamento registrado!



## 🛠️ Tecnologias
- Java 17+
- SQLite (banco de dados)
- JDBC (conexão com o banco)
- Paradigma Orientado a Objetos (POO)
## 📌 Observações
- O projeto é um exemplo didático de integração Java + Banco de Dados.
- Pode ser expandido para incluir interface gráfica (JavaFX/Swing) ou API REST (Spring Boot).
- O banco de dados é criado automaticamente no arquivo delivery.db.
