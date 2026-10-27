package calculadora;

public class TesteCalculadora {

    private static int total = 0;
    private static int aprovados = 0;

    private static void testar(String descricao, int a, int b, String op, int esperado) {
        Calculadora calc = new Calculadora();

        System.out.println("--- " + descricao);
        System.out.println("Entrada  : a=" + a + ", b=" + b + ", op=" + op);
        System.out.println("Esperado : " + esperado);

        int obtido = calc.calc(a, b, op);

        System.out.println("Obtido   : " + obtido);

        total++;
        if (obtido == esperado) {
            aprovados++;
            System.out.println("Status   : PASSOU");
        } else {
            System.out.println("Status   : FALHOU");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== TESTES DA CALCULADORA (versao original) ===");
        System.out.println();

        testar("Soma", 2, 3, "+", 5);
        testar("Subtracao", 10, 4, "-", 6);
        testar("Multiplicacao", 3, 5, "*", 15);
        testar("Divisao", 8, 2, "/", 4);
        testar("Divisao por zero", 8, 0, "/", 0);
        testar("Operacao invalida", 5, 5, "x", 0);
        testar("Operador nulo", 5, 5, null, 0);

        System.out.println("=== RESUMO: " + aprovados + "/" + total + " testes aprovados ===");
    }
}
