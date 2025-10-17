# Sistema de Gestão de Inventário e Vendas

O sistema tem como objetivo realizar toda a parte de processamento de uma venda, desde a administração da quantidade de itens no estoque, até o processamento da venda e emissão de relatórios simples.

## Produto

A classe abstrata "Produto" representará um produto genérico que possui os seguintes atributos: Nome, Código, Preço de Custo, Preço de Venda, Quantidade em estoque e quantidade no momento da compra. Foram feitas algumas validações nos setters de alguns dos atributos para garantir a integralidade dos dados, dentre eles:

- O preço de custo não pode ser menor que 0, da mesma forma que o preço de venda do produto não poderá ser menor que o preço de custo.
- As alterações na quantidade de produtos em estoque deverão ser feitas através dos métodos adicionarEstoque() e removerEstoque(), evitando que seja passado um valor igual ou menor que 0 como argumento.
- Todas classes concretas que herdam de "Produto" receberão uma Categoria representada pela enumeração "Categoria", que possui as constantes: Eletrônico, Vestuário, Livro e Alimento.
- Existe a possibilidade de um produto ser submetido a uma taxa, por isso as classes implementam uma interface "Taxável", que calcula a taxa baseada em uma porcentagem passada como argumento. Esse valor calculado junto com a taxa substitui automaticamente o valor atual.

## Estoque

A classe estoque recebe objetos da classe "Produto" e os armazenam em um vetor "Produto[]", portanto trata-se de uma associação unidirecional do tipo um para muitos. O tamanho do estoque é definido em seu construtor.

- A adição ou remoção de Produtos de um estoque é feita através dos métodos "adicionarProdutoAoEstoque()" e "removerProduto()", que recebem o produto a ser removido.
- O método remover estoque cria um novo vetor de tamanho "produtos - 1" e adiciona todos os objetos da lista original para ele, ignorando o objeto que foi informado para ser removido. A verificação da existência do objeto no estoque antes da remoção é feita através do seu cógigo.

## Venda

- A classe "Venda" possui os seguintes atributos que devem ser obrigatoriamnete informados no construtor: Cliente, Status da Venda e Estoque.
- O Status da venda é definido pela enumeração "StatusDaVenda", que tem como opções de constantes os status: CONCLUIDA, PROCESSANDO e CANCELADA.
- O estoque passado na criação do objeto do tipo Venda será o estoque alterado da finalização da venda.
- Os produtos a serem vendidos podem ser adicionados através do método "adicionarProduto()" e removidos através do método "removerProduto()". Ao adicionar o produto devemos informar a quantidade que desejamos comprar.
- São feitas validações sobre existência do item no estoque e sua quantidade antes do produto ser adicionado na venda.
- Assim que o status da venda for definido como "CONCLUIDA", as quantidades dos respectivos produtos serão removidas do estoque automaticamente.
- Para calcular o preço total da venda, é utilizado o método "calcularPrecoItens()", que retorna o preço total e o imprime na tela.

## Relatórios

- Através do método "exibirDetalhes()" é possível imprimir na tela um relatório detalhado da venda, exibindo os itens que estão na lista de venda.
- Também é possível chamar o método "exibirDetalhes()" no objeto da classe Estoque ou no próprio produto criado.
