package Busca.Textual;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a frase que deseja buscar:");
        String inputPhrase = scanner.nextLine();

        if (inputPhrase.isEmpty()) {
            System.out.println("Frase não pode ser vazia. Encerrando.");
            return;
        }

        String normalizedPhrase = Utils.normalize(inputPhrase);
        System.out.println("Frase buscada: \"" + inputPhrase + "\"");

        List<File> files = Utils.listTxtFiles("livros");

        if (files.isEmpty()) {
            System.out.println("Pasta 'livros' não encontrada ou está vazia.");
            return;
        }

        boolean found = buscarFraseNosArquivos(normalizedPhrase, files);

        if (!found) {
            System.out.println("----");
            System.out.println("Não encontrado.");
        }
    }

    public static boolean buscarFraseNosArquivos(String normalizedPhrase, List<File> files) {
        Trie trie = new Trie();
        trie.insert(normalizedPhrase);

        boolean found = false;

        for (File file : files) {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {

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
                        System.out.println("Arquivo: " + file.getName());
                        System.out.println("Linhas: " + lineNumber + "-" + (line2 != null ? line2Number : lineNumber));
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
