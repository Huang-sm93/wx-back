package com.wx.appbackend.doublecolor.service;

import com.wx.appbackend.doublecolor.dao.NumberDao;
import com.wx.appbackend.doublecolor.entity.BallNumbers;
import com.wx.appbackend.doublecolor.entity.BallNumbersReqDTO;
import com.wx.appbackend.doublecolor.entity.BallNumbersResDTO;
import com.wx.appbackend.doublecolor.entity.GenerateNumReqDTO;
import com.wx.appbackend.doublecolor.util.CalculateUtility;
import com.wx.appbackend.test.CellInfo;
import com.wx.appbackend.test.CellNumber;
import com.wx.appbackend.test.ReadExcelUtility;
import com.wx.appbackend.test.TestBigFun;
import jxl.Workbook;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DoubleColorServiceImpl implements DoubleColorService {

    public static long maxId = 21425712L;
    public static long maxId1 = 17721088L;
    @Resource
    private NumberDao numberDao;

    @Override
    public List<CellInfo> getPage(Map<String, Object> map) {
        return ReadExcelUtility.getArrFileName("历史记录.xls",0, 10);
    }

    @Override
    public List<int[]> generateByPara(GenerateNumReqDTO reqDTO) {
        return CalculateUtility.getListByPara(reqDTO);
    }

    @Override
    public int insertBigFunBatch(List<BallNumbers> list) throws Exception {
        numberDao.insertBatch(list);
        return 1;
    }

    @Override
    public int insertBatch1(List<BallNumbers> list) throws Exception {
        numberDao.insertBatch1(list);
        return 1;
    }

    @Override
    public BallNumbers getById(long l) {
        return numberDao.getById(l);
    }

    @Override
    public List<BallNumbersResDTO> getByKeys(BallNumbersReqDTO reqDTO) {
        List<BallNumbersResDTO> res = new ArrayList<>();
        if (reqDTO.numberIndex > 0 || reqDTO.date != null) {
            Integer numberIndex = reqDTO.numberIndex;
            Date date = null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                date = format.parse(reqDTO.date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            long timeHash = date.getTime();
            long hash = timeHash^numberIndex;
            BallNumbers temp = numberDao.getById((hash^maxId)%maxId);
            BallNumbersResDTO resDTO = new BallNumbersResDTO();
            resDTO.id = temp.id;
            int[] tempArr = new int[7];
            tempArr[0] = temp.number1;
            tempArr[1] = temp.number2;
            tempArr[2] = temp.number3;
            tempArr[3] = temp.number4;
            tempArr[4] = temp.number5;
            tempArr[5] = temp.number6;
            tempArr[6] = temp.number7;
            resDTO.numbers = tempArr;
            res.add(resDTO);
            return res;
        }
        for (int i = 0; i < reqDTO.history.size(); i++) {
            BallNumbers ballNumbers = new BallNumbers();
            ballNumbers.number1 = reqDTO.history.get(i)[0];
            ballNumbers.number2 = reqDTO.history.get(i)[1];
            ballNumbers.number3 = reqDTO.history.get(i)[2];
            ballNumbers.number4 = reqDTO.history.get(i)[3];
            ballNumbers.number5 = reqDTO.history.get(i)[4];
            ballNumbers.number6 = reqDTO.history.get(i)[5];
            ballNumbers.number7 = reqDTO.history.get(i)[6];
            BallNumbers temp = numberDao.getByKeys(ballNumbers);
            BallNumbersResDTO resDTO = new BallNumbersResDTO();
            resDTO.id = temp.id;
            int[] tempArr = new int[7];
            tempArr[0] = temp.number1;
            tempArr[1] = temp.number2;
            tempArr[2] = temp.number3;
            tempArr[3] = temp.number4;
            tempArr[4] = temp.number5;
            tempArr[5] = temp.number6;
            tempArr[6] = temp.number7;
            resDTO.numbers = tempArr;
            res.add(resDTO);
        }
        return res;
    }

    @Override
    public List<BallNumbersResDTO> getByKeys1(BallNumbersReqDTO reqDTO) {
        List<BallNumbersResDTO> res = new ArrayList<>();
        if (reqDTO.numberIndex > 0 || reqDTO.date != null) {
            Integer numberIndex = reqDTO.numberIndex;
            Date date = null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                date = format.parse(reqDTO.date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            long timeHash = date.getTime();
            long hash = timeHash^numberIndex;
            BallNumbers temp = numberDao.getById1((hash^maxId1)%maxId1);
            BallNumbersResDTO resDTO = new BallNumbersResDTO();
            resDTO.id = temp.id;
            int[] tempArr = new int[7];
            tempArr[0] = temp.number1;
            tempArr[1] = temp.number2;
            tempArr[2] = temp.number3;
            tempArr[3] = temp.number4;
            tempArr[4] = temp.number5;
            tempArr[5] = temp.number6;
            tempArr[6] = temp.number7;
            resDTO.numbers = tempArr;
            res.add(resDTO);
            return res;
        }
        for (int i = 0; i < reqDTO.history.size(); i++) {
            BallNumbers ballNumbers = new BallNumbers();
            ballNumbers.number1 = reqDTO.history.get(i)[0];
            ballNumbers.number2 = reqDTO.history.get(i)[1];
            ballNumbers.number3 = reqDTO.history.get(i)[2];
            ballNumbers.number4 = reqDTO.history.get(i)[3];
            ballNumbers.number5 = reqDTO.history.get(i)[4];
            ballNumbers.number6 = reqDTO.history.get(i)[5];
            ballNumbers.number7 = reqDTO.history.get(i)[6];
            BallNumbers temp = numberDao.getByKeys1(ballNumbers);
            BallNumbersResDTO resDTO = new BallNumbersResDTO();
            resDTO.id = temp.id;
            int[] tempArr = new int[7];
            tempArr[0] = temp.number1;
            tempArr[1] = temp.number2;
            tempArr[2] = temp.number3;
            tempArr[3] = temp.number4;
            tempArr[4] = temp.number5;
            tempArr[5] = temp.number6;
            tempArr[6] = temp.number7;
            resDTO.numbers = tempArr;
            res.add(resDTO);
        }
        return res;
    }

    @Override
    public List<BallNumbersResDTO> getByIds(BallNumbersReqDTO reqDTO) {
        List<BallNumbersResDTO> res = new ArrayList<>();
        String[] strings = reqDTO.ids.split(",");
        for (int i = 0; i < strings.length; i++) {
            BallNumbers ballNumbers = numberDao.getById(Long.parseLong(strings[i]));
            BallNumbersResDTO resDTO = new BallNumbersResDTO();
            resDTO.id = ballNumbers.id;
            int[] temp = new int[7];
            temp[0] = ballNumbers.number1;
            temp[1] = ballNumbers.number2;
            temp[2] = ballNumbers.number3;
            temp[3] = ballNumbers.number4;
            temp[4] = ballNumbers.number5;
            temp[5] = ballNumbers.number6;
            temp[6] = ballNumbers.number7;
            resDTO.numbers = temp;
            res.add(resDTO);
        }
        return res;
    }

    @Override
    public List<int[]> generate(int size) {
        List<int[]> res = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            long id = random.nextInt(21425712);
            BallNumbers ballNumbers = numberDao.getById(id);
            int[] temp = new int[8];
            temp[0] = ballNumbers.number1;
            temp[1] = ballNumbers.number2;
            temp[2] = ballNumbers.number3;
            temp[3] = ballNumbers.number4;
            temp[4] = ballNumbers.number5;
            temp[5] = ballNumbers.number6;
            temp[6] = ballNumbers.number7;
            temp[7] = Integer.parseInt(""+ballNumbers.id);
            res.add(temp);
        }
        return res;
    }

    @Override
    public List<int[]> generateByParas(BallNumbersReqDTO reqDTO) throws WriteException, IOException {
        List<int[]> res = new ArrayList<>();
        if (reqDTO.number1 > 0 ||
                reqDTO.number2 > 0 ||
                reqDTO.number3 > 0 ||
                reqDTO.number4 > 0 ||
                reqDTO.number5 > 0 ||
                reqDTO.number6 > 0 ||
                reqDTO.number7 > 0 ){
            BallNumbers ballNumbers = new BallNumbers();
            ballNumbers.number1 = reqDTO.number1;
            ballNumbers.number2 = reqDTO.number2;
            ballNumbers.number3 = reqDTO.number3;
            ballNumbers.number4 = reqDTO.number4;
            ballNumbers.number5 = reqDTO.number5;
            ballNumbers.number6 = reqDTO.number6;
            ballNumbers.number7 = reqDTO.number7;
            ballNumbers.size = reqDTO.size;
            List<BallNumbers> ballNumbersList = numberDao.getListByKeys(ballNumbers);
            int size = reqDTO.size;
            Random random = new Random();
            if (ballNumbersList.size() < reqDTO.size){
                size = ballNumbersList.size();
                random = null;
            }
            for (int i = 0; i < size; i++) {
                int[] temp = new int[8];
                int index = i;
                if (random != null){
                    index = random.nextInt(ballNumbersList.size());
                }
                temp[0] = ballNumbersList.get(index).number1;
                temp[1] = ballNumbersList.get(index).number2;
                temp[2] = ballNumbersList.get(index).number3;
                temp[3] = ballNumbersList.get(index).number4;
                temp[4] = ballNumbersList.get(index).number5;
                temp[5] = ballNumbersList.get(index).number6;
                temp[6] = ballNumbersList.get(index).number7;
                temp[7] = Integer.parseInt(""+ballNumbersList.get(i).id);
                res.add(temp);
            }
        }else if (reqDTO.indexStart > 0 &&
                reqDTO.indexSize > 0 ){
            int[] tempIds = new int[reqDTO.size];
            Random random = new Random();
            for (int i = 0; i < reqDTO.size; i++) {

                int[] temp = new int[8];
                BallNumbers ballNumbers = numberDao.getById(reqDTO.indexStart + random.nextInt(reqDTO.indexSize));
                temp[7] = Integer.parseInt(""+ballNumbers.id);
                temp[0] = ballNumbers.number1;
                temp[1] = ballNumbers.number2;
                temp[2] = ballNumbers.number3;
                temp[3] = ballNumbers.number4;
                temp[4] = ballNumbers.number5;
                temp[5] = ballNumbers.number6;
                temp[6] = ballNumbers.number7;
                res.add(temp);
            }


        }
        WritableWorkbook book = null;
        if (res.size() > 0){
            try {
                book = Workbook.createWorkbook( new File("预测daletou.xls" ));
                ReadExcelUtility.writeFile2(res, book, 1);
                book.write();
            } catch (IOException | WriteException e) {
                throw new RuntimeException(e);
            }finally {
                book.close();
            }
        }
        TestBigFun.test();
        return res;
    }

    @Override
    public List<int[]> generateByParas1(BallNumbersReqDTO reqDTO) throws WriteException, IOException {
        List<int[]> res = new ArrayList<>();
        if (reqDTO.indexStart > 0 &&
                reqDTO.indexSize > 0 ){
            Random random = new Random();
            for (int i = 0; i < reqDTO.size; i++) {

                int[] temp = new int[8];
                BallNumbers ballNumbers = numberDao.getById1(reqDTO.indexStart + random.nextInt(reqDTO.indexSize));
                temp[0] = ballNumbers.number1;
                temp[1] = ballNumbers.number2;
                temp[2] = ballNumbers.number3;
                temp[3] = ballNumbers.number4;
                temp[4] = ballNumbers.number5;
                temp[5] = ballNumbers.number6;
                temp[6] = ballNumbers.number7;
                res.add(temp);
            }

        }
        WritableWorkbook book = null;
        if (res.size() > 0){
            try {
                book = Workbook.createWorkbook( new File("预测.xls" ));
                ReadExcelUtility.writeFile2(res, book, 1);
                book.write();
            } catch (IOException | WriteException e) {
                throw new RuntimeException(e);
            }finally {
                book.close();
            }
        }
        return res;
    }

    @Override
    public void getLastTimes() throws WriteException, IOException {
        List<CellInfo> list = ReadExcelUtility.getArrFileName("D:\\Work\\wx-app-backend-master\\近100次历史记录.xls",200);
        List<int[]> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int[] temp = new int[8];
            CellInfo cellInfo = list.get(i);
            BallNumbers ballNumbers = new BallNumbers();
            ballNumbers.number1 = cellInfo.values[0];
            ballNumbers.number2 = cellInfo.values[1];
            ballNumbers.number3 = cellInfo.values[2];
            ballNumbers.number4 = cellInfo.values[3];
            ballNumbers.number5 = cellInfo.values[4];
            ballNumbers.number6 = cellInfo.values[5];
            ballNumbers.number7 = cellInfo.values[6];
            BallNumbers ballNumbers1 = numberDao.getByKeys1(ballNumbers);
            //将ballNumbers1的值记录到temp中
            temp[0] = ballNumbers1.number1;
            temp[1] = ballNumbers1.number2;
            temp[2] = ballNumbers1.number3;
            temp[3] = ballNumbers1.number4;
            temp[4] = ballNumbers1.number5;
            temp[5] = ballNumbers1.number6;
            temp[6] = ballNumbers1.number7;
            temp[7] = Integer.parseInt(""+ballNumbers1.id);
            //记录到excel文件中
            list1.add(temp);
        }
        WritableWorkbook book = null;
        if (list1.size() > 0){
            try {
                book = Workbook.createWorkbook( new File("计算位置结果.xls" ));
                ReadExcelUtility.writeFile2(list1, book, 1);
                book.write();
            } catch (IOException | WriteException e) {
                throw new RuntimeException(e);
            }finally {
                book.close();
            }
        }
    }

    @Override
    public String generateBigFun(BallNumbersReqDTO reqDTO) throws WriteException, IOException {
        List<int[]> res = new ArrayList<>();
        if (reqDTO.number1 > 0 ||
                reqDTO.number2 > 0 ||
                reqDTO.number3 > 0 ||
                reqDTO.number4 > 0 ||
                reqDTO.number5 > 0 ||
                reqDTO.number6 > 0 ||
                reqDTO.number7 > 0 ){
            BallNumbers ballNumbers = new BallNumbers();
            ballNumbers.number1 = reqDTO.number1;
            ballNumbers.number2 = reqDTO.number2;
            ballNumbers.number3 = reqDTO.number3;
            ballNumbers.number4 = reqDTO.number4;
            ballNumbers.number5 = reqDTO.number5;
            ballNumbers.number6 = reqDTO.number6;
            ballNumbers.number7 = reqDTO.number7;
            ballNumbers.size = reqDTO.size;
            List<BallNumbers> ballNumbersList = numberDao.getListByKeys(ballNumbers);
            int size = reqDTO.size;
            Random random = new Random();
            if (ballNumbersList.size() < reqDTO.size){
                size = ballNumbersList.size();
                random = null;
            }
            for (int i = 0; i < size; i++) {
                int[] temp = new int[8];
                int index = i;
                if (random != null){
                    index = random.nextInt(ballNumbersList.size());
                }
                temp[0] = ballNumbersList.get(index).number1;
                temp[1] = ballNumbersList.get(index).number2;
                temp[2] = ballNumbersList.get(index).number3;
                temp[3] = ballNumbersList.get(index).number4;
                temp[4] = ballNumbersList.get(index).number5;
                temp[5] = ballNumbersList.get(index).number6;
                temp[6] = ballNumbersList.get(index).number7;
                temp[7] = Integer.parseInt(""+ballNumbersList.get(i).id);
                res.add(temp);
            }
        }else if (reqDTO.indexStart > 0 &&
                reqDTO.indexSize > 0 ){
            Random random = new Random();
            for (int i = 0; i < reqDTO.size; i++) {

                int[] temp = new int[8];
                BallNumbers ballNumbers = numberDao.getById(reqDTO.indexStart + random.nextInt(reqDTO.indexSize));
                temp[7] = Integer.parseInt(""+ballNumbers.id);
                temp[0] = ballNumbers.number1;
                temp[1] = ballNumbers.number2;
                temp[2] = ballNumbers.number3;
                temp[3] = ballNumbers.number4;
                temp[4] = ballNumbers.number5;
                temp[5] = ballNumbers.number6;
                temp[6] = ballNumbers.number7;
                res.add(temp);
            }


        }
        WritableWorkbook book = null;
        if (res.size() > 0){
            try {
                book = Workbook.createWorkbook( new File("预测daletou.xls" ));
                ReadExcelUtility.writeFile2(res, book, 1);
                book.write();
            } catch (IOException | WriteException e) {
                throw new RuntimeException(e);
            }finally {
                book.close();
            }
        }
        return TestBigFun.test();
    }
}
