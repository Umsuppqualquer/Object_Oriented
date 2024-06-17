Parte 2)

• Tela de consulta de produtos (com pesquisa) e realização de pedidos. (Ator Cliente - Carrinho de compras.)

◦ O usuário poderá consultar em um menu específico para isso um produto
qualquer, pesquisando pelo seu código ou por uma palavra contida em seu nome
ou descrição. O sistema apresentará uma lista com os produtos que atendem
essa pesquisa, o usuário então digita o identificador do produto, que pode ser o
código ou a posição que o mesmo aparece na lista de resultados, e depois
informa a quantidade de itens que deseja comprar. O sistema calcula e mostra
quento será o total do item e solicita a confirmação do usuário para adicionar o
produto ao carrinho.

• Tela de consulta de pedidos por parte do cliente, onde será possível consultar um
pedido feito por número do pedido ou os pedidos realizados em um determinado
intervalo de datas. Para cada pedido, deverá ser possível visualizar seus detalhes,
como quais foram os itens solicitados, o preço individual, quantidade e preço total de
cada item. Lembrando que ao preço total de um pedido deve ser adicionado um
valor de 17% de ICMS.

• Regras para vendas:
    •  Só se pode vender itens que estão em estoque
    • Itens com estoque ZERO devem ser mostrados como indisponíveis na consulta.
    • A realização do pedido deve diminuir a quantidade do estoque.
    • Se o cliente quiser comprar mais do que há em estoque deve receber uma mensagem de erro, oferecendo-lhe a quantidade máxima disponível.
    • Deve ser calculado o valor total do pedido e exibido ao cliente.

• Tela de consulta de pedidos realizados por parte da administração da loja ( Ator Interno) , onde será possível consultar e alterar o status do pedido, gravando para isso as datas de envio e / ou cancelamento.

• Deve ser possível consultar pedidos pelo número do pedido ou pela data de realização do mesmo

• Os pedidos devem ser exibidos uma tela em mestre-detalhe, com o cabeçalho (mestre) mostrando os dados do pedido (data, nro, valor total, etc..) e o corpo (detalhe) mostrando a foto, descrição, quantidade, valor unitário e valor total de cada item do pedido. Tanto usuários internos como o cliente que fez o pedido podem acessar esses dados.

A aplicação deverá implementar todos os requisitos previstos neste documento.