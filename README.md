# Folha de Ponto Ília Digital
## Desafio Técnico Ília Digital - 2021

A aplicação consiste em 3 endpoints para:
- Registro de Ponto
- Alocação de Horas Trabalhadas
- Relatório do Mês

As especificações do Open API encontra-se em: **resources/openapi/controle-de-ponto_api.yaml**.

### Desenvolvimento do Projeto

- [X] Registo de Ponto
- [X] Alocação de Horas Trabalhadas
- [X] Relatório do Mês
- [ ] Testes

### Estrutura

```
.
└── ilia-folha-de-ponto
    ├── mvnw
    ├── mvnw.cmd
    ├── pom.xml
    ├── README.md
    └── src
        └── main
            ├── java
            │   └── br
            │       └── com
            │           └── ilia
            │               └── digital
            │                   └── folhadeponto
            │                       ├── controller
            │                       │   ├── AlocacaoController.java
            │                       │   ├── RegistroController.java
            │                       │   └── RelatorioController.java
            │                       ├── dao
            │                       │   ├── AlocacaoDao.java
            │                       │   ├── InMemoryDb.java
            │                       │   └── RegistroDao.java
            │                       ├── exception
            │                       │   ├── AllTimesRegisteredException.java
            │                       │   ├── ApiExceptionHandler.java
            │                       │   ├── ApiException.java
            │                       │   ├── NotFoundException.java
            │                       │   ├── TimeAlreadyRegisteredException.java
            │                       │   ├── TimeRangeException.java
            │                       │   └── TimesNotRegisteredException.java
            │                       ├── FolhaDePontoApplication.java
            │                       ├── model
            │                       │   ├── Alocacao.java
            │                       │   ├── FolhaDePonto.java
            │                       │   └── Registro.java
            │                       └── service
            │                           ├── AlocacaoService.java
            │                           ├── FolhaDePontoService.java
            │                           └── RegistroService.java
            └── resources
                ├── application.properties
                └── openapi
                    └── controle-de-ponto_api.yaml
```

### Como Executar o Projeto no [Linux | Windows]:

No diretório do projeto, execute o comando abaixo para resolver as dependencias do projeto:

```
[./mvnw | ./mvnw.cmd] clean install
```

Para rodar o projeto, execute:
```
[./mvnw | ./mvnw.cmd] spring-boot:run
```

Os endpoints poderão ser acessados em ```http://localhost:8080/``` conforme as especificações do OpenAPI já mencionadas acima.

```
http://localhost:8080/batida
http://localhost:8080/alocacao
http://localhost:8080/folha-de-ponto/{mes}
```

### Tecnologias Utilizadas
- Java 11
- Spring Boot

### Próximos Passos para Aprendizagem

- [ ] Colocar aplicação em container Docker
- [ ] Deploy da aplicação no Heroku

> Status do Projeto: Em desenvolvimento :warning: