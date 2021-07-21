package algorithmsAndDataStructures;

import java.util.NoSuchElementException;

public class MyTreeMap<K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        int height;
        K key;
        V value;
        Node left;
        Node right;
        int size;

        public Node(K key, V value, int size, int height) {
            this.key = key;
            this.value = value;
            this.size = size;
            this.height = height;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private void checkKeyNotNull(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key не должен быть null");
        }
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public V get(K key) {
        checkKeyNotNull(key);
        return get(root, key);
    }

    private V get(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    public void put(K key, V value) {
        checkKeyNotNull(key);
        if (value == null) {
            return;
        }
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value, 1, 0);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        node.size = 1 + size(node.left) + size(node.right);
        height(node);
        return node;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public K maxKey() {
        return max(root).key;
    }


    public K minKey() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = 1 + size(node.left) + size(node.right);
        height(node);
        return node;
    }

    public void delete(K key) {
        checkKeyNotNull(key);
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node temp = node;
            node = min(node.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.size = 1 + size(node.left) + size(node.right);
        height(node);
        return node;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            node.height = 0;
        } else if (node.left != null && node.right == null) {
            node.height = 1 + node.left.height;
        } else if (node.left == null) {
            node.height = 1 + node.right.height;
        } else if (node.left.height > node.right.height) {
            node.height = 1 + node.left.height;
        } else if (node.left.height < node.right.height) {
            node.height = 1 + node.right.height;
        } else {
            node.height = 1 + node.left.height;
        }
        return node.height;
    }

    public boolean isBalance() {
        if (root == null || root.size == 1) {
            return true;
        } else {
            int heightLeft;
            int heightRight;

            if (root.left == null) {
                heightLeft = 0;
            } else {
                heightLeft = root.left.height;
            }

            if (root.right == null) {
                heightRight = 0;
            } else {
                heightRight = root.right.height;
            }
            return Math.abs(heightLeft - heightRight) <= 1;
        }
    }

    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }
        return toString(node.left) + "[" + node.key + ", " + node.value + "]" +
                toString(node.right);
    }
}