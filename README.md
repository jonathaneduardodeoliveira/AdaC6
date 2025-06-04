
# 🧠 Algoritmos de Busca — Projeto Ada Tech + C6 Bank ☕

    Este repositório contém soluções em **Java ☕** desenvolvidas como parte do curso da **Ada Tech em parceria com o C6 Bank**, focado em **algoritmos de busca, estruturas de dados e lógica de programação**.

Aqui você encontra a implementação de dois desafios práticos, que trabalham conceitos fundamentais de algoritmos:

- 🔍 **Busca Binária**
- 💣 **Busca em Grafos (Maximum Detonation)**

---

## 🚀 Descrição dos Desafios

### 🔍 Busca Binária — [LeetCode 704](https://leetcode.com/problems/binary-search/)
Implementação do clássico algoritmo de **busca binária**, que permite encontrar um elemento em um vetor ordenado de forma eficiente, com complexidade **O(log n)**.

#### 🏗️ Como funciona:
- Define os ponteiros `esquerda` e `direita`.
- Calcula o ponto médio.
- Compara o elemento do meio com o alvo.
- Decide se continua buscando à esquerda ou à direita.
- Retorna a posição do elemento, ou `-1` se não encontrado.

#### 📄 Arquivo:
`BuscaNoArrayOrdenado.java`

---

### 💣 Maximum Detonation — [LeetCode 2101](https://leetcode.com/problems/detonate-the-maximum-bombs/)
Desafio que simula a detonação de bombas onde cada bomba possui uma área de alcance. A partir de uma bomba inicial, o algoritmo calcula quantas outras bombas podem ser detonadas em cadeia.

Aqui a lógica foi realmente colocada à prova! 💥  
Foi utilizado um algoritmo de **busca em profundidade (DFS)** aplicado a um **grafo**, onde cada bomba representa um nó, e as conexões são definidas pelo alcance de detonação.

#### 🏗️ Como funciona:
- Cria um grafo onde cada bomba aponta para as bombas que estão dentro do seu alcance.
- Percorre cada bomba aplicando DFS para calcular a quantidade máxima de bombas detonadas em cadeia.
- Retorna o maior valor encontrado.

#### 📄 Arquivo:
`DetonacaoDeBombas.java`

---

## 🧠 Conceitos Estudados

- Estruturas de Dados (Arrays, Listas e Grafos)
- Algoritmos de Busca:
  - 🔸 Busca Linear
  - 🔸 Busca Binária
  - 🔸 Busca em Grafos: DFS e BFS
- Leitura de Arquivos e Processamento de Dados
- Análise de Complexidade de Algoritmos

---

## 🛠️ Tecnologias e Ferramentas

- ☕ **Java**
- 💻 **IntelliJ IDEA / VS Code**
- 🌐 **LeetCode** para prática de algoritmos
- 🐙 **GitHub** para versionamento e portfólio

---

## 📦 Como Executar

1. Clone este repositório:  
```bash
git clone https://github.com/jonathaneduardodeoliveira/AdaC6.git
```

2. Abra no seu editor (IntelliJ IDEA, VS Code ou outro).

3. Execute as classes `BuscaNoArrayOrdenado.java` e `DetonacaoDeBombas.java` diretamente.

---

## 📚 Referências

- 📄 **Material da aula de Algoritmos - Ada Tech + C6 Bank**  
- 🔗 [LeetCode 704 — Binary Search](https://leetcode.com/problems/binary-search/)  
- 🔗 [LeetCode 2101 — Maximum Detonation](https://leetcode.com/problems/detonate-the-maximum-bombs/)  

---

## ✨ Autor

Feito com 💙 e muito ☕ por **Jonathan Eduardo de Oliveira**  
🔗 [Meu GitHub](https://github.com/jonathaneduardodeoliveira)  

---

## 🚀 Bora codar mais e evoluir sempre! 💻🔥

---

## 🔥 Licença

Este projeto é livre para estudos e aprimoramento pessoal.
