//随机生成试卷
package data;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

//试卷，问题，文件，读取excel表格，list
public class RandomPaper implements GivePaper {
    Paper paper = new Paper();
    problem[] problems;
    File file;
    InputStream in;
    Workbook wb;
    Sheet sheet;
    ArrayList<Integer> list = new ArrayList<>();


    //重写getPaper接口
    @Override
    public Paper getPaper(String filename, int amount) {
        boolean b = setExcel(filename);            //判断读取是否成功
        if (b) {
            randomGive(amount);              //成功以后随机生成试卷
        }
        paper.setProblems(problems);              //生成试卷
        return paper;
    }

    private void randomGive(int amount) {
        list.clear();      //释放集合
        sheet = wb.getSheet(0);         //获取第一张sheet
        int sheetAmount = sheet.getRows();      //获取sheet的行
        int realAmount = Math.min(amount,sheetAmount-1);         //总数或行数-1最小值中最小值
        problems = new problem[realAmount];          //定义problems数组大小
        for (int i=0;i<sheetAmount-1;i++){                //将sheet的行数给list集合
            list.add(i+1);
        }
        Random rand = new Random();
        for (int i=0;i<problems.length;i++){
            int m = rand.nextInt(list.size());        //生成随机数
            int index = list.remove(m);                   //不用get！
            Cell[] cells = sheet.getRow(index);     //从单元格拿出索引值，为了给问题赋值
            problems[i] = new problem();
            problems[i].setContent("第 "+(i+1)+" 题 "+cells[0].getContents().trim());
            problems[i].setCorrectAnswer(cells[1].getContents().trim());
            problems[i].setChoiceA(cells[2].getContents().trim());
            problems[i].setChoiceB(cells[3].getContents().trim());
            problems[i].setChoiceC(cells[4].getContents().trim());
            problems[i].setChoiceD(cells[5].getContents().trim());
            String type  = cells[6].getContents().trim();
            if (type.equals("x")) {
                problems[i].setChoice(true);
                problems[i].setJudge(false);
            }
            if (type.equals("p")) {
                problems[i].setJudge(true);
                problems[i].setChoice(false);
            }


        }

    }

    //读取excel文件
    private boolean setExcel(String filename) {
        boolean b = true;
        //异常处理
        try {
            file = new File(filename);
            in = new FileInputStream(file);
            wb = Workbook.getWorkbook(in);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            b = false;
        } catch (IOException e) {
            e.printStackTrace();
            b = false;
        } catch (BiffException e) {
            e.printStackTrace();
            b = false;
        }
        return b;
    }

    @Override
    public Paper getPaper() {
        return null;
    }
}
