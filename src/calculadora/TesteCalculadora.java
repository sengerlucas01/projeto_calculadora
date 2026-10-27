package calculadora;

/**
 * <p><strong>Testes da classe {@link Calculadora}</strong></p>
 *
 * <p>Executa os testes unitários da calculadora e exibe, para cada caso,
 * a <em>entrada utilizada</em>, o <em>resultado esperado</em> e o
 * <em>resultado obtido</em>, seguido do status (PASSOU ou FALHOU).</p>
 *
 * <p>Casos cobertos: soma, subtração, multiplicação, divisão, divisão por zero,
 * operação inválida e operador nulo.</p>
 *
 * @author Lucas Senger Medeiros
 * @version 2.0
 */
public class TesteCalculadora {

    /** Quantidade total de testes executados. */
    private static int total = 0;

    /** Quantidade de testes que passaram. */
    private static int aprovados = 0;

    /**
     * Testa uma operação que deve retornar um valor.
     *
     * @param descricao nome do caso de teste
     * @param a         primeiro operando
     * @param b         segundo operando
     * @param operador  símbolo da operação
     * @param esperado  resultado esperado
     */
    private static void testarResultado(String descricao, int a, int b, String operador, int esperado) {
        Calculadora calc = new Calculadora();

        System.out.println("--- " + descricao);
        System.out.println("Entrada  : a=" + a + ", b=" + b + ", operador=" + operador);
        System.out.println("Esperado : " + esperado);

        int obtido = calc.calcular(a, b, operador);

        System.out.println("Obtido   : " + obtido);
        registrar(obtido == esperado);
    }

    /**
     * Testa uma operação que deve lançar {@link IllegalArgumentException}.
     *
     * @param descricao        nome do caso de teste
     * @param a                primeiro operando
     * @param b                segundo operando
     * @param operador         símbolo da operação
     * @param mensagemEsperada mensagem esperada na exceção
     */
    private static void testarExcecao(String descricao, int a, int b, String operador, String mensagemEsperada) {
        Calculadora calc = new Calculadora();

        System.out.println("--- " + descricao);
        System.out.println("Entrada  : a=" + a + ", b=" + b + ", operador=" + operador);
        System.out.println("Esperado : IllegalArgumentException(\"" + mensagemEsperada + "\")");

        boolean passou;
        try {
            int obtido = calc.calcular(a, b, operador);
            System.out.println("Obtido   : resultado " + obtido + " (nenhuma excecao lancada)");
            passou = false;
        } catch (IllegalArgumentException e) {
            System.out.println("Obtido   : IllegalArgumentException(\"" + e.getMessage() + "\")");
            passou = mensagemEsperada.equals(e.getMessage());
        }
        registrar(passou);
    }

    /**
     * Contabiliza o teste e imprime seu status.
     *
     * @param passou {@code true} se o teste passou; {@code false} caso contrário
     */
    private static void registrar(boolean passou) {
        total++;
        if (passou) {
            aprovados++;
            System.out.println("Status   : PASSOU");
        } else {
            System.out.println("Status   : FALHOU");
        }
        System.out.println();
    }

    /**
     * Ponto de entrada: executa todos os testes e imprime o resumo.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        System.out.println("=== TESTES DA CALCULADORA (versao refatorada) ===");
        System.out.println();

        testarResultado("Soma", 2, 3, "+", 5);
        testarResultado("Subtracao", 10, 4, "-", 6);
        testarResultado("Multiplicacao", 3, 5, "*", 15);
        testarResultado("Divisao", 8, 2, "/", 4);
        testarExcecao("Divisao por zero", 8, 0, "/", Calculadora.MENSAGEM_DIVISAO_POR_ZERO);
        testarExcecao("Operacao invalida", 5, 5, "x", Calculadora.MENSAGEM_OPERADOR_INVALIDO + "x");
        testarExcecao("Operador nulo", 5, 5, null, Calculadora.MENSAGEM_OPERADOR_INVALIDO + "null");

        System.out.println("=== RESUMO: " + aprovados + "/" + total + " testes aprovados ===");
    }
}
