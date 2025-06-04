package Busca.Textual;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Por favor, insira a frase a ser buscada como argumento.");
            return;
        }

        String inputPhrase = args[0];
        String normalizedPhrase = Utils.normalize(inputPhrase);
        System.out.println("frase: \"" + inputPhrase + "\"");

        List<File> files = Utils.listTxtFiles("livros");

        boolean found = buscarFraseNosArquivos(normalizedPhrase, files);

        if (!found) {
            System.out.println("----");
            System.out.println("nao encontrado");
        }
    }

    // Método extraído para facilitar testes
    public static boolean buscarFraseNosArquivos(String normalizedPhrase, List<File> files) {
        Trie trie = new Trie();
        trie.insert(normalizedPhrase);

        boolean found = false;

        for (File file : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line1 = reader.readLine();
                int lineNumber = 1;

                while (line1 != null) {
                    String line2 = reader.readLine();
                    int line2Number = lineNumber + 1;

                    String normalizedLine1 = Utils.normalize(line1);
                    String normalizedLine2 = line2 != null ? Utils.normalize(line2) : "";

                    String combined = normalizedLine1;
                    if (!normalizedLine2.isEmpty()) {
                        combined += " " + normalizedLine2;
                    }
                    if (combined.length() > 400) {
                        combined = combined.substring(0, 400);
                    }

                    if (trie.searchInText(combined, normalizedPhrase)) {
                        System.out.println("----");
                        System.out.println("arquivo: " + file.getName());
                        System.out.println("linha: " + lineNumber + "-" + (line2 != null ? line2Number : lineNumber));
                        found = true;
                    }

                    line1 = line2;
                    lineNumber++;
                }

            } catch (IOException e) {
                System.err.println("Erro lendo o arquivo: " + file.getName());
            }
        }
        return found;
    }
}
