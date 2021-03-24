class TrieNode{
    public TrieNode(){}
    Map<Character, TrieNode> children = new HashMap();
    boolean word = false;
}

class WordDictionary {
    TrieNode trie;
    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = trie;
        for(char ch : word.toCharArray()){
            if(!node.children.containsKey(ch)){
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.word = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchHelper(word, trie);
    }
    
    public boolean searchHelper(String word, TrieNode node){
       for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                if (ch == '.') {
                    for (char x : node.children.keySet()) {
                        TrieNode child = node.children.get(x);
                        if (searchHelper(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                node = node.children.get(ch);
            }
        }
        return node.word;

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */