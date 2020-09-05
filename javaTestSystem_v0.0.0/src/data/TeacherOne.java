//打分
package data;

import javax.swing.*;

public class TeacherOne implements Teacher {

    //重写giveScore接口
    @Override
    public void giveScore(Paper paper) {
        problem[] problems = paper.getProblems();
        int correct = 0;

        //遍历problems数组，计算正确题数
        for (problem i : problems){
            if (i.getUserAnswer() != null && i.getUserAnswer().equals(i.getCorrectAnswer())) {
                correct++;
            }
        }
        //打分
        int score = (int) ((correct*1.0/problems.length) * 100);

        //成绩弹框
        JOptionPane.showMessageDialog(null,"your score "+score,"message",JOptionPane.PLAIN_MESSAGE);

    }
}