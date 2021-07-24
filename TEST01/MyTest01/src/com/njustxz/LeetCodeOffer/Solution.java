package com.njustxz.LeetCodeOffer;

import jdk.nashorn.api.tree.ForInLoopTree;

import java.util.*;
import java.util.jar.JarEntry;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    //3.数组中重复的数字
    public int findRepeatNumber(int[] nums) {
        /*int n = nums.length;
        int sums[] = new int[n];
        Arrays.fill(sums,0);
        for(int i = 0;i<n;i++){
            sums[nums[i]]++;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if(sums[i]>1) {
                ret = i;
                break;
            }
        }
        return  ret;*/
        //优化
        int n = nums.length;
        int[] sums = new int[n];
        Arrays.fill(sums, 0);
        int ret = 0;
        for (int i = 0; i < n; i++) {
            sums[nums[i]]++;
            if (sums[nums[i]] > 1) {
                ret = nums[i];
                break;
            }
        }
        return ret;
    }

    //4.二维数组中的查找
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        //暴力求解
        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }*/
        //每一行使用二分查找
        /*for (int i = 0; i < m; i++) {
            if(matrix[i][0] > target) break;
            if(matrix[i][n-1] < target) continue;
            int st = 0,ed = n-1,mid = 0;
            while(st<=ed){
                mid = (st + ed)/2;
                if(matrix[i][mid] == target){
                    return true;
                }
                if(matrix[i][mid] < target){
                    st = mid+1 ;
                }else{
                    ed = mid-1 ;
                }
            }
        }*/
        //将二维数组旋转，左边变小，右边变大,需要注意终止的条件
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    //5.空格替换
    public String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            Character c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    //6.从未到头打印链表
    public int[] reversePrint(ListNode head) {
        //1.使用堆栈
        /*int[] ret = new int[0];
        if (head == null) return ret;
        Stack<Integer> numsStk = new Stack<>();
        ListNode p = head;
        int sum = 0;
        while (p != null) {
            numsStk.push(p.val);
            sum++;
            p = p.next;
        }
        ret = new int[sum];
        for (int i = 0; i < sum; i++) {
            int tmp = numsStk.pop();
            ret[i] = tmp;
        }
        return ret;*/
        //2.使用数组，先计数，再把数值反过来放
        ListNode p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        int[] ret = new int[count];
        p = head;
        for (int i = count - 1; i >= 0; i--) {
            ret[i] = p.val;
            p = p.next;
        }
        return ret;
    }

    //7.重建二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Arrays.copyOfRange（）函数的使用
        int n = preorder.length;
        if (n == 0) return null;
        int val = preorder[0];
        int m = 0;
        for (m = 0; m < n; m++) {
            if (inorder[m] == val) {
                break;
            }
        }
        TreeNode head = new TreeNode(val);
        head.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + m), Arrays.copyOfRange(inorder, 0, m));
        head.right = buildTree(Arrays.copyOfRange(preorder, m + 1, n), Arrays.copyOfRange(inorder, m + 1, n));
        return head;
    }

    //9.两个栈实现队列
    //见class CQueue

    //10.斐波那契数列
    public int fib(int n) {
        double[] fib = new double[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        int ret = (int) fib[n] % (1000000007);

        return ret;
    }

    //11.旋转数组的最小数字
    public int minArray(int[] numbers) {
        /*if(numbers.length == 1) return numbers[0];
        int st=0,ed=numbers.length-1;
        int ret = numbers[0];
        while(st<=ed){
            if(numbers[st]>numbers[st+1]) ret = numbers[st+1];
            if(numbers[ed-1]>numbers[ed]) ret = numbers[ed];
            st++;
            ed--;
        }
        return ret;*/
//        二分法,需要注意 3 3 3 1 3 和3 1 3 3 3的这种情况
        //只和high位的比较
        int st = 0, ed = numbers.length - 1;
        int mid;
        while (st < ed) {
            mid = (st + ed) / 2;
            if (numbers[st] < numbers[mid]) {
                st = mid + 1;
            } else if (numbers[ed] > numbers[mid]) {
                ed = mid;
            } else {
                ed = ed - 1;
            }
        }
        return numbers[st];
    }

    //12.矩阵中的路径
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0) return false;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (findWay(board, word, i, j, m, n, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean findWay(char[][] border, String word, int i, int j, int m, int n, int k) {
        border[i][j] = '\0';
        k = k + 1;
        if (k >= word.length()) return true;
        if (i > 0 && border[i - 1][j] == word.charAt(k) && findWay(border, word, i - 1, j, m, n, k)) {
            border[i][j] = word.charAt(k - 1);
            return true;
        }
        if (i < m - 1 && border[i + 1][j] == word.charAt(k) && findWay(border, word, i + 1, j, m, n, k)) {
            border[i][j] = word.charAt(k - 1);
            return true;
        }
        if (j > 0 && border[i][j - 1] == word.charAt(k) && findWay(border, word, i, j - 1, m, n, k)) {
            border[i][j] = word.charAt(k - 1);
            return true;
        }
        if (j < n - 1 && border[i][j + 1] == word.charAt(k) && findWay(border, word, i, j + 1, m, n, k)) {
            border[i][j] = word.charAt(k - 1);
            return true;
        }
        border[i][j] = word.charAt(k - 1);
        return false;
    }

    //螺旋矩阵
    public List<Integer> spiralOrder(int[][] matrix) {
        int up = 0, down = matrix.length - 1;
        if (down == 0) return null;
        List<Integer> numList = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1;
        int row = 0, col = 0;
        while (up <= down && left <= right) {
            if (row == up && col == left) {
                for (; col <= right; col++) {
                    numList.add(matrix[col][row]);
                }
                up++;
                row = up;
            }
            if (row == up && col == right) {
                for (; row <= down; row++) {
                    numList.add(matrix[col][row]);
                }
                right--;
                col = right;
            }
            if (row == down && col == right) {
                for (; col >= left; col--) {
                    numList.add(matrix[col][row]);
                }
                down--;
                row = down;
            }
            if (row == down && col == left) {
                for (; row >= up; row--) {
                    numList.add(matrix[col][row]);
                }
                left++;
                col = left;
            }
        }
        return numList;
    }

    //螺旋矩阵2
    public int[][] generateMatrix(int n) {
        if (n < 1) return null;
        int[][] ret = new int[n][n];
        int m = 1;
        int up = 0, down = n - 1;
        int left = 0, right = n - 1;
        int i = 0, j = 0;
        while (m < (n * n + 1)) {
            if (i == up && j == left) {
                for (; j <= right; j++) {
                    ret[i][j] = m;
                    m++;
                }
                up++;
                i++;
                j--;
            } else if (i == up && j == right) {
                for (; i <= down; i++) {
                    ret[i][j] = m;
                    m++;
                }
                right--;
                i--;
                j--;
            } else if (i == down && j == right) {
                for (; j >= left; j--) {
                    ret[i][j] = m;
                    m++;
                }
                down--;
                i--;
                j++;
            } else {

                for (; i >= up; i--) {
                    ret[i][j] = m;
                    m++;
                }
                left++;
                j++;
                i++;

            }
        }
        return ret;
    }

    //13.机器人的运动范围
    public int movingCount(int m, int n, int k) {
        if (m == 0 || n == 0) return 0;
        int[][] marks = new int[m][n];
        int count = 0;
        marks[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (test1(i, j, k) && marks[i][j] == 1) {
                    count++;
                    if (i + 1 < m && marks[i + 1][j] == 0) {
                        marks[i + 1][j] = 1;
                    }
                    if (j + 1 < n && marks[i][j + 1] == 0) {
                        marks[i][j + 1] = 1;
                    }
                }
            }
        }
        return count;
    }

    public static boolean test1(int a, int b, int k) {
        int count = 0;
        for (int i = a; i > 0; i /= 10) {
            count += i % 10;
        }
        for (int i = b; i > 0; i /= 10) {
            count += i % 10;
        }
        return count <= k;
    }

    //14- | 剪绳子
    public int cuttingRope(int n) {
        //找规律，数字大于6之后，为它前面第三位乘3
        /*if(n<=3) return n-1;
        int[] ans = new int[58];
        ans[4]=4;ans[5]=6;ans[6] = 9;
        if(n<7) return ans[n];
        for(int i = 7;i<n+1;i++){
            ans[i] = 3*ans[i-3];
        }
        return ans[n];*/
        //贪心算法 尽可能多的有3 当小于四之后，直接乘起来
        if (n <= 3) return n - 1;
        int ret = 1;
        while (n > 4) {
            n = n - 3;
            ret *= 3;
        }
        return ret * n;
        //动态规划

    }

    //15.二进制中1的个数
    public int hammingWeight(int n) {
        //暴力法
        /*
        int count = 0;
        if(n<0){
            count++;
            n = -n;
            n = n^0x7FFFFFFF;
        }
        for(int i = n;i>0;i/=2){
            if(i%2 ==1) count++;
        }
        return count;*/
        //n&(n-1)会使最右边的1变为零
        int ans = 0;
        while (n != 0) {
            n = n & (n - 1);
            ans++;
        }
        return ans;
    }

    //16.数值的整数次方
    public double myPow(double x, int n) {
        //栈溢出错误
        /*
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n > 1) {
            return myPow(x, n - 1) * x;
        }
        return myPow(x, n + 1) / x;
         */
        //x*x 来降低循环次数
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if (b % 2 == 1) res = res * x;
            x = x * x;
            b = b / 2;
        }
        return res;
    }

    //17.打印从1到最大的n位数
    public int[] printNumbers(int n) {
        int m = 1;
        for (int i = 0; i < n; i++) {
            m *= 10;
        }
        int[] ret = new int[m - 1];
        for (int i = 0; i < m - 1; i++) {
            ret[i] = i + 1;
        }
        return ret;
    }

    //18.删除链表的结点
    public ListNode deleteNode(ListNode head, int val) {
        //简单做法
        /* ListNode p = head;
        if(p.val ==val){
            head =head.next;
            return head;
        }
        while ( p.next != null) {
            if(p.next.val == val){
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
        return head;*/
        if (head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) pre.next = cur.next;
        return head;
    }

    //19.正则表达式匹配
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (p.charAt(j - 1) != '*') {
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[m][n];
    }

    //20.表示数值的字符串
    public boolean isNumber(String s) {
        //signFlag,pointFlag
        int n = s.length();
        if (n == 0) return false;
        boolean signFlag = false, pointFlag = false, eFlag = false;
        char[] nums = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (nums[i] == '-' || nums[i] == '+') {
                if (signFlag || i == n - 1) return false;
                signFlag = true;
            } else if (nums[i] == '.') {
                if (pointFlag || i == 0 || nums[i - 1] > '9' || nums[i - 1] < '0' || i == n - 1) {
                    return false;
                }
                pointFlag = true;
            } else if (nums[i] == 'e' || nums[i] == 'E') {
                if (eFlag || i == 0 || nums[i - 1] > '9' || nums[i - 1] < '0' || i == n - 1) {
                    return false;
                }
                eFlag = true;
                pointFlag = true;
                signFlag = false;
            } else if (nums[i] <= '9' || nums[i] >= '0') {
                signFlag = true;
            } else return false;
        }
        return true;
    }

    //21.调整数组顺序，使得奇数位于偶数前面
    public int[] exchange(int[] nums) {
        //前后指针
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 1) {
                left++;
                continue;
            }
            if (nums[right] % 2 == 0) {
                right--;
                continue;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
        //快慢指针
        /*if (nums == null || nums.length < 2) return nums;
        int late = 0, pre = 0;
        int n = nums.length;
        while (late < n && pre < n) {
            while (pre < n && nums[pre] % 2 == 1) {
                pre++;
            }
            late = pre + 1;
            while (late < n && nums[late] % 2 == 0) {
                late++;
            }
            if(late<n && pre<n){
                int temp = nums[late];
                nums[late] =nums[pre];
                nums[pre] = temp;
            }
            pre++;
        }
        return nums;*/
    }

    //22.链表中的倒数第k个节点

    //不同的子序列
    public int numDistinct(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int m = s1.length, n = t1.length;
        if (m < n) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            char cTemp = s1[m];
            for (int j = n - 1; j >= 0; j--) {
                if (t1[j] == cTemp) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

    //23.反转链表
    public ListNode reverseList(ListNode head) {
        //使用栈实现
        /*Stack<Integer> listNodes = new Stack<>();
        if(head==null) return null;
        ListNode p = head;
        while(p!=null){
            listNodes.push(p.val);
            p=p.next;
        }
        ListNode p2 = new ListNode(listNodes.pop());
        ListNode pHead = p2;
        while (listNodes.empty()){
            pHead.next = new ListNode(listNodes.pop());
            pHead = pHead.next;
        }
        pHead.next = null;
        return p2;*/
        //使用递归实现
        ListNode cur = head;
        return reverse(null, cur);
    }

    public ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;
        return reverse(pre, cur);
    }

    //反转链表2
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head == null) return head;
        Stack<ListNode> st1 = new Stack<>();
        int index = 1;
        ListNode pNode = head;
        while (index <= right) {
            if (pNode == null) {
                return null;
            }
            if (index < left) {
                pNode = pNode.next;
                index++;
                continue;
            }
            st1.push(pNode);
            pNode = pNode.next;
            index++;
        }
        index = 1;
        ListNode qNode = new ListNode(-1);
        ListNode ret = qNode;
        for (; index < left; index++) {
            qNode.next = head;
            head = head.next;
            qNode = qNode.next;
        }
        for (; index <= right; index++) {
            qNode.next = st1.pop();
            qNode = qNode.next;
        }
        qNode.next = pNode;
        return ret.next;
    }

    //24.合并两个排好序的链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(-1);
        ListNode p1 = p;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p1.next = l1;
                l1 = l1.next;
            } else {
                p1.next = l2;
                l2 = l2.next;
            }
            p1 = p1.next;
        }
        if (l1 == null) {
            p1.next = l2;
        } else {
            p1.next = l1;
        }
        return p.next;
    }

    //26.树的子结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        if (A.val == B.val) {
            if (equals(A, B)) {
                return true;
            }
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    public boolean equals(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return equals(A.left, B.left) && equals(A.right, B.right);
    }

    //27.二叉树的镜像
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }

    //28.对称的二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return Symmetric(root.left, root.right);
    }

    public boolean Symmetric(TreeNode lRoot, TreeNode rRoot) {
        if (lRoot == null && rRoot == null) return true;
        if (lRoot == null || rRoot == null || lRoot.val != rRoot.val) return false;
        return Symmetric(lRoot.left, rRoot.right) && Symmetric(lRoot.right, rRoot.left);
    }

    //29.顺时针打印矩阵
    public int[] spiralOrder1(int[][] matrix) {
        int up = 0, down = matrix.length - 1;
        if (down == 0 || matrix == null) return null;
        int left = 0, right = matrix[0].length - 1;
        int[] numList = new int[(down + 1) * (right + 1)];
        int row = 0, col = 0, index = 0;
        while (up <= down && left <= right) {
            if (row == up && col == left) {
                for (; col <= right; col++) {
                    numList[index] = matrix[row][col];
                    index++;
                }
                up++;
                row = up;
                col--;
            } else if (row == up && col == right) {
                for (; row <= down; row++) {
                    numList[index] = matrix[row][col];
                    index++;
                }
                right--;
                col = right;
                row--;
            } else if (row == down && col == right) {
                for (; col >= left; col--) {
                    numList[index] = matrix[row][col];
                    index++;
                }
                down--;
                row = down;
                col++;
            } else {
                for (; row >= up; row--) {
                    numList[index] = matrix[row][col];
                    index++;
                }
                left++;
                col = left;
                row++;
            }
        }
        return numList;
    }

    //30.包含min函数的栈 见class MinStack

    //31.栈的压入、弹出顺序
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) return false;
        Stack<Integer> nums = new Stack<>();
        int m = pushed.length, n = popped.length, k = 0;
        if (m != n) return false;
        for (int value : popped) {
            if (!nums.empty() && nums.peek() == value) {
                nums.pop();
                continue;
            }
            while (k < n && pushed[k] != value) {
                nums.push(pushed[k]);
                k++;
            }
            if (k < n && pushed[k] == value) {
                k++;
                continue;
            }
            return false;
        }
        return true;
    }

    //32-1 从上到下从左到右打印二叉树
    public int[] levelOrder(TreeNode root) {
        //自己的思路：多重链表，每一层一个链表，再使用前序遍历
        //队列
        if (root == null) return new int[0];
        Queue<TreeNode> roots = new ArrayDeque<>();
        roots.add(root);
        List<Integer> nums = new ArrayList<>();
        while (!roots.isEmpty()) {
            TreeNode tmp = roots.remove();
            if (tmp.left != null) {
                roots.add(tmp.left);
            }
            if (tmp.right != null) {
                roots.add(tmp.right);
            }
            nums.add(tmp.val);
        }
        int n = nums.size();
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nums.get(i);
        }
        return ret;
    }

    //32-2 从上到下打印二叉树，分层
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return null;
        int depth = 0;
        List<List<Integer>> ret = new ArrayList<>();
        addNumsList(root, 0, ret);
        return ret;
    }

    public void addNumsList(TreeNode root, int depth, List<List<Integer>> lists) {
        if (root == null) return;
        if (lists.size() <= depth) {
            List<Integer> tmp = new ArrayList<>();
            lists.add(tmp);
        }
        lists.get(depth).add(root.val);
        addNumsList(root.left, depth + 1, lists);
        addNumsList(root.right, depth + 1, lists);
    }

    //32-3 从上到下打印二叉树，分层，之字形
    public List<List<Integer>> levelOrder3(TreeNode root) {
        int depth = 0;
        List<List<Integer>> ret = new ArrayList<>();
        addNumsList2(root, 0, ret);
        return ret;
    }

    public void addNumsList2(TreeNode root, int depth, List<List<Integer>> lists) {
        if (root == null) return;
        if (lists.size() <= depth) {
            List<Integer> tmp = new ArrayList<>();
            lists.add(tmp);
        }
        if (depth % 2 == 0) {
            lists.get(depth).add(root.val);
        } else {
            lists.get(depth).add(0, root.val);
        }
        addNumsList2(root.left, depth + 1, lists);
        addNumsList2(root.right, depth + 1, lists);
    }

    //33.二叉搜索树的后序遍历
    //二叉搜索树，中序遍历是顺序排列
    public boolean verifyPostorder(int[] postorder) {
        //想法：先排序，将中序得出
        //利用中序和判断是否为二叉搜索树,太复杂了，可以通过
        //左子树全都小于右子树（循环判断）
        return isPost(postorder, 0, postorder.length - 1);
    }

    public boolean isPost(int[] nums, int left, int right) {
        if (left >= right) return true;
        int mid = left;
        while (nums[mid] < nums[right]) mid++;
        int lat = mid;
        while (nums[lat] > nums[right]) lat++;
        return lat == right && isPost(nums, left, mid - 1) && isPost(nums, mid, lat - 1);
    }

    //35.复杂链表的复制
    public Node copyRandomList(Node head) {
        //1.哈希表
        /*Map<Node,Node> nodeMap  =new HashMap<>();
        Node tmp = head;
        while (tmp != null){
            nodeMap.put(tmp,new Node(tmp.val));
            tmp = tmp.next;
        }
        tmp = head;
        while(tmp!=null){
            nodeMap.get(tmp).next = nodeMap.get(tmp.next);
            nodeMap.get(tmp).random = nodeMap.get(tmp.random);
            tmp = tmp.next;
        }
        return nodeMap.get(head);*/
        //2.链表每个节点在节点后复制一份
        // 出错点：忘记处理初始链表
        if (head == null) return null;
        Node tmp = head;
        while (tmp != null) {
            Node newNode = new Node(tmp.val);
            newNode.next = tmp.next;
            tmp.next = newNode;
            tmp = newNode.next;
        }
        tmp = head;
        while (tmp != null) {
            if (tmp.random != null) {
                tmp.next.random = tmp.random.next;
            }
            tmp = tmp.next.next;
        }
        tmp = head.next;
        Node ret = tmp;
        Node pre = head;
        while (tmp.next != null) {
            pre.next = tmp.next;
            tmp.next = tmp.next.next;
            pre = pre.next;
            tmp = tmp.next;
        }
        pre.next = null;//最后还是要处理初始链表表位
        return ret;
    }

    //设计停车系统
    //请你给一个停车场设计一个停车系统。停车场总共有三种不同大小的车位：大，中和小，每种尺寸分别有固定数目的车位。
    //请你实现 ParkingSystem 类：
    //ParkingSystem(int big, int medium, int small) 初始化 ParkingSystem 类，三个参数分别对应每种停车位的数目。
    //bool addCar(int carType) 检查是否有 carType 对应的停车位。 carType 有三种类型：大，中，小，分别用数字 1， 2 和 3 表示。一
    // 辆车只能停在  carType 对应尺寸的停车位中。如果没有空车位，请返回 false ，否则将该车停入车位并返回 true 

    //矩阵置零，
    public void setZeroes(int[][] matrix) {
        //方法一，使用一个矩阵存储每个位置是否为零
        //方法二，使用两个数组记录每行每列是否应该置零
        //方法三，先记录第一行第一列中是否为零，再将
        //每行每列是否为零记在第一行，最后先把其他行变为零，再依据记录的值变换第一行第一列
        if (matrix == null || matrix.length == 0) return;
        boolean colFlag = false, rowFlag = false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }
        }
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                colFlag = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }
        if (rowFlag) Arrays.fill(matrix[0], 0);
        if (colFlag) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    //36.二叉搜索树与双向链表
    TreeNode head, tail;

    public TreeNode treeToDoublyList(TreeNode root) {
        //方法1：中序遍历，再使用链表/队列将节点串联起来
        //方法2：中序遍历，在遍历过程中将他们串联起来
        if (root == null) return null;
        inOrder(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (head == null) {
            head = root;
            tail = head;
        } else {
            tail.right = root;
            root.left = tail;
            tail = root;
        }
        inOrder(root.right);
    }

    //37.序列化二叉树
    //见类class Codec
    /**
     * 从上到下，从左往右的话，序列化免不了使用队列
     * 反序列化也是使用顺序队列
     */

    //38.字符串的排列
    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        //自己的想法是字符串存起来，依次与后面各字符串对比，不一样就交换，存起来
        //但是会遇到多个字符相同的情况，2a2b，这种.
        //因此借用题解的做法，采用回溯法，并使用set辅助剪枝
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);

    }

    public void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    public void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    //39.数组中出现超过一半次数的数字
    //使用类似哈希的做法，但是由于数字的值不是确定的
    //比如有1，10000 等，不太好处理，因此想到了Map

    /**
     * 1.使用排序算法，中位数一定是众数
     * 2.哈希表，但是只前分析过，
     * 3.摩尔投票法，首先定义第一个数为众数，后面遇到他一次票数加一，不是他减一，
     * 减到零时，再把下一个第一个数定义为众数。
     */
    public int majorElements(int[] nums) {
        /*Map<Integer,Integer> sums = new HashMap<>();
        int n = nums.length;
        int maxNum = nums[0],maxVal=1;
        for (int tmp : nums) {
            if (!sums.containsKey(tmp)) {
                sums.put(tmp, 1);
            } else {
                sums.put(tmp, sums.get(tmp) + 1);
                if( sums.get(tmp) + 1 > maxVal){
                    maxNum = tmp;
                    maxVal =  sums.get(tmp) + 1;
                }
            }
        }
        return maxNum;*/
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
                votes++;
            } else if (x != num) {
                votes--;
            } else {
                votes++;
            }
        }
        return x;
    }

    //40.最小的k个数

    /**
     * 1.排序算法
     * 2.快排思想
     * 3.堆
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int n = arr.length;
        if (k >= n) return arr;

        return null;
    }


    //41.数据流中的中位数 见class MedianFinder

    /**
     * 出现了新的队列，优先级队列：PriorityQueue，优先级队列，会把存入到里面的数据按大小排列好
     */

    //42.连续子数组的最大和
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int retMax = nums[0], tmpMax = 0;
        for (int num : nums) {
            tmpMax += num;
            if (tmpMax > retMax) retMax = tmpMax;
            if (tmpMax < 0) tmpMax = 0;
        }
        return retMax;
    }

    //43.1-n整数中出现的1的次数
    public int countDigitOne(int n) {
        //暴力，超时
        /*int ret=0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j>0; j/=10) {
                if(j%10==1) ret++;
            }
        }
        return ret;*/
        //题解
        /**
         *123145
         * 拆成123 1 45 high 123 cur 1 low 45
         * 那么与这个cur有关的1的个数有1.123*100+（45+1）最后一位为0时
         * 当然，可以分成cur <1,1>,=1三种情况讨论
         */
        int digit = 1, high = n / 10, cur = n % 10, low = 0, ret = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) ret += high * digit;
            else if (cur == 1) ret += high * digit + low + 1;
            else ret = (high + 1) * digit;
            low = low + cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return ret;
    }

    //44.数字序列中某一位的数字
    public int findNthDigit(int n) {
        int digit = 1;
        long base = 9;
        long count = 9;
        while(n>count){
            n -= count;
            digit +=1;
            base *=10;
            count = digit*base;
        }
        long num = base/9 + (n)/digit;
        return Long.toString(num).charAt(n%digit) -'0';
    }

    //45.把数组排成最小的数
    /**
     *  设计一个算法比较每个数字的大小，最后把数组变成有序数组
     */
    public String minNumber(int[] nums) {
        return null;
    }
    public void quickSort(int i,int j,String[] strs){

    }
}

