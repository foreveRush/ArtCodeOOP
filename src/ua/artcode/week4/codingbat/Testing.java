package ua.artcode.week4.codingbat;

/**
 * Created by Serhii Fursenko on 20.07.2016.
 * fyrsenko@gmail.com
 */
public class Testing {

    public static void main(String[] args) {

        String string = "xxhixx";


        System.out.println(string.substring(string.length()-1,string.length()));
        System.out.println(countX(string));

    }



    public static int countX(String str) {
        if(str == "") return 0;
        if(str.length() == 1) {
            if("x".equals(str)){
                return 1;
            }else {
                return 0;
            }
        }

        return countX(str.substring(0,str.length()-1)) + countX(str.substring(str.length()-1,str.length()));
    }
}
