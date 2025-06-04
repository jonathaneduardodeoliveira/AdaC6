package Busca.Textual;

import java.util.Map;

public class Trie {
    private final TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchFromNode(root, word);
    }

    private boolean searchFromNode(TrieNode node, String word) {
        TrieNode current = node;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (Map.Entry<Character, TrieNode> entry : current.children.entrySet()) {
                    if (searchFromNode(entry.getValue(), word.substring(i + 1))) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!current.children.containsKey(ch)) {
                    return false;
                }
                current = current.children.get(ch);
            }
        }
        return current.isEndOfWord;
    }

    public boolean searchInText(String text, String pattern) {
        int patternLength = pattern.length();
        for (int i = 0; i <= text.length() - patternLength; i++) {
            String substring = text.substring(i, i + patternLength);
            if (search(substring)) {
                return true;
            }
        }
        return false;
    }
}
