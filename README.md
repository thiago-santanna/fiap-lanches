********************************************************
# fiap-lanches
********************************************************

Projeto para atender o desafio 1 da Pós-Graduação Fiad AS


### Como usar o aplicativo
********************************************************
Executar o comando ****docker-compose up****  isto irá levantar o sistema e tudo que ele precisa para funcionar.

A Api está disponível em localhost:8080, nela poderá fazer requisição http.

No sistema será possível criar clientes, produtos e fazer pedidos.

A documentação da aplicação poderá ser acessada usando OpenAPI(Swagger) no endereço: ****http://localhost:8080/swagger-ui/index.html****

O Event Storm do projeto pode ser conferido no lindk ****https://miro.com/app/board/uXjVMDfyKnc=/?share_link_id=967608605247****

Estará disponível um aplicação para acessaro banco de dados chamada Adminer que pode ser acessada pelo endereço ****localhost:8181****.

Na tela de entrada informará os dados
* Servidor - mysqlsrv
* Usuario - root
* Senha - root
* Database - fiaplanches
* ********************************************************
Fluxo para fazer um pedido.
1. Criar um produto. Voce terá que usar o recurso para adicinar(POST /item) os itens que ficarão disponíveis para usar no pedido.
Você terá que cadastrar usando uma das categorias, então considere fazer uma busca( GET /categoria) nas categorias e usar uma delas na hroa do cadastro.
2. Agora que temos os produtos vamos criar um pedido(POST /pedido), nesse momento vc receberá um número da comanda, ANOTE pois vamos precisar dele pra todos os outros recursos do pedido.
3. Você poderá informar dados de cliente ou não, caso queira informar o cliente você fará o cadastro(POST /cliente)
4. Depois o fluxo seguirá uma ordem. Troque o 123456 pelo número da comanda.  
   * Confirmar pedido(POST /pedido/123456/confirmar)
   * Pagar pedido (POST /pedido/123456/pagar)
   * Finalizar pedido (POST /pedido/123456/finalizar)
   * Entregar pedido (POST /pedido/123456/entregar)
5. Em todas as etapas a partir da criação já podemos ver o andamento do pedido no recurso (GET /pedido/123456)
6. Segue um arquivo para ser importado no programa Insomnia com os recursos prontos para facilitar os testes.


