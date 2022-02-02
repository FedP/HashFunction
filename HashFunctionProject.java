package com.codeWithMe;
import java.io.*;
import java.util.Arrays;

public class Main {



    public static void main(String []args) {
        String Path = "/Users/Federico/Desktop/11Chain/HashFun/Check11//Context.json";
        String SeparatorElement = ":";
        long Hash = HashFunction(InternalHash(Path, SeparatorElement));
        System.out.println("Hash is: "+Hash);
    }

    public  static int[] InternalHash(String Path, String SeparatorElement) {
        try {
            String s1 = JSONtoString(Path);
            //System.out.println(s1);
            int[] NewSequence = StringToArray(s1, SeparatorElement);
            //System.out.println("NewSequence: "+Arrays.toString(NewSequence));
            //System.out.println("Sum: "+sum(NewSequence));
            return NewSequence;
        } catch (Exception ex) {
            int[] a = {0,1};
            return a;
        }
    }


    public static long HashFunction(int a[]) {
        long result = 1;
        for (int element : a) {
            result = 31 * result + element;
        }
        return result;
    }

    public static String JSONtoString(String Path) {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(Path));
            String s;
            String s1 = "";
            while ((s = br.readLine()) != null) {
                s1 = s1 + s;
            }
            //System.out.println("s1 printed: " + s1);
            //System.out.println("s1 class: " + s1.getClass());
            br.close();

            return s1;
        }
        catch (Exception ex) {
            return "1";
        }
    }

    public static int[] StringToArray(String s1, String separatorElement){
        String[] strArray = null;
        strArray = s1.split(separatorElement);
        int len = strArray.length;
        //System.out.println("Len: "+len);

        int[] NewSequence = new int[len];

        for (int i = 0; i < strArray.length; i++) {
            //System.out.println("arr: " + strArray[i] + " >---< Length: "+strArray[i].length());
            NewSequence[i] = strArray[i].length();
        }
        return NewSequence;
    }
}
