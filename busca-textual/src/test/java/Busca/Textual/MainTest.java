package Busca.Textual;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class MainTest {

    @TempDir
    File tempDir;

    // Testa se a Trie funciona inserindo e buscando
    @Test
    public void testTrieInsertSearch() {
        Trie trie = new Trie();
        trie.insert("teste");
        assertTrue(trie.search("teste"));
        assertFalse(trie.search("naoexiste"));
    }

    // Testa o método buscarFraseNosArquivos com arquivo que contém a frase
    @Test
    public void testBuscarFraseNosArquivos_FraseEncontrada() throws Exception {
        File tempFile = new File(tempDir, "arquivo1.txt");
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("linha de teste\nOutra linha qualquer\n");
        }

        List<File> arquivos = new ArrayList<>();
        arquivos.add(tempFile);

        String frase = Utils.normalize("linha de teste");

        boolean resultado = Main.buscarFraseNosArquivos(frase, arquivos);

        assertTrue(resultado);
    }

    // Testa com arquivo que não contém a frase
    @Test
    public void testBuscarFraseNosArquivos_FraseNaoEncontrada() throws Exception {
        File tempFile = new File(tempDir, "arquivo2.txt");
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("conteudo diferente\n");
        }

        List<File> arquivos = new ArrayList<>();
        arquivos.add(tempFile);

        String frase = Utils.normalize("frase inexistente");

        boolean resultado = Main.buscarFraseNosArquivos(frase, arquivos);

        assertFalse(resultado);
    }

    // Testa o Utils.normalize para garantir normalização correta (cobre if, else e regex)
    @Test
    public void testUtilsNormalize() {
        String input = "Áccéntéd Lêttérs! 123.";
        String esperado = "accented letters 123";
        assertEquals(esperado, Utils.normalize(input));
    }

    // Testa listTxtFiles com diretório vazio (cobre if files == null)
    @Test
    public void testListTxtFilesComDiretorioVazio() {
        List<File> arquivos = Utils.listTxtFiles(tempDir.getAbsolutePath());
        assertTrue(arquivos.isEmpty());
    }

    // Testa listTxtFiles com arquivos txt e outros (para cobertura)
    @Test
    public void testListTxtFilesComArquivos() throws Exception {
        File txtFile = new File(tempDir, "file1.txt");
        try (FileWriter writer = new FileWriter(txtFile)) {
            writer.write("teste");
        }

        File otherFile = new File(tempDir, "file2.jpg");
        try (FileWriter writer = new FileWriter(otherFile)) {
            writer.write("imagem");
        }

        List<File> arquivos = Utils.listTxtFiles(tempDir.getAbsolutePath());

        assertEquals(1, arquivos.size());
        assertEquals("file1.txt", arquivos.get(0).getName());
    }
}
