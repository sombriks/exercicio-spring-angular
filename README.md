# exercício java/spring angular

pequena prova de conceito de um frontend angular consumindo um backend java

## requisitos

- java 11
- node 14 (ou nvm usando o 14)
- mysql 8 (ou container docker/podman rodando o banco)

## criando esqueletos de projeto

backend: [https://start.spring.io/](https://start.spring.io/#!type=gradle-project&language=java&platformVersion=2.7.3&packaging=jar&jvmVersion=11&groupId=exercicio.java.angular&artifactId=backend&name=backend&description=Demo%20project%20for%20Spring%20Boot&packageName=exercicio.java.angular.backend&dependencies=lombok,data-jpa,liquibase,mysql,h2,web)

frontend:

```bash
npm install -g @angular/cli
ng new frontend
```

## estrutura do exercício

- gestão de documentos
  - distribuir os documentos entre setores
  - dentro dos setores distribuir em pastas
    - documentos começam sem pasta
  - transferir documentos entre setores
    - aceitar
    - devolver
  - documento tem estado
    - novo
    - transferido
    - encerrado
  - histórico do documento

## problemas para estudar

- uma tela para ver o histórico de um documento
- corrigir o endpoint de atualização do documento
- alteração de banco pra realizar o estado de `encerrado` **usando liquibase**
- adicionar documentação swagger
