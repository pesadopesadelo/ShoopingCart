package processamento;

import java.util.ArrayList;

public class ProcessamentoCompra {  

    private static final int VALOR_MACA = 60;    // price in pence
    private static final int VALOR_LARANJA = 25; // price in pence

    public static int calcularValorFinal(ArrayList<String> produtos) {
        int valorFinal = 0;
        int contadorMaca = 0;
        int contadorLaranja = 0;

        for (String produto : produtos) {
            String produtoLower = produto.toLowerCase();
            if (produtoLower.equals("apple")) {
                contadorMaca++;
                valorFinal += VALOR_MACA;
            } else if (produtoLower.equals("orange")) {
                contadorLaranja++;
                valorFinal += VALOR_LARANJA;
            } else {
                throw new RuntimeException("Unknown item: " + produto);
            }
        }

        return valorFinal;
    }

    public static String formatarValor(int pence) {
        return String.format("£%.2f", pence / 100.0);
    }

    public static void executar() {
        ArrayList<String> carrinho = new ArrayList<>();
        carrinho.add("Apple");
        carrinho.add("Apple");
        carrinho.add("Orange");
        carrinho.add("Apple");
        
        int total = calcularValorFinal(carrinho);
        System.out.println("Total: " + formatarValor(total)); // Expected: £2.05
    }

    public static void main(String[] parametros) {
        executar();
    }
}