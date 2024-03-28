# **Sistema de Controle de Estoque**

Desenvolvido para gerenciar clientes, fornecedores, produtos e notas de entrada e saída. O sistema facilita o acompanhamento e a gestão do estoque de uma empresa.

## **Requisitos de Software**

Para executar este projeto, são necessários os seguintes softwares:

- IDE Eclipse
- Banco de dados MySQL Workbench
- JDK (Java Development Kit)
- Postman (para testar APIs)

## **Configuração do Ambiente**

Siga estas etapas para configurar o ambiente de desenvolvimento:

1. Instale o Eclipse, o MySQL Workbench, o JDK e o Postman em seu sistema.
2. Abra o Eclipse e importe o projeto.
3. Execute a classe **`ApplicationJava`** localizada em **`src/main/java`** como uma aplicação Java.
4. Certifique-se de que o MySQL Workbench esteja em execução e configure o banco de dados conforme especificado no arquivo **`application.properties`**.
5. Execute o servidor e acesse a aplicação em **`http://localhost:8080`**.

## Configuração do Banco de Dados

Este projeto utiliza triggers no banco de dados para automatizar e controlar o estoque de produtos. As triggers são acionadas em determinados eventos, como inserções, atualizações ou exclusões de registros nas tabelas de notas de entrada e saída, garantindo que o estoque seja atualizado corretamente.

- As triggers são implementadas no banco de dados MySQL.
- O arquivo triggers.sql está localizado em “**`src/main/resources`**”.

## **Funcionalidades Principais**

- Cadastro de clientes, fornecedores e produtos.
- Gerenciamento de notas de entrada e saída.
- Controle de estoque.

## **Utilização**

1. Acesse a interface do sistema através do navegador.
2. Cadastre clientes, fornecedores e produtos conforme necessário.
3. Registre as notas de entrada para adicionar itens ao estoque.
4. Registre as notas de saída para remover itens do estoque.
5. Visualize e gerencie o estoque através da interface de controle.

## Tecnologias utilizadas:

1. **Java**
2. **Spring Boot**
3. **Thymeleaf**
4. **MySQL**
5. **Bootstrap**
6. **HTML/CSS**
7. **JavaScript**
8. **Hibernate**
