package controllers;

import java.util.ArrayList;

/**
 * Created by oysteinhauan on 06/09/14.
 */
public class Oystein {

    public static String someCode(String number){
        int num = Integer.parseInt(number);
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i<num; i++){
            list.add("Antall pushups hittil: " + i);
            System.out.println(list.get(i));
        }

        return list.toString();
    }
}
