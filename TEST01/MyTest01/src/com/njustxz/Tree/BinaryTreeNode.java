package com.njustxz.Tree;

/**
 * 三叉链表的实现
 */
public class BinaryTreeNode {
    private Object data;  //数据
    private BinaryTreeNode parent;  //父节点
    private BinaryTreeNode lChild;  //左孩子
    private BinaryTreeNode rChild;  //右孩子
    private int height;     //以当前节点为根节点的二叉树的高度
    private int size;       //以当前节点为根节点的二叉树所有节点的数量

    /*********构造方法**************/
    //跟据指定的数据创建一个结点
    public BinaryTreeNode(Object e) {
        data = e;
        parent = null;
        lChild = null;
        rChild = null;
        height = 1;
        size = 1;
    }

    public Object getData() {
        return data;
    }

    public BinaryTreeNode() {
        this(null);
    }

    /*******判断节点的情况********/
    //判断是否有父节点
    public boolean hasParent() {
        return parent != null;
    }

    //判断是否有左孩节点
    public boolean hasLChild() {
        return lChild != null;
    }

    //判断是否有右孩节点
    public boolean hasRChild() {
        return rChild != null;
    }

    //判断是否有叶子节点
    public boolean isLeaf() {
        return rChild == null && lChild == null;
    }

    //判断是否为父节点的左孩子
    public boolean isLChild() {
        return parent != null && parent.lChild == this;
    }

    //判断是否为父节点的右孩子
    public boolean isRChild() {
        return parent != null && parent.rChild == this;
    }

    /**********高度相关的操作***************/
    public int getHeight() {
        return height;
    }

    //更新当前节点的高度，以及祖先节点的高度
    public void updateHeight() {
        int newHeight = 0;      //保存新的高度
        //当前节点的高度为其左右子树高度较大的加一
        if (lChild != null) {
            newHeight = Math.max(newHeight, getLChild().height + 1);
        }
        if (rChild != null) {
            newHeight = Math.max(newHeight, getRChild().height + 1);
        }
        if (newHeight == height) {
            return;
        }
        height=newHeight;
        //如果当前节点高度有变化，递归更新祖先节点的高度
        if (hasParent()) {
            getParent().updateHeight();
        }
    }

    /***********与size节点个数相关的操作**************/
    //返回以当前节点为根的的二叉树的节点数
    public int getSize() {
        return size;
    }

    //更新当前节点及其祖先节点的结点
    public void updateSize() {
        size = 1;       //当前节点本身
        //累加左子树和右子树节点
        if (hasRChild()) {
            size += getRChild().getSize();
        }
        if (hasLChild()) {
            size += getLChild().getSize();
        }
        //祖先节点也需要计算
        if (hasParent()) {
            getParent().updateSize();
        }
    }

    /*********与父节点相关的操作***********/
    //返回父节点
    public BinaryTreeNode getParent() {
        return parent;
    }

    //断开父节点的操作
    public void disInHerITence() {
        if (!hasParent()) {
            return;
        }
        //假设其为父节点的左孩子
        if (isLChild()) {
            parent.lChild = null;
        } else if (isRChild()) {
            parent.rChild = null;
        }
        //跟新父节点的节点数，高度
        parent.updateSize();
        parent.updateHeight();
        parent = null;
    }

    /*******************与左孩子相关的操作*****************************/
    //返回左孩p子和父节点
    public BinaryTreeNode getLChild() {
        return lChild;
    }

    //设置当前节点为左孩子，将之前的左孩子返回
    public BinaryTreeNode setLChild(BinaryTreeNode newLChild) {
        BinaryTreeNode oldLChild = this.lChild;
        //先断开当前节点的左孩子
        if (hasLChild()) {
            lChild.disInHerITence();
        }
        //设置新的左孩子参数
        if (newLChild != null) {
            newLChild.disInHerITence();//先断开参数节点与父节点父节点的关系
            this.lChild = newLChild;
            newLChild.parent = this;
            this.updateHeight();
            this.updateSize();
        }
        return oldLChild;
    }

    /*******************与右孩子相关的操作*****************************/
    //返回右孩p子和父节点
    public BinaryTreeNode getRChild() {
        return rChild;
    }

    //设置当前节点为右孩子，将之前右孩子返回
    public BinaryTreeNode setRChild(BinaryTreeNode newRChild) {
        BinaryTreeNode oldRChild = this.rChild;
        //先断开当前节点的右孩子
        if (hasRChild()) {
            rChild.disInHerITence();
        }
        //设置新的左孩子参数
        if (newRChild != null) {
            newRChild.disInHerITence();//先断开参数节点与父节点父节点的关系
            this.rChild = newRChild;
            newRChild.parent = this;
            this.updateHeight();
            this.updateSize();
        }
        return oldRChild;
    }
}
