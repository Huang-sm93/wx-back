package com.wx.appbackend.doublecolor.controller;

import com.wx.appbackend.common.ServiceData;
import com.wx.appbackend.doublecolor.dao.NumberDao;
import com.wx.appbackend.doublecolor.entity.BallNumbersReqDTO;
import com.wx.appbackend.doublecolor.entity.BallNumbersResDTO;
import com.wx.appbackend.doublecolor.entity.GenerateNumReqDTO;
import com.wx.appbackend.doublecolor.service.DoubleColorServiceImpl;
import com.wx.appbackend.test.CellInfo;
import com.wx.appbackend.doublecolor.entity.BallNumbers;
import com.wx.appbackend.test.ReadExcelUtility;
import jxl.Workbook;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/doublecolor")
public class DoubleColorController {

    @Autowired
    private DoubleColorServiceImpl doubleColorService;

    @PostMapping("/getpage")
    public ServiceData<List<CellInfo>> getUser(@RequestBody Map<String, Object> map)throws Exception{
        ServiceData sd = new ServiceData();
        sd.setBo(doubleColorService.getPage(map));
        return sd;
    }

    //根据条件生成接口
    @PostMapping("/generatebypara")
    public ServiceData<List<CellInfo>> generateByPara(@RequestBody GenerateNumReqDTO reqDTO)throws Exception{
        ServiceData sd = new ServiceData();
        sd.setBo(doubleColorService.generateByPara(reqDTO));
        return sd;
    }

    @RequestMapping("/bigfunred")
    public void bigFunRed() throws Exception {
        List<BallNumbers> list = new ArrayList<>();
        int count = 0;
        int count1 = 0;
        long count2 = 1;
        for (int i = 1; i < 32; i++) {
            for (int j = i+1; j < 33; j++) {
                for (int k = j+1; k < 34; k++) {
                    for (int l = k+1; l < 35; l++) {
                        for (int m = l+1; m < 36; m++)  {
                            list.add(new BallNumbers());
                            list.get(count).id = count2;
                            list.get(count).number1 = i;
                            list.get(count).number2 = j;
                            list.get(count).number3 = k;
                            list.get(count).number4 = l;
                            list.get(count).number5 = m;
                            count++;
                            count2++;
                            if (list.size()%3000 == 0) {
                                System.out.println("写入第"+count1+"个文件");
                                count1++;
                                doubleColorService.insertBFRBatch(list);
                                list.clear();
                                count = 0;
                            }

                        }
                    }
                }
            }
        }
        if (list.size() > 0) {
            doubleColorService.insertBFRBatch(list);
        }

    }

