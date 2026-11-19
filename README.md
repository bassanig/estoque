# Estoque de mídias

Cadastro de jogos, séries e filmes em uma única tela. Informe o título, selecione a categoria e indique a quantidade para salvar o produto.

O projeto usa Java 17, Spring Boot, Spring Web, Thymeleaf, Spring Data JPA e H2. O formulário funciona com HTML e CSS.

## Rodar no IntelliJ IDEA

1. Abra a pasta `estoque-midias` pelo menu **File → Open** e importe o projeto Maven.
2. Selecione um JDK 17 ou superior e aguarde o download das dependências. Se precisar de um JDK, use **Download JDK** no IntelliJ.
3. Abra `EstoqueApplication.java` e clique no botão verde ao lado do método `main`.
4. Acesse [localhost:8080](http://localhost:8080).

O H2 cria o banco automaticamente na pasta `dados/`, relativa ao diretório de execução. Os registros continuam disponíveis depois que você reinicia a aplicação.

## Publicar no GitHub

Crie um repositório vazio no GitHub. No terminal do IntelliJ, dentro da pasta que contém o `pom.xml`, execute os comandos abaixo. Substitua `SEU-USUARIO` e `SEU-REPOSITORIO` pelos seus dados.

```bash
git init
git add .
git commit -m "Cria cadastro de estoque de mídias"
git branch -M main
git remote add origin https://github.com/SEU-USUARIO/SEU-REPOSITORIO.git
git push -u origin main
```

O `.gitignore` exclui os dados locais do H2, os arquivos do IntelliJ e a pasta de compilação.

