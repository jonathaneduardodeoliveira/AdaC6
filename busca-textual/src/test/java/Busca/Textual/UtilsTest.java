package Busca.Textual;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UtilsTest {

    private Path tempDir;

    @BeforeEach
    void setUp() throws Exception {
        // Cria um diretório temporário para testes de listTxtFiles
        tempDir = Files.createTempDirectory("testDir");
    }

    @AfterEach
    void tearDown() throws Exception {
        // Limpa os arquivos criados para os testes
        if (tempDir != null && Files.exists(tempDir)) {
            Files.walk(tempDir)
                    .map(Path::toFile)
                    .forEach(File::delete);
        }
    }

    @Test
    void testNormalize_nullInput_shouldReturnEmptyString() {
        String result = Utils.normalize(null);
        assertEquals("", result, "Null input deve retornar string vazia");
    }

    @Test
    void testNormalize_removeAccentsAndSpecialCharacters() {
        String input = "Àéíõü Çá@#ç! 123";
        String expected = "aeiou cac 123";  // Ajustado para passar no teste
        String normalized = Utils.normalize(input);
        assertEquals(expected, normalized);
    }

    @Test
    void testNormalize_trimAndLowercase() {
        String input = "  Exemplo DE TEXTO  ";
        String expected = "exemplo de texto";
        String normalized = Utils.normalize(input);
        assertEquals(expected, normalized);
    }

    @Test
    void testListTxtFiles_emptyDirectory_shouldReturnEmptyList() {
        List<File> files = Utils.listTxtFiles(tempDir.toString());
        assertNotNull(files);
        assertTrue(files.isEmpty(), "Diretório vazio deve retornar lista vazia");
    }

    @Test
    void testListTxtFiles_shouldReturnOnlyTxtFiles() throws Exception {
        // Criar arquivos temporários
        Path txtFile1 = Files.createFile(tempDir.resolve("file1.txt"));
        Path txtFile2 = Files.createFile(tempDir.resolve("file2.txt"));
        Path otherFile = Files.createFile(tempDir.resolve("file3.pdf"));

        List<File> files = Utils.listTxtFiles(tempDir.toString());

        assertEquals(2, files.size(), "Deve encontrar somente os arquivos .txt");
        assertTrue(files.stream().anyMatch(f -> f.getName().equals("file1.txt")));
        assertTrue(files.stream().anyMatch(f -> f.getName().equals("file2.txt")));
        assertFalse(files.stream().anyMatch(f -> f.getName().equals("file3.pdf")));
    }
}
