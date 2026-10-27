package calculadora;

public class Calculadora {

    public static final String MENSAGEM_DIVISAO_POR_ZERO = "Divisão por zero não é permitida.";
    public static final String MENSAGEM_OPERADOR_INVALIDO = "Operador inválido: ";

    public int somar(int a, int b) {
        return a + b;
    }

    public int subtrair(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public int dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException(MENSAGEM_DIVISAO_POR_ZERO);
        }
        return a / b;
    }

    public int calcular(int a, int b, String operador) {
        if (operador == null) {
            throw new IllegalArgumentException(MENSAGEM_OPERADOR_INVALIDO + "null");
        }
        return switch (operador) {
            case "+" -> somar(a, b);
            case "-" -> subtrair(a, b);
            case "*" -> multiplicar(a, b);
            case "/" -> dividir(a, b);
            default -> throw new IllegalArgumentException(MENSAGEM_OPERADOR_INVALIDO + operador);
        };
    }
}
