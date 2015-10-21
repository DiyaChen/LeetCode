/*
LRU Cache

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/

public class LRUCache {
    
    public int capacity;
    public Map<Integer, Node> cach;
    public Node head;
    public Node tail;
    public Node dummy;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cach = new HashMap<Integer, Node>();
        dummy = new Node(-1, -1);
        head = dummy;
        tail = dummy;
    }
    
    public int get(int key) {
        if(!cach.containsKey(key)){
            return -1;
        }else{
            Node cur = cach.get(key);
            int result = cur.value;
            moveToTail(cur);
            return result;
        }
    }
    
    public void set(int key, int value) {
        if(cach.containsKey(key)){
            Node cur = cach.get(key);
            cur.value = value;
            moveToTail(cur);
        }else{
            Node cur = new Node(key, value);
            tail.next = cur;
            cur.pre = tail;
            tail = cur;
            head = dummy.next;
            cach.put(key, cur);
            if(cach.size() > capacity){
                cach.remove(head.key);
                removeHead();
            }
        }
    }
    
    private void moveToTail(Node cur){
        if(cur == tail) return;
        cur.pre.next = cur.next;
            if(cur.next != null){
                cur.next.pre = cur.pre;
            }
            tail.next = cur;
            cur.pre = tail;
            cur.next = null;
            tail = cur;
            head = dummy.next;
    }
    
    private void removeHead(){
        dummy.next = head.next;
        if(head.next != null){
            head.next.pre = dummy;
        }
        head.next = null;
        head.pre = null;
        head = dummy.next;
    }
}

class Node{
    public int key;
    public int value;
    public Node pre;
    public Node next;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}