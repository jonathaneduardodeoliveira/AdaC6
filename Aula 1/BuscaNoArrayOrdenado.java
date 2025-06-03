public class BuscaNoArrayOrdenado {

    public static void main(String[] args) {
        int[] numeros = {-1, 0, 3, 5, 9, 12};
        int alvo1 = 9;
        int alvo2 = 2;

        BuscaNoArrayOrdenado busca = new BuscaNoArrayOrdenado();

        System.out.println("Resultado da busca para o alvo " + alvo1 + ": " + busca.buscarNumero(numeros, alvo1));
        System.out.println("Resultado da busca para o alvo " + alvo2 + ": " + busca.buscarNumero(numeros, alvo2));
    }

    public int buscarNumero(int[] numeros, int alvo) {
        int esquerda = 0;
        int direita = numeros.length - 1;

        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;

            if (numeros[meio] == alvo) {
                return meio;
            } else if (numeros[meio] < alvo) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        return -1;
    }
}
