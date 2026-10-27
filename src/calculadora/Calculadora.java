package calculadora;

/**
 * <p><strong>Projeto Calculadora</strong></p>
 *
 * <p>Esta classe fornece as operações matemáticas básicas (soma, subtração,
 * multiplicação e divisão) e um método principal que seleciona a operação
 * desejada com base em um operador informado pelo usuário.</p>
 *
 * <p>O módulo foi desenvolvido para a startup fictícia <em>FinançApp</em> e
 * demonstra:</p>
 * <ul>
 *     <li>testes unitários com entrada, resultado esperado e resultado obtido;</li>
 *     <li>tratamento de erros com exceções (divisão por zero e operador inválido);</li>
 *     <li>refatoração de código Java (extração de métodos e uso de {@code switch});</li>
 *     <li>documentação técnica com JavaDoc.</li>
 * </ul>
 *
 * <p>Após a refatoração, os métodos desta classe são <strong>métodos puros</strong>,
 * sem efeitos colaterais (não imprimem nada nem guardam estado), o que melhora a
 * legibilidade e facilita os testes unitários.</p>
 *
 * @author Lucas Senger Medeiros
 * @version 2.0
 */
public class Calculadora {

    /** Mensagem da exceção lançada quando ocorre uma divisão por zero. */
    public static final String MENSAGEM_DIVISAO_POR_ZERO = "Divisão por zero não é permitida.";

    /**
     * Prefixo da mensagem da exceção lançada para operadores inválidos.
     * O operador informado é concatenado ao final do texto.
     */
    public static final String MENSAGEM_OPERADOR_INVALIDO = "Operador inválido: ";

    /**
     * Cria uma nova calculadora. A classe não mantém estado interno,
     * portanto uma única instância pode ser reutilizada em várias operações.
     */
    public Calculadora() {
        // Nenhuma inicialização necessária
    }

    /**
     * Soma dois números inteiros.
     *
     * @param a primeiro operando
     * @param b segundo operando
     * @return o resultado da soma de {@code a} e {@code b}
     */
    public int somar(int a, int b) {
        return a + b;
    }

    /**
     * Subtrai o segundo número inteiro do primeiro.
     *
     * @param a minuendo (valor do qual será subtraído)
     * @param b subtraendo (valor a ser subtraído)
     * @return o resultado de {@code a - b}
     */
    public int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dois números inteiros.
     *
     * @param a primeiro fator
     * @param b segundo fator
     * @return o resultado de {@code a * b}
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide o primeiro número inteiro pelo segundo (divisão inteira).
     *
     * @param a dividendo
     * @param b divisor (não pode ser zero)
     * @return o resultado da divisão inteira de {@code a} por {@code b}
     * @throws IllegalArgumentException se {@code b} for igual a zero
     */
    public int dividir(int a, int b) {
        // Impede a divisão por zero antes de executar a operação
        if (b == 0) {
            throw new IllegalArgumentException(MENSAGEM_DIVISAO_POR_ZERO);
        }
        return a / b;
    }

    /**
     * Executa a operação matemática solicitada com base no operador informado.
     *
     * <p>Operadores aceitos:</p>
     * <ul>
     *     <li>{@code "+"}: soma</li>
     *     <li>{@code "-"}: subtração</li>
     *     <li>{@code "*"}: multiplicação</li>
     *     <li>{@code "/"}: divisão</li>
     * </ul>
     *
     * <p>Qualquer outro operador (incluindo {@code null}) resulta em exceção.</p>
     *
     * @param a        primeiro operando
     * @param b        segundo operando
     * @param operador símbolo da operação desejada
     * @return o resultado da operação correspondente ao operador informado
     * @throws IllegalArgumentException se o operador não for um símbolo válido
     *                                  ou se for solicitada uma divisão por zero
     */
    public int calcular(int a, int b, String operador) {
        // Operador nulo seria um NullPointerException no switch; trata como inválido
        if (operador == null) {
            throw new IllegalArgumentException(MENSAGEM_OPERADOR_INVALIDO + "null");
        }
        // Seleciona o método correspondente ao operador informado
        return switch (operador) {
            case "+" -> somar(a, b);
            case "-" -> subtrair(a, b);
            case "*" -> multiplicar(a, b);
            case "/" -> dividir(a, b);
            default -> throw new IllegalArgumentException(MENSAGEM_OPERADOR_INVALIDO + operador);
        };
    }
}
