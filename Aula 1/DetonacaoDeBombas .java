import java.util.ArrayList;
import java.util.List;

public class DetonacaoDeBombas {

    public int detonacaoMaxima(int[][] bombas) {
        int quantidade = bombas.length;
        List<List<Integer>> grafo = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            grafo.add(new ArrayList<>());
        }
        for (int i = 0; i < quantidade; i++) {
            for (int j = 0; j < quantidade; j++) {
                if (i != j && estaDentroDoAlcance(bombas[i], bombas[j])) {
                    grafo.get(i).add(j);
                }
            }
        }
        int maximoDetonado = 0;
        for (int i = 0; i < quantidade; i++) {
            boolean[] visitado = new boolean[quantidade];
            int detonadas = dfs(i, grafo, visitado);
            maximoDetonado = Math.max(maximoDetonado, detonadas);
        }
        return maximoDetonado;
    }

    private boolean estaDentroDoAlcance(int[] origem, int[] destino) {
        long distanciaX = origem[0] - destino[0];
        long distanciaY = origem[1] - destino[1];
        long distanciaQuadrado = distanciaX * distanciaX + distanciaY * distanciaY;
        long alcance = (long) origem[2] * origem[2];
        return distanciaQuadrado <= alcance;
    }

    private int dfs(int bomba, List<List<Integer>> grafo, boolean[] visitado) {
        visitado[bomba] = true;
        int contador = 1;
        for (int vizinha : grafo.get(bomba)) {
            if (!visitado[vizinha]) {
                contador += dfs(vizinha, grafo, visitado);
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        DetonacaoDeBombas solucao = new DetonacaoDeBombas();
        int[][] bombas1 = {{2, 1, 3}, {6, 1, 4}};
        System.out.println(solucao.detonacaoMaxima(bombas1));
        int[][] bombas2 = {{1, 1, 5}, {10, 10, 5}};
        System.out.println(solucao.detonacaoMaxima(bombas2));
        int[][] bombas3 = {{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}};
        System.out.println(solucao.detonacaoMaxima(bombas3));
    }
}
