package com.njustxz.Tree;

import java.util.LinkedList;

/**
 * 使用三叉链表创建二叉树
 */
public class BinaryTree {
    private BinaryTreeNode root;        //二叉树的根节点

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }
    //返回元素的个数
    public int getSize(){
        if(root == null){
            return 0;   //空树
        }
        return root.getSize();
    }
    //判断二叉树是否为空
    public boolean isEmpty(){
        return getSize() ==0;
    }
    //返回根节点
    public BinaryTreeNode getRoot(){
        if(root !=null){
            return root;
        }else return null;
    }
    //返回树的高度
    public int getHeight(){
        if(root==null){
            return 0;
        }
        return root.getHeight();
    }

    /*******************二叉树先根序遍历**************/
    private void preOrderRecusion(BinaryTreeNode root, LinkedList<Object> list){
        if(root==null){
            return;
        }
        //先把根节点数据存在链表中
        list.add(root.getData());
        //先序遍历左子树
        preOrderRecusion(root.getLChild(),list);
        //先序遍历右子树
        preOrderRecusion(root.getRChild(),list);
    }
    //打印当前二叉树的先序遍历序列
    public void preOrder(){
        LinkedList<Object> list = new LinkedList<>();
        preOrderRecusion(root,list);
        System.out.println(list);
    }

    /*******************二叉树中根序遍历**************/
    private void inOrderRecusion(BinaryTreeNode root, LinkedList<Object> list){
        if(root==null){
            return;
        }

        //中序遍历左子树
        inOrderRecusion(root.getLChild(),list);
        //再把根节点数据存在链表中
        list.add(root.getData());
        //中序遍历右子树
        inOrderRecusion(root.getRChild(),list);
    }
    //打印当前二叉树的中序遍历序列
    public void inOrder(){
        LinkedList<Object> list = new LinkedList<>();
        inOrderRecusion(root,list);
        System.out.println(list);
    }
    /*******************二叉树后根序遍历**************/
    private void postOrderRecusion(BinaryTreeNode root, LinkedList<Object> list){
        if(root==null){
            return;
        }

        //中序遍历左子树
        postOrderRecusion(root.getLChild(),list);
        //中序遍历右子树
        postOrderRecusion(root.getRChild(),list);
        //最后把根节点数据存在链表中
        list.add(root.getData());
    }

    //打印当前二叉树的后序遍历序列
    public void postOrder(){
        LinkedList<Object> list = new LinkedList<>();
        postOrderRecusion(root,list);
        System.out.println(list);
    }

    private void levelOrderTranverse(BinaryTreeNode root,LinkedList<Object> list){
        if(root==null){
            return;
        }
        //定义一个队列
        LinkedList<BinaryTreeNode> queue =new LinkedList<>();
        queue.offer(root);//入队
        while(!queue.isEmpty()){
            //把队列头部节点取出
            BinaryTreeNode node = queue.poll();//出队
            list.add(node.getData());
            if(node.hasLChild()){
                queue.offer(node.getLChild());
            }
            if(node.hasRChild()){
                queue.offer(node.getRChild());
            }
        }
     }

     public void levelOrder(){
        LinkedList<Object> linkedList = new LinkedList<>();
        levelOrderTranverse(root,linkedList);
         System.out.println(linkedList);
     }
}
