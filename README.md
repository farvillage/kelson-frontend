# Site Uniesp

## Introdução
Documentação do projeto **SITE_UNIESP_2024_2**, desenvolvido utilizando o framework React. Este projeto visa criar um site para a UNIESP. A estrutura deste relatório está dividida nas seguintes seções:
1. **Desenvolvimento:** Organização e estrutura do projeto.
2. **Dependências:** Bibliotecas e ferramentas utilizadas.
3. **Componentes e Páginas:** Detalhamento dos elementos principais do site.
4. **App.js:** Funções e responsabilidade pelo gerenciamento de rotas.

---

## Desenvolvimento

### Estrutura
A estrutura do projeto está organizada da seguinte forma:

- **Raiz do projeto:** Contém três diretórios principais:
  - `data:` Armazena o banco de dados fictício no arquivo `db.json`, simulando interações com um banco de dados real.
  - `public:` Contém imagens e outros arquivos de acesso público.
  - `src:` Diretório principal com os seguintes subdiretórios:
    - **assets:** Contém imagens privadas ou com acesso restrito.
    - **components:** Fragmentos reutilizáveis de código que podem ser renderizados em várias páginas.
    - **pages:** Armazena as páginas da aplicação, organizadas entre públicas e administrativas (admin/user).

Além disso, na raiz do projeto estão os arquivos de estilização global:
- `App.css` e `index.css` — responsáveis pelo estilo geral do site.
- `App.js` — centraliza as rotas e realiza a renderização das páginas.

---

## Dependências Utilizadas

- **`@emotion/react:`** Biblioteca de estilização com CSS-in-JS, permitindo estilos dinâmicos baseados em propriedades ou estados.
- **`@emotion/styled:`** Extensão do `@emotion/react`, usada para criar componentes estilizados de maneira mais declarativa.
- **`@mui/icons-material:`** Conjunto de ícones alinhados ao Material Design, prontos para uso.
- **`@mui/material:`** Biblioteca de componentes de UI baseados no Material Design, como botões, tabelas e diálogos.
- **`axios:`** Cliente HTTP para realizar requisições (GET, POST, PUT, DELETE) e interagir com APIs.
- **`json-server:`** Ferramenta para simular um backend RESTful usando um arquivo JSON como banco de dados.
- **`react-dom:`** Gerencia a renderização do DOM e conecta os componentes React à estrutura HTML.
- **`react-router-dom:`** Biblioteca de roteamento para React, permitindo navegação entre páginas e gerenciamento de URLs dinâmicas.

---

## Componentes

Os **components** são fragmentos de código reutilizáveis que ajudam a otimizar o desenvolvimento e evitar duplicação. Dois exemplos principais são:

- **NavBar:**  
  Componente de navegação que contém botões/menu para acessar diferentes seções do site.

- **BannerAd:**  
  Renderiza um banner exibido em todas as páginas da aplicação.

---

## Páginas (Pages)

As páginas do projeto estão organizadas em dois grupos:
- **Públicas:** Acessíveis a qualquer usuário.
- **Privadas:** Exclusivas para administradores.

### Páginas Desenvolvidas:
- **DpoLgpd:** Informações sobre DPO e LGPD.
- **Faculdade:** Apresenta informações gerais sobre a instituição.
- **Inicial:** Página inicial do site.
- **Noticias:** Exibe as notícias da UNIESP, consumindo dados do banco fictício.
- **VisualizarNoticias:** Mostra os detalhes de uma notícia específica, buscando informações pelo ID (similar a `findById`).

---

## App.js

O arquivo **App.js** é responsável pela gestão de rotas e renderização das páginas. Ele utiliza a biblioteca `react-router-dom` para:
- **BrowserRouter:** Definir o contexto geral de rotas.
- **Routes e Route:** Configurar as rotas e suas respectivas páginas.

Também é no **App.js** que os componentes **NavBar** e **BannerAd** são inseridos, garantindo que sejam exibidos em todas as páginas.

---
