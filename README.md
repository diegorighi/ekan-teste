<h1> ekan-teste </h1>

<h3>Não foi implementado CORS, BASIC AUTH, OAuth2 ou Paginação afim de facilitar a execução dos testes</h3>

<h2>Premissas</h2>

Crie uma aplicação utilizando Java e Spring Boot que forneça uma API REST para manter o cadastro
de beneficiários de um plano de saúde.
Devem ser expostos endpoints para executar as seguintes operações:
- Cadastrar um beneficiário junto com seus documentos;
- Listar todos os beneficiários cadastrados;
- Listar todos os documentos de um beneficiário a partir de seu id;
- Atualizar os dados cadastrais de um beneficiário;
- Remover um beneficiário.

<h2>Instruções para depuração do código-fonte</h2>
<ul>
  <li>Primeiramente deve-se realizar um clone em sua máquina do projeto da branch master</li>
  <li>Faça o import para o Eclise ou alguma IDE de sua preferência</li>
  <li>Na classe principal do projeto, EkanTestApplication.class clique com o botão direito, RunAs -> Java Aplication</li>
</ul>

<h2>Documentação do código-fonte com Swagger | OpenAPI</h2>
<h4>O SpringBoot na versão 3 não é compatível com Swagger e SpringFox na data de publicação desse teste. 
Portanto, estou utilizando o OpenAPI https://swagger.io/ </h4>
<ul>
  <li>Primeiramente deve-se realizar um clone em sua máquina do projeto da branch master</li>
  <li>Faça o import para o Eclispe ou alguma IDE de sua preferência</li>
  <li>Na classe principal do projeto, EkanTestApplication.class clique com o botão direito, RunAs -> Java Aplication</li>
  <li>Após subir o projeto poderá conferir na URL http://localhost:8080/swagger-ui/ </li>
</ul>

<h2>Utilizando Postman</h2>
<ul>
  <li>Não é necessário utilizar o Postman para realizar os testes de integração. O Swagger já provê as massas de testes necessárias para execução</li>
  <li>Mesmo assim se preferir optar pela IDE, tenha em mente as seguintes massas</li>
</ul>

<table class="tg">
<thead>
  <tr>
    <th class="tg-7btt">CADASTRAR BENEFICIARIO</th>
    <th class="tg-7btt">ATUALIZAR BENEFICIARIO</th>
    <th class="tg-7btt">REMOVER BENEFICIARIO</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td class="tg-0pky">{<br><br>    "nome" : "Diego Righi",<br><br>    "telefone" : "(11) 94777-2572",<br><br>    "dataNascimento" : "1988-04-13",<br><br>    "listaDocumentos" : [<br><br>        {   "tipoDocumento" : "cpf", <br><br>            "descricao" : "335.192.518-25"<br><br>        },<br><br>        {   "tipoDocumento" : "rg", <br><br>            "descricao" : "41.552.833-1"<br><br>        }<br><br>    ]<br><br>}</td>
    <td class="tg-0pky">{<br>    "nome" : "Diego Righi",<br>    "telefone" : "(11) 94777-2572",<br>    "dataNascimento" : "1988-04-13"<br>}</td>
    <td class="tg-0pky">{<br>    "nome" : "Diego Righi",<br>    "telefone" : "(11) 94777-2572",<br>    "dataNascimento" : "1988-04-13"<br>}</td>
  </tr>
</tbody>
</table>
