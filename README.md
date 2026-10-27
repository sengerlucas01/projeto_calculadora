# Projeto Calculadora — FinançApp

> Versão **original** (branch `main`). A versão refatorada e documentada está na branch [`Refatoracao`](../../tree/Refatoracao).

**Aluno:** Lucas Senger Medeiros · **RA:** 250995 · **Curso:** Análise e Desenvolvimento de Sistemas (Facens)

## Descrição

Módulo de cálculos matemáticos básicos em Java para a startup fictícia **FinançApp** (controle de finanças pessoais). A classe `Calculadora` oferece soma, subtração, multiplicação e divisão por meio do método `calc(int a, int b, String op)`.

## Operações

| Operador | Operação | Comportamento especial |
|---|---|---|
| `+` | Soma | — |
| `-` | Subtração | — |
| `*` | Multiplicação | — |
| `/` | Divisão | Divisão por zero exibe mensagem de erro e retorna `0` |
| qualquer outro | Inválida | Exibe `Operacao invalida` e retorna `0` |

## Como executar

```bash
mkdir out
javac -encoding UTF-8 -d out src/calculadora/*.java
java -cp out calculadora.TesteCalculadora
```

## Resultado dos testes (versão original)

```text
=== TESTES DA CALCULADORA (versao original) ===

--- Soma
Entrada  : a=2, b=3, op=+
Esperado : 5
Resultado = 5
Obtido   : 5
Status   : PASSOU

--- Subtracao
Entrada  : a=10, b=4, op=-
Esperado : 6
Resultado = 6
Obtido   : 6
Status   : PASSOU

--- Multiplicacao
Entrada  : a=3, b=5, op=*
Esperado : 15
Resultado = 15
Obtido   : 15
Status   : PASSOU

--- Divisao
Entrada  : a=8, b=2, op=/
Esperado : 4
Resultado = 4
Obtido   : 4
Status   : PASSOU

--- Divisao por zero
Entrada  : a=8, b=0, op=/
Esperado : 0
Erro: divisao por zero, operação irregular
Resultado = 0
Obtido   : 0
Status   : PASSOU

--- Operacao invalida
Entrada  : a=5, b=5, op=x
Esperado : 0
Operacao invalida
Resultado = 0
Obtido   : 0
Status   : PASSOU

--- Operador nulo
Entrada  : a=5, b=5, op=null
Esperado : 0
Operacao invalida
Resultado = 0
Obtido   : 0
Status   : PASSOU

=== RESUMO: 7/7 testes aprovados ===
```

![Print dos testes - versão original](images/testes/teste_original.png)

> A refatoração, o JavaDoc (`docs/index.html`) e o README completo estão na branch `Refatoracao`.
