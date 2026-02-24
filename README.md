# DeliveryApp

Um sistema simples de delivery em Java, que permite criar clientes, pedidos, adicionar produtos e escolher diferentes formas de pagamento.

## 🚀 Funcionalidades
- Cadastro de **Cliente** (ID, nome e endereço).
- Criação de **Pedido** vinculado a um cliente.
- Adição de **Produtos** (nome, preço e categoria).
- Cálculo automático do **total do pedido**.
- Escolha da **forma de pagamento**:
  - Pix
  - Cartão
  - Dinheiro
  - Banco (transferência)
- Finalização do pedido com simulação de processamento.

## 📂 Estrutura do Projeto
com.kauabiscotto.DeliveryApp ├── Cliente.java ├── Pedido.java ├── Produto.java ├── Pagamento.java (interface) ├── PagamentoPix.java ├── PagamentoCartao.java ├── PagamentoDinheiro.java ├── PagamentoBanco.java └── Main.java

## 🧑‍💻 Exemplo de Uso
Ao executar o `Main.java`, o usuário interage com o sistema:

1. Digita os dados do cliente.
2. Cria um pedido e adiciona produtos.
3. Escolhe a forma de pagamento.
4. O sistema simula o processamento e mostra o resumo final.

### Exemplo de execução
=== Cadastro do Cliente ===

Digite o ID do cliente: 1

Digite o nome do cliente: Kauã Biscotto

Digite o endereço do cliente: Rua das Flores, 123

=== Criando Pedido ===

Digite o ID do pedido: 101

Cliente associado ao pedido!

=== Adicionando Produtos === 

Nome do produto: Hambúrguer

Preço do produto: 20

Categoria do produto: Comida

Produto adicionado!

Deseja adicionar outro produto? (s/n): s

Nome do produto: Refrigerante

Preço do produto: 5

Categoria do produto: Bebida

Produto adicionado!

Deseja adicionar outro produto? (s/n): n

=== Forma de Pagamento === 

1 - Pix 

2 - Cartão 

3 - Dinheiro 

4 - Banco 

Escolha a forma de pagamento: 2 

forma de pagamento definida!

--- Pedido antes da finalização --- 

Pedido ID: 101 

Status: Em andamento 

Cliente: Kauã Biscotto | Endereço: Rua das Flores, 123 

Produtos:

- Hambúrguer  R$20.0

- Refrigerante  R$5.0 Total: R$25.0

Processando pagamento...

Pagamento de R$25.0 realizado com Cartão.

Pedido concluído!

Gerando resumo do pedido...

--- Pedido após finalização ---

  Pedido ID: 101
  
  Status: Finalizado
  
  Cliente: Kauã Biscotto | Endereço: Rua das Flores, 123
  
  Produtos:
- Hambúrguer  R$20.0
- Refrigerante  R$5.0 Total: R$25.0

  
## 🛠️ Tecnologias
- Java 17+
- Paradigma Orientado a Objetos (POO)

## 📌 Observações
- O projeto é apenas um exemplo didático de POO em Java.
- Pode ser expandido para incluir banco de dados, interface gráfica ou API REST.
