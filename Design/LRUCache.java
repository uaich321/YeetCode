package Design;

/*
    Subtopics: Linked List, HashMap

    To solve this problem, we need to use a combination of a doubly linked list and a hash map.

    The most important thing to do to avoid the various edge cases that come with
    doubly linked lists is to create a dummy node at the beginning and end of the list.

    The hash map will be used to store the key and the node that contains the key and value,
    so that we can access the node in constant time.

    Get and Put should be easy to follow based on how they were described in the problem statement.

    Note that I made two helper functions, removeNode and addToHead, to avoid code repetition and make the code more concise.

    Also, a friendly reminder that to move a node, you have to first remove the node then add it to the head. 
    Luckily, this is easy to do with the helper functions.
*/

import java.util.HashMap;
public class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
        }
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }
    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    HashMap<Integer, Node> map = new HashMap<>();
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        removeNode(node);  
        addToHead(node);    
        return node.value;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            addToHead(node);
            map.put(key, node);

            if (map.size() > capacity) {
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }
        }
    }
}
