package com.wx.appbackend.test;

import jxl.Workbook;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/5/23
 */
public class ceshishilimingzhong {

    static List<Integer> initListA;

    public static void main(String[] args) throws WriteException, IOException {
        List<List<Integer>> lastList = ReadExcelUtility.getDCRLastNumbers21(0);
        for (int j = 0; j < lastList.size(); j++) {
            List<Integer> list = lastList.get(j);
            int count = 0;
            for (int i = 0; i < 12; i++) {

                    if (initListA.contains(list.get(i))){
                        count++;
                    }


                if (count >= 5){
                    System.out.println("位置"+j +"  "+ list);
                }

            }

        }
    }

    static {
        initListA = new ArrayList<>();
        initListA.add(5);
        initListA.add(14);
        initListA.add(10);
        initListA.add(23);
        initListA.add(25);
        initListA.add(33);


//        initListA.add(12);
//        initListA.add(14);
//        initListA.add(17);
//        initListA.add(20);
//        initListA.add(21);
//        initListA.add(26);

//        initListA.add(3);
//        initListA.add(5);
//        initListA.add(25);
//        initListA.add(31);
//        initListA.add(32);
//        initListA.add(33);

//        initListA.add(5);
//        initListA.add(12);
//        initListA.add(15);
//        initListA.add(19);
//        initListA.add(24);
//        initListA.add(26);

//        initListA.add(2);
//        initListA.add(6);
//        initListA.add(25);
//        initListA.add(33);
//        initListA.add(10);
//        initListA.add(24);
    }


}

