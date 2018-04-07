 package com.autoLogin;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class Main {

    public static ArrayList ReadData(String pathname) {
        ArrayList strlist = new ArrayList();
        try {

            File filename = new File(pathname);
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);
            int j = 0;
            String line = "";
            while ((line = br.readLine()) != null) {
                strlist.add(line);
            }
            return strlist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strlist;
    }

    public static ArrayList DataWash(ArrayList Datalist) {
        ArrayList AIS = new ArrayList();
        ArrayList IS = new ArrayList();
        for (int i = 0; i < Datalist.size(); i++) {
            String Tstr = (String) Datalist.get(i);
            if (Tstr.equals("A") == false) {
                IS.add(Integer.parseInt(Tstr));
            }
            if (Tstr.equals("A")) {
                AIS.add(IS.clone());
                IS.clear();
            }
        }
        return AIS;
    }



//%%%%%%%%%%%%%%%%%%%%%%% Procedure MonotoneSquareNormClustering() that will contain your code:


    public static int MonotoneSquareNormClustering(int[] A, int n, int k){
        /* Input is array of input sequence (a_1, a_2,...,a_n) as A[0,1,...,n-1], that is,
        a_1 = A[0], a_2 = A[1], ..., a_n = A[n-1].
        n = number of integers in sequence A
        k = number of groups (k <= n)
        This procedure should return the objective function value of the monotone grouping with minimum possible 
        value of the objective function, or it should return -1 if there is no monotone grouping. 
        It should NOT return the respective grouping!
        */
     
        /* Here should be the description of the main ideas of your solution: 
        describe the recursive relation used in your dynamic programming 
        solution and outline how you implement it in your code below.

      
        */



        /* Here should be the statement and description of the running time 
        analysis of your implementation: describe how the running time depends on 
        n (length of the input sequence) and k (number of groups), and give a short 
        argument.


        */



        /* Here should be the code of your procedure to solve the problem:
        (These comments of the text should be removed after your code is written here.)


 
        */
            
        return 0; // Here your procedure should return the objective value of the optimal
                  // monotone grouping, or return -1 in case if there is no monotone grouping. 
    } // end of procedure MonotoneSquareNormClustering


//%%%%%%%%%%%%%%%%%%%%%%% End of your code




    public static int Computation(ArrayList Instance, int opt){
        int NGounp = 0;
        int size = 0;
        int Correct = 0;
        size = Instance.size();

        int [] A = new int[size-opt];
        // NGounp = Integer.parseInt((String)Instance.get(0));
        NGounp = (Integer)Instance.get(0);
        for (int i = opt; i< size;i++ ){
            A[i-opt] = (Integer)Instance.get(i);
        }
        int Size =A.length;
        if (NGounp >Size ){
            return (-1);
        }
        else {
            int R = MonotoneSquareNormClustering(A, Size, NGounp);
            return(R);
        }
    }

    public static String Test;


    public static void main(String[] args) {
        Test = args[0];
        int opt = 2;
        String pathname = "data2.txt";
        if (Test.equals("-opt1")) {
            opt = 1;
            pathname = "data1.txt";
        }


        ArrayList Datalist = new ArrayList();
        Datalist = ReadData(pathname);
        ArrayList AIS = DataWash(Datalist);

        int Nins = AIS.size();
        int NGounp = 0;
        int size = 0;
        if (Test.equals("-opt1")) {
            for (int t = 0; t < Nins; t++) {
                int Correct = 0;
                int Result = 0;
                ArrayList Instance = (ArrayList) AIS.get(t);
                Result = Computation(Instance, opt);
                System.out.println(Result);
            }
        }
        else {
            int wrong_no = 0;
            int Correct = 0;
            int Result = 0;
            ArrayList Wrong = new ArrayList();
            for (int t = 0; t < Nins; t++) {
                ArrayList Instance = (ArrayList) AIS.get(t);
                Result = Computation(Instance, opt);
                System.out.println(Result);
                Correct = (Integer) Instance.get(1);
                if (Correct != Result) {
                    Wrong.add(t+1);
                    //Wrong.add(Instance);
                    wrong_no=wrong_no+1;
                }
            }
            if (Wrong.size() > 0) {System.out.println("Index of wrong instance(s):");}
            for (int j = 0; j < Wrong.size(); j++) {
                System.out.print(Wrong.get(j));
                System.out.print(",");

                /*ArrayList Instance = (ArrayList)Wrong.get(j);
                for (int k = 0; k < Instance.size(); k++){
                    System.out.println(Instance.get(k));
                }*/
            }
            System.out.println("");
            System.out.println("Percentage of correct answers:");
            System.out.println(((double)(Nins-wrong_no) / (double)Nins)*100);

        }

    }
}