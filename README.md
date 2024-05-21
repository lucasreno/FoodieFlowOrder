# Foodie Flow Order

Projeto desenvolvido para entrega do Tech Challenge da Pos Tech - Software Architecture (Fase 4).

## Grupo 102

- Lucas Renó - RM 351351

## Visão Geral

A aplicação é composta por três microserviços que, juntos, formam o Foodie Flow. Além disso, foi criado um projeto
específico para gerenciar a infraestrutura.

- [Foodie Flow Order](https://github.com/lucasreno/FoodieFlowOrder): Responsável por gerenciar os pedidos dos usuários
- [Foodie Flow KDS](https://github.com/lucasreno/FoodieFlowKDS): Responsável por disponibilizar os pedidos para a
  cozinha
- [Foodie Flow Pay](https://github.com/lucasreno/FoodieFlowPay): Responsável por gerenciar os pagamentos dos pedidos
- [Foodie Flow Infra](https://github.com/lucasreno/FoodieFlowInfra): Infraestrutura para os microserviços

## Vídeo de Apresentação

[![Vídeo de Apresentação](https://img.youtube.com/vi/1Q6Q1Q1Q1Q1Q/0.jpg)](https://www.youtube.com/watch?v=1Q6Q1Q1Q1Q1Q)

## Objetivo

Este projeto visa criar um microsserviço que gerencie os pedidos de um restaurante. O microsserviço deve ser capaz de:

## Cobertura de Testes
Alcançado 90% de cobertura de testes.
![Testes](https://github.com/lucasreno/FoodieFlowOrder/assets/62509668/5a1bd53c-b189-46ef-98d0-5bea6b4d4f09)


#### Stack utilizada:

- Maven
- Groovy
- Spring Boot
- JPA
- PostgreSQL
- H2 Database
- Spock
- Jacoco
- Swagger
- Docker
- Kubernetes
- Github Actions

## Clean Architecture

## Deploy

O processo de deploy foi feito utilizando o Github Actions e o Kubernetes.
A pipeline de CI/CD foi configurada para rodar os testes, gerar o .war e fazer o deploy no Kubernetes.

#### Configuração do projeto para deploy

- Ter um cluster GKE (Google Kubernetes Engine) configurado
- Adicione as seguintes variáveis no repositório do Github:
  - Secrets:
      - `GCP_CREDENTIALS`: Chave obtida no GCP para acesso ao cluster (mais informações [aqui](https://cloud.google.com/docs/authentication/api-keys?hl=pt-br))
      - `GCP_PROJECT_ID`: ID do projeto no GCP
      - `GCP_REGION`: Região onde os recursos serão criados
      - `GKE_CLUSTER_NAME`: Nome do cluster no GCP
      - `POSTGRES_DB`: Nome do banco de dados
      - `POSTGRES_USER`: Usuário do banco de dados
      - `POSTGRES_PASSWORD`: Senha do banco de dados
      - `POSTGRES_HOST`: Host do banco de dados
      - `POSTGRES_PORT`: Porta do banco de dados
  - Variables:
      - `ENVIRONMENT`: Variável que define ambiente (prod/qa)

#### Manifestos Kubernetes

Os manifestos Kubernetes estão localizados na pasta `prod` na raiz do projeto.
- `deploy.yaml`: Arquivo que define o deployment da aplicação, com as configurações de recursos, volume, variáveis de ambiente, etc.
- `service.yaml`: Arquivo que define o serviço da aplicação, com as configurações de porta, tipo de serviço, etc.

## Rodando o projeto localmente

### Com Docker

Dentro da aplicação, execute o comando:

```bash
docker-compose up
```

_* Este comando irá construir a aplicação através do Dockerfile e através do docker-compose.yml irá subir
a aplicação (.war) em um servidor tomcat e uma instância do banco de dados PostgreSQL._

#### Sem Docker

- Para rodar a aplicação sem Docker, é necessário ter o PostgreSQL instalado e rodando na porta 5432.
- É necessário ter o Java 17 instalado.
- É recomendado utilizar o IntelliJ IDEA para rodar a aplicação.
- Para rodar a aplicação, basta executar a classe `FoodieFlowOrderApplication` que está dentro do pacote
  `fiap.como.fforder`.
