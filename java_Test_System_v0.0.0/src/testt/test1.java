package testt;

import data.*;

public class test1 {
    public static void main(String[] args) {
        GivePaper init = new RandomPaper();
        Paper testPaper = init.getPaper("D:\\java\\test\\材料\\题库\\Java基础1.xls", 20);

        problem[] p = testPaper.getProblems();


        for (problem n:p){       //遍历problem类p数组
            System.out.println(n.getContent());
            System.out.println("correct answer: " + n.getCorrectAnswer());
        }

        p[0].setUserAnswer("D");
        p[1].setUserAnswer("D");
        p[2].setUserAnswer("D");
        p[3].setUserAnswer("D");
        p[4].setUserAnswer("D");


        testPaper.judgeTeacher(new TeacherOne());

    }
}
