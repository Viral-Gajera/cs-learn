# Tries

A trie (derived from retrieval) is a multiway tree data structure used for storing strings over an alphabet. 
It is used to store a large amount of strings. The pattern matching can be done efficiently using tries.
- Search time complexity : `O(L)`.
- Root is an empty node.
- Same prefix of word is not repeated.

<img src="Trie 1.jpg">

<img src="Trie 2.jpg">

## Implementation

```java
class Tries {
    static class Node {
        Node[] children = new Node[26];
        boolean eow;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) { // O(n)
        int len = word.length();
        int idx = 0;

        Node curr = root;

        for (int i = 0; i < len; i++) {
            idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String key) { // O(n)
        int len = key.length();
        int idx = 0;

        Node curr = root;
        for (int i = 0; i < len; i++) {
            idx = key.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    public static void main(String args[]) {
        String words[] = { "the", "a", "there", "their", "any", "thee" };
        for (String word : words) {
            insert(word);
            System.out.println("inserted " + word);
        }
        
        System.out.println("thee -> " + search("thee"));
        System.out.println("thor -> " + search("thor"));
    }
}
```



# Compressed Trie
- A compressed trie is a standard trie in which each and every node has atleast two children. (except leaf node).

**Converting Standard Trie to Compressed Trie**

- Merge child node with parent node, if parent node that only one child.

<img src="Compressed Trie.jpg">


# Ternary Search Trees

<img src="Ternary Search Trees 1.jpg">

<img src="Ternary Search Trees 2.jpg">

<img src="Ternary Search Trees 3.jpg">



# Suffix Tree

Step:
1. Create all the suffix of given text
2. Create Compress trie from that all suffix.