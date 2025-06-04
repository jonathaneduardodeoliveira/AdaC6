package Busca.Textual;

import java.io.File;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static String normalize(String text) {
        if (text == null) return "";

        text = text.toLowerCase();

        // Normaliza e remove acentos
        text = Normalizer.normalize(text, Normalizer.Form.NFD);
        text = text.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

        // Remove caracteres não alfanuméricos (exceto espaço)
        text = text.replaceAll("[^a-z0-9 ]", "");

        // Remove espaços extras e trim
        text = text.replaceAll("\\s+", " ").trim();

        return text;
    }

    public static List<File> listTxtFiles(String directoryPath) {
        File dir = new File(directoryPath);
        File[] files = dir.listFiles((d, name) -> name.endsWith(".txt"));
        List<File> result = new ArrayList<>();
        if (files != null) {
            for (File f : files) {
                result.add(f);
            }
        }
        return result;
    }
}