    @RequestMapping("/doublecolor")
    public void doubleColor() throws Exception {
        List<BallNumbers> list = new ArrayList<>();
        int count = 0;
        int count1 = 0;
        long count2 = 1;
        for (int i = 1; i < 29; i++) {
            for (int j = i+1; j < 30; j++) {
                for (int k = j+1; k < 31; k++) {
                    for (int l = k+1; l < 32; l++) {
                        for (int m = l+1; m < 33; m++) {
                            for (int n = m+1; n < 34; n++) {
                                for (int o = 1; o < 17; o++) {
                                    list.add(new BallNumbers());
                                    list.get(count).id = count2;
                                    list.get(count).number1 = i;
                                    list.get(count).number2 = j;
                                    list.get(count).number3 = k;
                                    list.get(count).number4 = l;
                                    list.get(count).number5 = m;
                                    list.get(count).number6 = n;
                                    list.get(count).number7 = o;
                                    count++;
                                    count2++;
                                    if (list.size()%3000 == 0) {
                                        System.out.println("写入第"+count1+"个文件");
                                        count1++;
                                        doubleColorService.insertBatch1(list);
                                        list.clear();
                                        count = 0;
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
        if (list.size() > 0) {
            doubleColorService.insertBatch1(list);
        }

    }

    @GetMapping("/get")
    public BallNumbers getById() throws Exception {
        BallNumbers ballNumber = doubleColorService.getById(1L);
        return ballNumber;
    }

    @PostMapping("/getByKeys")
    public List<BallNumbersResDTO> getByKeys(@RequestBody BallNumbersReqDTO reqDTO) throws Exception {
        List<BallNumbersResDTO> ballNumbers = doubleColorService.getByKeys(reqDTO);
        return ballNumbers;
    }

    @PostMapping("/getByKeys1")
    public List<BallNumbersResDTO> getByKeys1(@RequestBody BallNumbersReqDTO reqDTO) throws Exception {
        List<BallNumbersResDTO> ballNumbers = doubleColorService.getByKeys1(reqDTO);
        return ballNumbers;
    }

    @PostMapping("/getByIds")
    public List<BallNumbersResDTO> getByIds(@RequestBody BallNumbersReqDTO reqDTO) throws Exception {
        List<BallNumbersResDTO> ballNumbers = doubleColorService.getByIds(reqDTO);
        return ballNumbers;
    }

    @GetMapping("/generate")
    public List<int[]> generate(@RequestParam("size") int size) throws Exception {
        List<int[]> ballNumbers = doubleColorService.generate(size);
        return ballNumbers;
    }

    @PostMapping("/generateByParas")
    public List<int[]> generateByParas(@RequestBody BallNumbersReqDTO reqDTO) throws Exception {
        List<int[]> ballNumbers = doubleColorService.generateByParas(reqDTO);
        return ballNumbers;
    }

    @PostMapping("/generateBigFun")
    public String generateBigFun(@RequestBody BallNumbersReqDTO reqDTO) throws Exception {
        return doubleColorService.generateBigFun(reqDTO);

    }

    @PostMapping("/generateByParas1")
    public List<int[]> generateByParas1(@RequestBody BallNumbersReqDTO reqDTO) throws Exception {
        List<int[]> ballNumbers = doubleColorService.generateByParas1(reqDTO);
        return ballNumbers;
    }

    @GetMapping("/getLastTimes")
    public void getLastTimes() throws Exception {
        doubleColorService.getLastTimes();
    }

    @GetMapping("/calculateBFIndex")
    public void calculateBFIndex() throws Exception {
        doubleColorService.calculateBFIndex();
    }

    @GetMapping("/calculateDCIndex")
    public void calculateDCIndex() throws Exception {
        doubleColorService.calculateDCIndex();
    }

    @PostMapping("/generateBigFunRed")
    public String generateBigFunRed(@RequestBody BallNumbersReqDTO reqDTO) throws Exception {
        return doubleColorService.generateBigFunRed(reqDTO);

    }

    @PostMapping("/generateDCRed")
    public String generateDCRed(@RequestBody BallNumbersReqDTO reqDTO) throws Exception {
        return doubleColorService.generateDCRed(reqDTO);

    }

    @PostMapping("/ca")
    public void ca(@RequestBody BallNumbersReqDTO reqDTO) throws Exception {
        int count = 0;
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            count = i*1000+400;
            List<List<Integer>> res = doubleColorService.getBFRyIdLimit(count, reqDTO.num6, reqDTO.num7);
            if (res != null &&res.size() > 0) {
                resultList.addAll(res);
            }
        }
        WritableWorkbook book = null;
        if (resultList.size() > 0){
            try {
                book = Workbook.createWorkbook( new File("统计624.xls" ));
                ReadExcelUtility.writeFile4(resultList, book, 1);
                book.write();
            } catch (IOException | WriteException e) {
                throw new RuntimeException(e);
            }finally {
                book.close();
            }
        }

    }

    @PostMapping("/dc")
    public void dc(@RequestBody BallNumbersReqDTO reqDTO) throws Exception {
        int count = 0;
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < 1100; i++) {
            count = i*1000+400;
            List<List<Integer>> res = doubleColorService.getDCRyIdLimit(count, reqDTO.num6, reqDTO.num7);
            if (res != null &&res.size() > 0) {
                resultList.addAll(res);
            }
        }
        WritableWorkbook book = null;
        if (resultList.size() > 0){
            try {
                book = Workbook.createWorkbook( new File("统计626-1.xls" ));
                ReadExcelUtility.writeFile4(resultList, book, 1);
                book.write();
            } catch (IOException | WriteException e) {
                throw new RuntimeException(e);
            }finally {
                book.close();
            }
        }

    }
    @Resource
    private NumberDao numberDao;

    @PostMapping("/getByKeys2")
    public String getByKeys2(@RequestBody BallNumbersReqDTO reqDTO) throws Exception {
        int startSize = reqDTO.startSize;

//        List<CellInfo> list = ReadExcelUtility.getArrFileName("D:\\Work\\wx-app-backend-master\\6月13历史记录.xls",200);
//        long mulRed = 1;
//        long mulAll = 1;
//        for (int i = 0; i < startSize; i++) {
//            int[] temp = list.get(startSize).values;
//            mulRed = mulRed*temp[0]*temp[1]*temp[2]*temp[3]*temp[4]*temp[5];
//            mulAll = mulAll*temp[0]*temp[1]*temp[2]*temp[3]*temp[4]*temp[5]*temp[6];
//        }

        long mulRed = Long.parseLong(reqDTO.n1);
        long mulAll = Long.parseLong(reqDTO.n2);
//        long mulRed = Long.parseLong("3326171402611");
//        long mulAll = Long.parseLong("143326171402611");
        long id1= reqDTO.num6*mulRed%1107568;
        long id2= reqDTO.num7*mulAll%18045720;
        BallNumbers nums1 = numberDao.getDCRById(id1);
        StringBuffer sb = new StringBuffer();
        sb.append(nums1.id + "\t" + nums1.number1 + "\t" + nums1.number2 + "\t" + nums1.number3 + "\t" + nums1.number4 + "\t" + nums1.number5 + "\t" + nums1.number6 + "\t" + nums1.number7 +"\n");
        BallNumbers nums2 = doubleColorService.getById(id2);
        sb.append(nums2.id + "\t" + nums2.number1 + "\t" + nums2.number2 + "\t" + nums2.number3 + "\t" + nums2.number4 + "\t" + nums2.number5 + "\t" + nums2.number6 + "\t" + nums2.number7);

        return sb.toString();

    }

}
