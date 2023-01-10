package com.wx.appbackend.test;

import jxl.Workbook;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/10/26
 */
public class TestM {
    public static void main(String[] args) throws WriteException, IOException {
//        List<CellInfo> historyList = ReadExcelUtility.getArrFileName("D:\\Work\\wx-app-backend-master\\历史记录.xls",
//                2);

//        List<int[]> res = getResult2(10000);
//        List<int[]> res = getResult3(10000);
//        List<int[]> res = getResult3(1000, 2);
//        for (int i = 0; i < res.size(); i++) {
//            int countRed = 0;
//            countRed = countRed + (hisList.contains(res.get(i)[0]) ? 1 :0);
//            countRed = countRed + (hisList.contains(res.get(i)[1]) ? 1 :0);
//            countRed = countRed + (hisList.contains(res.get(i)[2]) ? 1 :0);
//            countRed = countRed + (hisList.contains(res.get(i)[3]) ? 1 :0);
//            countRed = countRed + (hisList.contains(res.get(i)[4]) ? 1 :0);
//            countRed = countRed + (hisList.contains(res.get(i)[5]) ? 1 :0);
//            int countBlue = res.get(i)[6] == 11 ? 1 : 0;
//            int money = 0;
//            int sum = countBlue+countRed;
//            switch (sum){
//                case 7:
//                    money=5000000;
//                    break;
//                case 6:
//                    money=300000;
//                    break;
//                case 5:
//                    money=3000;
//                    break;
//                case 4:
//                    money=200;
//                    break;
//                default:
//                    money = countBlue == 1 ? 5 : 0;
//                    break;
//            }
//            System.out.println(res.get(i)[0] + " " +
//                            res.get(i)[1] + " " +
//                            res.get(i)[2] + " " +
//                            res.get(i)[3] + " " +
//                            res.get(i)[4] + " " +
//                            res.get(i)[5] + " " +
//                            res.get(i)[6] + " 中了" + money+"元"
//                    );
//        }
//        List<int[]> res = getResult2(10);
        WritableWorkbook book = null;
        try {
            book = Workbook.createWorkbook( new File("预测.xls" ));
            Random random = new Random();
            Map<String, List<Integer>> res = getRedBlueLis2(1);
            for (int i = 0; i < 10; i++) {
                List<int[]> list = getResult(res.get("red"), res.get("blue"), random, 1000);
                ReadExcelUtility.writeFile(list, book, i);
            }
            book.write();
        } catch (WriteException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (book != null){
                book.close();
            }
        }
    }

    public static List<Integer> currentList;
    public static List<Integer> lastList;
    static {
        currentList = new ArrayList<>();
        lastList = new ArrayList<>();
        lastList.add(8);
        lastList.add(21);
        lastList.add(23);
        lastList.add(27);
        lastList.add(28);
        lastList.add(33);
        currentList.add(2);
        currentList.add(14);
        currentList.add(19);
        currentList.add(21);
        currentList.add(25);
        currentList.add(28);
    }

