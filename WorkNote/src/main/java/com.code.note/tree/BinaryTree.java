package com.code.note.tree;

import com.code.note.listnode.ListNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinaryTree<T extends Comparable> {
    private Node<T> root;

    public void put(T value) {
        root = put(root, value);
    }

    private Node<T> put(Node<T> x, T value) {
        if (x == null) {
            return new Node<>(value);
        }
        int cmp = value.compareTo(x.value);
        if (cmp < 0) {
            x.left = put(x.left, value);
        } else if (cmp > 0) {
            x.right = put(x.right, value);
        } else {
            return x;
        }

        return x;
    }

    public void print() {
        BTreePrinter.printNode(root);
    }

    public void traverse() {
        traverse(root);
    }

    public int count() {
        return count(root);
    }

    private int count(Node x) {
        if (x == null) {
            return 0;
        }
        return 1 + count(x.left) + count(x.right);
    }

    private void traverse(Node node) {
        // 前序遍历
        if (node == null) return;
        log.info("{}", node.value);
        traverse(node.left);
        // 中序遍历
        traverse(node.right);
        // 后序遍历
    }

    //反转二叉树
    public void reverse() {
        reverse(root);
    }

    private void reverse(Node x) {

        if (x == null) return;

        Node tmp = x.left;
        x.left = x.right;
        x.right = tmp;

        reverse(x.left);
        reverse(x.right);

    }

    // 树得深度
    public int getDepth() {
        return getDepth(root);
    }

    private int getDepth(Node x) {
        if (x == null) return 0;
        return 1 + Math.max(getDepth(x.left), getDepth(x.right));
    }

    public Node getRoot() {
        return root;
    }

    ListNode<Comparable> listNode = new ListNode<>();

    public ListNode toListNode() {

        toListNode(root);
        return listNode;
    }

    // 删除节点
    public void delete(T value) {

    }

    // 树转单链表
    private void toListNode(Node node) {
        // 前序遍历
        if (node == null) return;
        listNode.addToTail(node.value);

        toListNode(node.left);
        // 中序遍历
        toListNode(node.right);
        // 后序遍历
    }
}

