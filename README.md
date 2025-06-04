
# Busca Textual em Arquivos TXT

## Descrição

Projeto em **Java 21** para busca eficiente de frases em arquivos `.txt` dentro de uma pasta chamada `livros`.  
O sistema normaliza acentuação e caracteres especiais, realizando uma busca rápida e precisa, exibindo o nome do arquivo e as linhas onde a frase foi encontrada.

Este aplicativo foi desenvolvido como parte de um desafio da **Ada**, em parceria com a **C6 Bank**.

---

## Requisitos

- Java 21 instalado (OpenJDK ou Oracle JDK)
- Sistema operacional Windows (testado em CMD, PowerShell e IntelliJ IDEA)
- Pasta `livros` contendo arquivos `.txt` para busca

---

## Como usar no Windows (CMD ou PowerShell)

### Configurar codificação UTF-8 para evitar problemas com acentuação

<pre><code>chcp 65001</code></pre>

---

### Compilar o projeto

No diretório raiz do projeto, execute:

<pre><code>javac -encoding UTF-8 Busca\Textual\*.java</code></pre>

---

### Executar o programa

<pre><code>java Busca.Textual.Main</code></pre>

---

## Fluxo básico do programa

1. Executar o programa.
2. Digitar a frase que deseja buscar.
3. O sistema exibe os arquivos e linhas onde a frase foi encontrada.
4. Se não encontrada, o programa informa "Não encontrado."

---

## Observações

- Certifique-se de que a pasta `livros` esteja no mesmo nível do diretório onde o programa é executado.
- O sistema suporta buscas case-insensitive e ignora acentuação.
- A saída no terminal respeita UTF-8, por isso a importância do comando `chcp 65001`.
- Testado e funcionando também no **IntelliJ IDEA**, facilitando o desenvolvimento e depuração.

---

## Visão de Futuro

Este projeto pode ser estendido para interfaces gráficas, suporte a múltiplos formatos de arquivo, e até APIs REST para buscas remotas.

---

## Autor

Jonathan Eduardo de Oliveira

---

## Licença

Este projeto é aberto para melhorias e contribuições.