    /**
     * 计算方法一
     * @param historyList
     * @param outListSize
     * @return
     */
    public static List<int[]> getResult(List<CellInfo> historyList, int outListSize){

        int[] blueCount = new int[34];
        int[] redCount = new int[17];
        for (int i = 0; i < historyList.size(); i++) {
            redCount[historyList.get(i).values[6]] = redCount[historyList.get(i).values[6]] + 1;
            for (int item : historyList.get(i).values) {
                blueCount[item] = blueCount[item] + 1;
            }
        }

        for (int i = 1; i < blueCount.length; i++) {
            blueCount[i] = historyList.size()*2 - blueCount[i];
        }

        for (int i = 1; i < redCount.length; i++) {
            redCount[i] = historyList.size()*2 - redCount[i];
        }

        Random random = new Random();
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < outListSize; i++) {
            int[] temp = new int[7];
            for (int j = 0; j < 6; j++) {
                temp[j] = getRandomNum(blueCount, random);
            }
            Arrays.sort(temp);
            temp[0] = getRandomNum(redCount, random);
            result.add(temp);
        }
        return result;

    }

    /**
     *
     * @param historyList
     * @return
     */
    public static Map<String, List<Integer>> getRedBlueList(List<CellInfo> historyList){
        Map<String, List<Integer>> result = new HashMap<>();
        List<Integer> allBlue = new ArrayList<>();
        List<Integer> allRed = new ArrayList<>();

        if (historyList.size() < 1){
            return null;
        }
        int[] blueCount = new int[34];
        int[] redCount = new int[17];
        for (CellInfo cellInfo : historyList) {
            for (int i = 0; i < cellInfo.values.length; i++) {
                if (i == 6){
                    redCount[cellInfo.values[i]] = redCount[cellInfo.values[i]] + 1;
                }else {
                    blueCount[cellInfo.values[i]] = blueCount[cellInfo.values[i]] + 1;
                }
            }
        }

        int times = historyList.size() + 1;
        for (int i = 1; i < blueCount.length; i++) {
            for (int j = 0; j < times - blueCount[i]; j++) {
                allBlue.add(i);
            }
        }


        for (int i = 1; i < redCount.length; i++) {
            for (int j = 0; j < times - redCount[i]; j++) {
                allRed.add(i);
            }
        }

        for (int i = 1; i < 34; i++) {
            allBlue.add(i);
        }

        for (int i = 1; i < 17; i++) {
            allRed.add(i);
        }

        result.put("red", allRed);
        result.put("blue", allBlue);

        return result;
    }


    public static List<int[]> getResult(List<Integer> allBlue, List<Integer> allRed, Random random, int outListSize){
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < outListSize; i++) {
            List<Integer> blueTemp = new ArrayList<>(allBlue);
            List<Integer> redTemp = new ArrayList<>(allRed);
            int temp[] = new int[7];
            temp[6] = 40;
            for (int j = 0; j < 6; j++) {
                temp[j] = getRandomNum(blueTemp, random);
            }
            Arrays.sort(temp);
            temp[6] = getRandomNum(redTemp, random);
            result.add(temp);
        }


        return result;
    }
    /**
     * 没有历史记录，完全随机
     * @param outListSize
     * @return
     */
    public static List<int[]> getResult2(int outListSize){
        List<int[]> result = new ArrayList<>();
        List<Integer> allBlue = new ArrayList<>();
        List<Integer> allRed = new ArrayList<>();

        for (int i = 1; i < 34; i++) {
            allBlue.add(i);
        }

        for (int i = 1; i < 17; i++) {
            allRed.add(i);
        }
        Random random = new Random();
        for (int i = 0; i < outListSize; i++) {
            List<Integer> blueTemp = new ArrayList<>(allBlue);
            List<Integer> redTemp = new ArrayList<>(allRed);
            int temp[] = new int[7];
            temp[6] = 40;
            for (int j = 0; j < 6; j++) {
                temp[j] = getRandomNum(blueTemp, random);
            }
            Arrays.sort(temp);
            temp[6] = getRandomNum(redTemp, random);
            result.add(temp);
        }


        return result;
    }

    /**
     * 没有历史记录，完全随机，但是排除上几期数字
     * @param lastTimes
     * @return
     */
    public static Map<String, List<Integer>> getRedBlueLis2(int lastTimes){
        Map<String, List<Integer>> result = new HashMap<>();
        List<Integer> allBlue = new ArrayList<>();
        List<Integer> allRed = new ArrayList<>();
        Set<Integer> lastSet = ReadExcelUtility.getLastNumbers(lastTimes);
        for (int i = 1; i < 34; i++) {
            if (lastSet.contains(i)){
                continue;
            }
            allRed.add(i);
        }

        for (int i = 1; i < 17; i++) {
            allBlue.add(i);
        }
        result.put("red", allRed);
        result.put("blue", allBlue);
        return result;
    }

    /**
     * 去除掉一部分
     * @param outListSize
     * @return
     */
    public static List<int[]> getResult4(int outListSize, int useLastTimes){
        List<int[]> result = new ArrayList<>();
        List<Integer> allBlue = new ArrayList<>();
        List<Integer> allRed = new ArrayList<>();
        Map<String, List<Integer>> map = ReadExcelUtility.getLastNumbers1(useLastTimes);
        for (int i = 1; i < 34; i++) {
            for (int j = 0; j < useLastTimes; j++) {
                allRed.add(i);
            }
        }
        List<Integer> redList = map.get("red");
        List<Integer> blueList = map.get("blue");
        for (int i = 0; i < redList.size(); i++) {
            allRed.remove(redList.get(i));
        }

        for (int i = 1; i < 17; i++) {
            for (int j = 0; j < useLastTimes; j++) {
                allBlue.add(i);
            }
        }
        for (int i = 0; i < blueList.size(); i++) {
            allBlue.remove(blueList.get(i));
        }


        Random random = new Random();
        for (int i = 0; i < outListSize; i++) {
            List<Integer> blueTemp = new ArrayList<>(allBlue);
            List<Integer> redTemp = new ArrayList<>(allRed);
            int temp[] = new int[7];
            temp[6] = 40;
            for (int j = 0; j < 6; j++) {
                temp[j] = getRandomNum(redTemp, random);
            }
            Arrays.sort(temp);
            temp[6] = getRandomNum(blueTemp, random);
            result.add(temp);
        }


        return result;
    }

    /**
     * 蓝色的去掉
     * @param outListSize
     * @param useLastTimes
     * @return
     */
    public static List<int[]> getResult5(int outListSize, int useLastTimes){
        List<int[]> result = new ArrayList<>();
        List<Integer> allBlue = new ArrayList<>();
        List<Integer> allRed = new ArrayList<>();
        Map<String, List<Integer>> map = ReadExcelUtility.getLastNumbers1(useLastTimes);
        for (int i = 1; i < 34; i++) {
            for (int j = 0; j < useLastTimes; j++) {
                allRed.add(i);
            }
        }
        List<Integer> redList = map.get("red");
        List<Integer> blueList = map.get("blue");
        for (int i = 0; i < redList.size(); i++) {
            allRed.remove(redList.get(i));
        }

        for (int i = 1; i < 17; i++) {
            for (int j = 0; j < useLastTimes; j++) {
                allBlue.add(i);
            }
        }
        for (int i = 0; i < blueList.size(); i++) {
            allBlue.remove(blueList.get(i));
        }


        Random random = new Random();
        for (int i = 0; i < outListSize; i++) {
            List<Integer> blueTemp = new ArrayList<>(allBlue);
            List<Integer> redTemp = new ArrayList<>(allRed);
            int temp[] = new int[7];
            temp[6] = 40;
            for (int j = 0; j < 6; j++) {
                temp[j] = getRandomNum(redTemp, random);
            }
            Arrays.sort(temp);
            temp[6] = getRandomNum(blueTemp, random);
            result.add(temp);
        }


        return result;
    }
    public static int getRandomNum(int[] blueCount, Random random){
        int all = 0;
        for (int i = 0; i < blueCount.length; i++) {
            all = all+blueCount[i];
        }

        int count = 0;
        int randNum = random.nextInt(all);
        for (int i = 1; i < blueCount.length; i++) {
            count = count + blueCount[i];
            if (randNum < count){
                blueCount[i] = 0;
                return i;
            }
        }

        return 0;
    }


    public static int getRandomNum(List<Integer> blueCount, Random random){

        int randNum = random.nextInt(blueCount.size());
        int count = blueCount.get(randNum);
        boolean flag = true;
        while (flag){
            flag = blueCount.remove(new Integer(count));
        }
        return count;
    }
}
