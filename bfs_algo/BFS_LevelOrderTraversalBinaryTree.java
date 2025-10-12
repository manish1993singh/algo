package bfs_algo;

import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

class TreeNode{
    int data;
    TreeNode left, right;
    TreeNode(int item){
        data = item;
        left = right = null;
    }
}

public class BFS_LevelOrderTraversalBinaryTree {
    public static void levelOrderTraversal(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            System.out.print("Level: ");
            for(int i = 0; i < levelSize; i++){
                TreeNode currentNode = queue.poll();
                System.out.print(currentNode.data + " ");
                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right);
            }
        }        
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Level Order Traversal of Binary Tree:");
        levelOrderTraversal(root);
    }
}