package Busca.Textual;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrieNodeTest {

    @Test
    void testTrieNodeConstructor() {
        TrieNode node = new TrieNode();
        assertNotNull(node);
        assertNotNull(node.children);
        assertTrue(node.children.isEmpty());
        assertFalse(node.isEndOfWord);
    }

    @Test
    void testAddChildNode() {
        TrieNode node = new TrieNode();
        node.children.put('a', new TrieNode());

        assertTrue(node.children.containsKey('a'));
        assertNotNull(node.children.get('a'));
    }

    @Test
    void testSetIsEndOfWord() {
        TrieNode node = new TrieNode();
        node.isEndOfWord = true;

        assertTrue(node.isEndOfWord);
    }
}
