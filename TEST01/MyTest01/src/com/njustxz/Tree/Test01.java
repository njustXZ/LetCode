package com.njustxz.Tree;

/**
 * 测试二叉树的遍历序列
 */
public class Test01 {
    public static void main(String[] args) {
//        创建根节点
        BinaryTreeNode nodeA = new BinaryTreeNode("A");
        BinaryTreeNode nodeB = new BinaryTreeNode("B");
        BinaryTreeNode nodeC = new BinaryTreeNode("C");
        BinaryTreeNode nodeD = new BinaryTreeNode("D");
        BinaryTreeNode nodeE = new BinaryTreeNode("E");
        BinaryTreeNode nodeF = new BinaryTreeNode("F");
        BinaryTreeNode nodeG = new BinaryTreeNode("G");
        BinaryTreeNode nodeH = new BinaryTreeNode("H");
        BinaryTreeNode nodeI = new BinaryTreeNode("I");
        BinaryTreeNode nodeJ = new BinaryTreeNode("J");

        nodeA.setLChild(nodeB);
        nodeA.setRChild(nodeC);

        nodeB.setLChild(nodeD);
        nodeB.setRChild(nodeE);

        nodeC.setLChild(nodeF);
        nodeC.setRChild(nodeG);

        nodeD.setLChild(nodeH);
        nodeD.setRChild(nodeI);

        nodeE.setLChild(nodeJ);

//        创建二叉树
        BinaryTree tree =new BinaryTree(nodeA);

        System.out.println(tree.getHeight());
        System.out.println(tree.getSize());
        tree.preOrder();
        tree.inOrder();
        tree.postOrder();
        tree.levelOrder();
    }
}
