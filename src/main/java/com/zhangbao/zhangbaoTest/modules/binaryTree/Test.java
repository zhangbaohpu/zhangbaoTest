package com.zhangbao.zhangbaoTest.modules.binaryTree;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sunny
 * @create 2020-05-2020/5/29-16:31
 */
public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(null);
        TreeNode right = new TreeNode(2);
        right.setLeft(new TreeNode(3));
        root.setRight(right);

        Test t = new Test();

        List<Integer> integers = t.preorderTraversal(root);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    //前序遍历
    public  List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        preOrder(list,root);
        return list;
    }

    public  void preOrder(List<Integer> list,TreeNode node){
        if(node!=null){
            list.add(node.getVal());
        }
        if(node.getLeft()!=null){
            preOrder(list,node.getLeft());
        }
        if(node.getRight()!=null){
            preOrder(list,node.getRight());
        }

    }


}
@Data
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}