package testt;

import data.*;

public class test1 {
    public static void main(String[] args) {
        GivePaper init = new RandomPaper();
        Paper testPaper = init.getPaper("D:\\java\\test\\材料\\题库\\Java基础1.xls", 50);

        problem[] p = testPaper.getProblems();


        for (problem n:p){
            System.out.println(n.getContent());
            System.out.println("correct answer: " + n.getCorrectAnswer());
        }

        p[0].setUserAnswer("D");
        p[0].setUserAnswer("D");
        p[0].setUserAnswer("D");
        p[0].setUserAnswer("D");
        p[0].setUserAnswer("D");


        testPaper.judgeTeacher(new TeacherOne());

    }
}
