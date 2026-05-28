# 🍲 Cozinha Solidária - Sistema de Gestão

## 📌 Sobre o Projeto

O **Cozinha Solidária** é um sistema web desenvolvido com o objetivo de auxiliar organizações não governamentais (ONGs) e projetos sociais na gestão de cozinhas comunitárias.

A aplicação busca otimizar o controle de estoque de alimentos, reduzir desperdícios e apoiar o planejamento de refeições, contribuindo para um maior impacto social.

---

## 🎯 Objetivo

Desenvolver uma solução tecnológica simples, acessível e eficiente para:

* Controlar o estoque de alimentos
* Monitorar datas de validade
* Reduzir o desperdício
* Auxiliar no planejamento de refeições
* Melhorar a organização da cozinha comunitária

---

## 🧩 Funcionalidades

* 📦 Cadastro de alimentos
* 📋 Listagem de estoque
* ⚠️ Alerta de validade próxima
* ❌ Identificação de alimentos vencidos
* 🍽️ Apoio ao planejamento de refeições
* 📊 Base para relatórios de impacto

---

## 🧠 Regras de Negócio

* Alimentos vencidos não podem ser utilizados
* Itens próximos ao vencimento devem ter prioridade
* Não é permitido utilizar mais do que o disponível em estoque
* O sistema deve alertar sobre alimentos próximos da validade
* Apenas alimentos válidos podem ser usados no preparo

---

## 🛠️ Tecnologias Utilizadas

### Backend

* Java
* Spring Boot

### Frontend

* HTML
* CSS
* JavaScript

### Banco de Dados

* MySql
* OBS : Utilizei o Banco de dados em memoria H2 para testar se estava dando tudo certo

---

## 🏗️ Estrutura do Projeto

```
projeto-cozinha-solidaria
├── backend
│   ├── controller
│   ├── service
│   ├── repository
│   └── model
│
└── frontend
    ├── index.html
    ├── style.css
    └── script.js
```

---

## 🚀 Como Executar o Projeto

### 🔧 Backend (Java)

1. Clone o repositório:

```
git clone https://github.com/seu-usuario/cozinha-solidaria.git
```

2. Acesse a pasta do backend:

```
cd backend
```

3. Execute o projeto:

```
./mvnw spring-boot:run
```

4. O servidor estará disponível em:

```
http://localhost:8080
```

---

### 🌐 Frontend

1. Acesse a pasta:

```
cd frontend
```

2. Abra o arquivo:

```
index.html
```

3. Ou utilize uma extensão como Live Server

---

## 🔗 Integração Frontend ↔ Backend

A comunicação é feita via API REST utilizando requisições HTTP:

* `GET /alimentos` → lista alimentos
* `POST /alimentos` → cadastra alimento

---

## 📊 Resultados Esperados

* Redução do desperdício de alimentos
* Melhor controle de estoque
* Aumento da eficiência da cozinha
* Organização das doações
* Maior impacto social

---

## 🌱 Impacto Social

Este projeto visa contribuir diretamente com:

* Combate à fome
* Apoio a comunidades vulneráveis
* Fortalecimento de ONGs
* Uso consciente de recursos

---

## 🔮 Melhorias Futuras

* Sistema de login (usuários e voluntários)
* Dashboard com gráficos
* Integração com notificações (ex: WhatsApp)
* Aplicativo mobile
* Sugestão automática de receitas

---

## 👨‍💻 Autor

Projeto desenvolvido para atividade de extensão acadêmica.

---

## 📄 Licença

Este projeto é de uso acadêmico e livre para fins educacionais.
