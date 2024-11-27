Projeto de Gerenciamento de Produtos com JPA
Este é um projeto simples de gerenciamento de produtos utilizando JPA (Java Persistence API) e Hibernate como provedor de persistência. O sistema permite ao usuário inserir dados de produtos (nome e preço), persistir esses dados em um banco de dados (H2 em memória por padrão) e listar os produtos armazenados.

Funcionalidades
Cadastrar Produtos: O usuário pode inserir o nome e o preço do produto.
Persistir Dados: Os produtos inseridos são armazenados no banco de dados usando JPA.
Listar Produtos: O sistema lista todos os produtos armazenados no banco de dados.
Tecnologias Utilizadas
Java 8+
JPA (Java Persistence API)
Hibernate como provedor de JPA
H2 como banco de dados em memória
Maven (caso esteja utilizando um gerenciador de dependências)
Estrutura do Projeto
O projeto é composto por duas classes principais:

Produto: Representa a entidade do produto, com atributos como nome e preco.
ProdutoDAO: Realiza as operações de persistência (CRUD) no banco de dados.
Main: Classe principal que interage com o usuário para cadastrar e listar produtos.

Como Configurar o Projeto:

1. Clonando o Repositório
Clone este repositório para sua máquina local:

bash
Copiar código
git clone https://github.com/username/projeto-gerenciamento-produtos.git
cd projeto-gerenciamento-produtos

2. Importando o Projeto
Se estiver utilizando uma IDE como IntelliJ IDEA, Eclipse, ou VSCode, você pode importar o projeto como um projeto Maven.

3. Dependências (Maven)
Se estiver utilizando o Maven como gerenciador de dependências, o pom.xml deve conter as dependências necessárias para o JPA, Hibernate e H2. Aqui está um exemplo de dependências para adicionar no pom.xml:

xml
Copiar código
<dependencies>
    <!-- JPA API -->
    <dependency>
        <groupId>javax.persistence</groupId>
        <artifactId>javax.persistence-api</artifactId>
        <version>2.2</version>
    </dependency>

    <!-- Hibernate Core -->
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>5.4.30.Final</version>
    </dependency>

    <!-- H2 Database (Banco de dados em memória) -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <version>1.4.200</version>
    </dependency>
</dependencies>

4. Arquivo de Configuração persistence.xml
Certifique-se de que o arquivo persistence.xml está configurado corretamente na pasta src/main/resources/META-INF/. Aqui está um exemplo do arquivo persistence.xml:

xml
Copiar código
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence" version="2.2">
    <persistence-unit name="produtoPU">
        <class>main.java.Produto</class>
        <properties>
            <property name="javax.persistence.jdbc.driver" value="org.h2.Driver"/>
            <property name="javax.persistence.jdbc.url" value="jdbc:h2:mem:test;DB_CLOSE_DELAY=-1"/>
            <property name="javax.persistence.jdbc.user" value="sa"/>
            <property name="javax.persistence.jdbc.password" value=""/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
        </properties>
    </persistence-unit>
</persistence>
Este arquivo configura o banco H2 em memória, onde os dados serão armazenados temporariamente durante a execução do programa.

5. Executando o Projeto
Após configurar o projeto, execute a classe Main.java para iniciar o sistema de gerenciamento de produtos. O terminal pedirá ao usuário para inserir o nome e o preço dos produtos e, ao final, listará todos os produtos armazenados.

Exemplo de Execução
Quando o programa for executado, ele solicitará a entrada do usuário:

Digite o nome do produto: Produto A
Digite o preço do produto: 100.0
Deseja adicionar outro produto? (sim/não): sim
Digite o nome do produto: Produto B
Digite o preço do produto: 200.0
Deseja adicionar outro produto? (sim/não): não
Lista de produtos no banco de dados:
Produto A - 100.0
Produto B - 200.0
Contribuindo

Licença
Este projeto está licenciado sob a MIT License - veja o arquivo LICENSE para mais detalhes.