//41
class MedianFinder {
    Queue<Integer> A, B;

    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }

    public void addNum(int num) {
        if (A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }
}

class ParkingSystem {
    int bigSum, medSum, smlSum;
    int bigTmp = 0, medTmp = 0, smlTmp = 0;

    public ParkingSystem(int big, int medium, int small) {
        bigSum = big;
        medSum = medium;
        smlSum = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (bigTmp < bigSum) {
                    bigTmp++;
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (medTmp < medSum) {
                    medTmp++;
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (smlTmp < smlSum) {
                    smlTmp++;
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }
}

class MinStack {
    Stack<Integer> aStack = new Stack<>();
    Stack<Integer> bStack = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        if (bStack.empty() || bStack.peek() >= x) {
            bStack.push(x);
        }
        aStack.push(x);
    }

    public void pop() {
        if (aStack.pop().equals(bStack.peek())) {
            bStack.pop();
        }
    }

    public int top() {
        return aStack.peek();
    }

    public int min() {
        return bStack.peek();
    }
}

class CQueue {
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    public CQueue() {
    }

    public void appendTail(int value) {
        st1.push(value);
    }

    public int deleteHead() {
        if (st2.empty()) {
            while (!st1.empty()) {
                st2.push(st1.pop());
            }
        }
        if (!st2.empty()) {
            return st2.pop();
        }
        return -1;
    }
}
