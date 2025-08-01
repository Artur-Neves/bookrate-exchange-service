<h1 align="center">Exchange Service - Bookrate</h1>

![GitHub Org's stars](https://img.shields.io/github/license/Artur-Neves/Gerenciamento-escolar_java)
&nbsp;
![Badge Finalizado](http://img.shields.io/static/v1?label=STATUS&message=finalizado)

Este é um dos microsserviços do projeto <a href="https://github.com/Artur-Neves/bookrate" target="_blank">bookrate</a>. Trata-se de uma **API REST** responsável pelo CRUD da entidade `Exchange`, que funciona como um conversor de moedas. Além das operações básicas, possui um endpoint específico (`/exchange-service/{value}/{from}/{to}`) que realiza a conversão de valores, sendo utilizado por outro serviço: o <a href="https://github.com/Artur-Neves/book-service" target="_blank">book-service</a>.

<br>

# :hammer: Funcionalidades do projeto

- **`CRUD de Exchange`**: Endpoints para criar, buscar, atualizar e remover taxas de conversão entre moedas.
- **`Conversão de Moedas`**: Endpoint que converte um valor em dólar para outra moeda com base nas taxas configuradas.
- **`Integração com outros microsserviços`**: O serviço é utilizado como dependência pelo `book-service` para obter valores convertidos.
- **`Documentação e Validação`**: Utilização de validação com Bean Validation e documentação automática com Swagger UI.
- **`Monitoramento e rastreamento`**: Métricas e rastreio com Actuator, Micrometer e Zipkin.

<br>

## ✔️ Técnicas e tecnologias utilizadas

As técnicas e tecnologias utilizadas no projeto foram:

- **`Spring Boot`**: Framework principal para construção da aplicação.
- **`Spring Web`**: Criação de endpoints RESTful.
- **`Spring Data JPA`**: Abstração de persistência com banco relacional.
- **`MySQL`**: Banco de dados utilizado para armazenar as taxas de conversão.
- **`Flyway`**: Controle de versão e migração de banco de dados.
- **`Spring Boot Validation`**: Validação de dados com anotações.
- **`Spring Cloud Netflix Eureka Client`**: Permite o registro no serviço de descoberta (Eureka).
- **`Micrometer + Brave + Zipkin`**: Observabilidade e rastreamento distribuído.
- **`Spring Boot Actuator`**: Monitoramento dos indicadores do serviço.
- **`Springdoc OpenAPI (Swagger UI)`**: Documentação visual e interativa das APIs.
- **`Java 17`**: Linguagem utilizada no desenvolvimento.
- **`Maven`**: Gerenciamento de dependências e empacotamento da aplicação.
- **`Docker`**: Suporte à containerização (quando necessário).

<br>
