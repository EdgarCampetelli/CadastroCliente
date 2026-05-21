# 👥 Sistema de Cadastro de Clientes e Serviços

A aplicação é um sistema de gerenciamento Full Stack que permite o cadastro, leitura, atualização e exclusão (CRUD) de clientes e a associação deles a serviços específicos. O projeto foi desenvolvido utilizando a arquitetura MVC (Model-View-Controller) com renderização de telas no servidor.

---

## 🛠️ Tecnologias Utilizadas

* **Java 17** (ou a versão que você usou)
* **Spring Boot** (Web, DevTools)
* **Spring Data JPA** & **Hibernate** (Persistência de dados)
* **Banco de Dados:** H2 Database / MySQL (Ajuste para o que você usou)
* **Thymeleaf** (Engine de template para o HTML dinâmico)
* **CSS3** (Estilização customizada e responsiva)

---

## 🧠 Conceitos Aplicados no Projeto

* **Arquitetura MVC:** Separação clara de responsabilidades entre regras de negócio (Services), persistência (Repositories), rotas/telas (Controllers) e visualização (Views).
* **Camada DTO (Data Transfer Object):** Utilização de DTOs para trafegar dados com segurança entre a API e a interface, evitando expor as entidades do banco diretamente.
* **Tratamento de Exceções e Tipagens:** Tratamento rigoroso de tipos (como o uso de `String`/`Long` para evitar estouro de memória em campos de telefone) e validações de dados obrigatórios.
* **Relacionamentos JPA:** Mapeamento de associação entre as tabelas de Clientes e Serviços.

---

## 💻 Telas do Sistema

<img width="1875" height="952" alt="image" src="https://github.com/user-attachments/assets/992d1735-5bb6-44d5-881a-384d0cacdbb1" />
<img width="1876" height="954" alt="image" src="https://github.com/user-attachments/assets/9923632b-5204-49cf-994f-72aca6180e47" />


| Lista de Clientes | Formulário de Cadastro |
|---|---|
| ![Lista de Clientes](img/lista-clientes.png) | ![Cadastro](img/cadastro.png) |

---

## 🚀 Como Executar o Projeto Localmente

### Pré-requisitos
* Java 17 instalado.
* Maven instalado (ou use o wrapper `./mvnw` incluso).
* Uma IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code).

### Passo a Passo
1. Clone o repositório:
   ```bash
   git clone [https://github.com/EdgarCampetelli/CadastroCliente.git](https://github.com/EdgarCampetelli/CadastroCliente.git)
