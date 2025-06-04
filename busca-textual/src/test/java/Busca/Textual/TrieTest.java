package Busca.Textual;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    private Trie trie;

    @BeforeEach
    void setUp() {
        trie = new Trie();
    }

    @Test
    void testInsertAndSearchExactWord() {
        trie.insert("java");
        assertTrue(trie.search("java"));
        assertFalse(trie.search("jav"));
        assertFalse(trie.search("javascript"));
    }

    @Test
    void testSearchWithWildcard() {
        trie.insert("java");
        assertTrue(trie.search("j.va"));  // Testa o coringa '.'
        assertFalse(trie.search("j.vaa"));
    }

    @Test
    void testSearchInTextFound() {
        trie.insert("code");
        String text = "I love to code everyday";
        assertTrue(trie.searchInText(text, "code"));
    }

    @Test
    void testSearchInTextNotFound() {
        trie.insert("python");
        String text = "I love to code in java";
        assertFalse(trie.searchInText(text, "python"));
    }

    @Test
    void testEmptyTrieSearch() {
        assertFalse(trie.search("anything"));
    }

    @Test
    void testEmptyStringInsertAndSearch() {
        trie.insert("");
        assertTrue(trie.search(""));  // Pode ser true se aceitar vazio
    }
}
