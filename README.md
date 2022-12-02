# Projeto3.2

## Projeto LAB Supermarket  

Projeto desenvolvido utilizando a linguagem Java com springboot, e banco de dados postgresql, 
possuindo documentação desenvolvida utilizando swagger, como requisito para conclusão do projeto 2
do módulo 3 do curso futuroDev do Senai.

### Ferramentas e requisitos necessárias para rodar o projeto

- Intellij, VSCode ou Eclipse
- JDK 17
- PgAdmin4 versão 15
- Postman
- Maven
- JPA/Hibernate

### Como rodar a Aplicação

1. Inicia sua IDE
2. Inicie seu banco de dados PgAdmin4
3. Na aba file, carregue o projeto
4. Após carregar o projeto, com botão direito sob o projeto, carregue o maven
5. Execute o codigo
6. Acesse a documentação em http://localhost:8000/swagger-ui.html
7. Usando o Postman, utilize os end points apresentados na documentação

### Modelo JSON de entrada
```json
{
        "id": 0,
        "nomeCategoria": "String",
        "descricaoCategoria": "String",
        "produtos": [
           "id": 0,
           "nomeProduto": "string",
            "precoProduto": 0,
            "statusProduto": "COMPRADO"
        ]
}
```
### Tipos de dados

- id -> identificador criado automaticamente
- nomeCategoria -> String de preenchimento obrigatório
- descricaoCategoria" -> String de preenchimento não obrigatório
- nomeProduto -> String de preenchimento obrigatório
- precoProduto -> Valor do produto usando . como separador de preenchimento obrigatório
- statusProduto -> status do produto, que somente aceita COMPRADO e NAO_COMPRADO como valores

### Modelo Relacional 
![](https://github.com/Murilod/Projeto3.2/blob/0ea8cfe3a27bb27c6873a93b73af3a1b03256413/modelo_relacional.png)

### Autor

Murilo Dircksen
https://www.linkedin.com/in/murilodircksen/
