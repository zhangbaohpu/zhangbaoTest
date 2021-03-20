package com.zhangbao.zhangbaoTest;

import java.util.Scanner;

public class Main {
    private static int n =0;
    private static int m =0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String operate = in.nextLine();
            String nm = in.nextLine();
            String[] split = nm.split(" ");
             n = Integer.valueOf(split[0]);//行
             m = Integer.valueOf(split[1]);//列
            String[][] arr = new String[n][m];
            Node root = null;//头结点
            for(int i =0; i < n; i++ ){
                String row = in.nextLine();
                String[] rowArr = row.split(" ");
                for(int j =0; j < m; j++){
                    if(rowArr[j].equals("H")){
                        root = new Node("H",i,j,null);
                    }
                    arr[i][j] = rowArr[j];
                }
            }
            String before = "L";
            String[] optArr = operate.split(" ");
            for(int i =0; i<optArr.length; i++){
                String opt = optArr[i];
                operation(before,opt,root,arr);
            }
            int num = 1;
            while (root.next!=null){
                num += 1;
            }
            System.out.println(num);

        }
    }

    private static void operation(String before,String opt, Node root,String[][] arr) {
        if(before.equals(opt)){
            before = opt;
        }
        //移动(G)
        if(opt.equals("G")){
            //向上(U)
            if(before.equals("U")){
                int newN = root.n-1;
                if(newN > n){
                    return;
                }
                int newM = root.m;
                if(newM > m){
                    return;
                }
                String val = arr[n][m];
                if(val.equals("H")){

                }else if(val.equals("F")){

                }else if(val.equals("E")){

                }
            }
            //向下(D)
            if(before.equals("D")){

            }
            //向左(L)
            if(before.equals("L")){

            }
            //向右(R)
            if(before.equals("R")){

            }
        }
    }
}
class  Node{
    String val;
    int n;
    int m;
    Node next;

    public Node() {
    }

    public Node(String val, int n, int m) {
        this.val = val;
        this.n = n;
        this.m = m;
    }

    public Node(String val, int n, int m, Node next) {
        this.val = val;
        this.n = n;
        this.m = m;
        this.next = next;
    }
}