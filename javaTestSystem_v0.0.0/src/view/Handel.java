package view;

import data.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Handel implements ActionListener {
    public void setViews(windows views) {
        this.views = views;
    }

//    public void setPaper(Paper paper) {
//        this.paper = paper;
//    }

    windows views;
//    Paper paper;
    problem problems;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.start_text_button) {
            if (views.paper != null) {
//                views.time.start();
                views.hand_paper_button.setVisible(true);
                views.start_text_button.setVisible(false);
                views.south_panel.setVisible(true);
                problems = views.paper.nextProblem();
                whichProblem(problems);
            }
            else{
                JOptionPane.showMessageDialog(null,"没找到试卷惹");
            }

        }

        if (e.getSource() == views.next_problem_button) {
            if (views.paper != null) {
                problems = views.paper.nextProblem();
                whichProblem(problems);
            }
        }

        if (e.getSource() == views.previous_problem_button) {
            if (views.paper != null) {
                problems = views.paper.previousProblem();
                whichProblem(problems);
            }
        }
//
//        if (e.getSource() == views.hand_paper_button) {
//
//        }



        if (e.getSource() == views.hand_paper_button) {
//            views.test_content.setText(null);
//            views.south_panel.setVisible(false);
//            views.teacher.giveScore(views.paper);
            views.hand_paper_button.setVisible(false);
            views.try_again_button.setVisible(true);
            JOptionPane.showMessageDialog(null,"考试结束 ","message",JOptionPane.PLAIN_MESSAGE);
            views.paper.judgeTeacher(new TeacherOne());
        }

        GivePaper testPaper = new RandomPaper();
        views.paper = testPaper.getPaper(views.paper.getProblemSource(),views.paper.getIndex());
    }

    private void whichProblem(problem problems) {
        views.test_content.setText(problems.getContent());
        views.test_content.setVisible(true);
        views.ensure_button.setVisible(true);
        //选择题
        if (problems.isChoice()) {
            views.ChoiceA.setText(problems.getChoiceA());
            views.ChoiceB.setText(problems.getChoiceB());
            views.ChoiceC.setText(problems.getChoiceC());
            views.ChoiceD.setText(problems.getChoiceD());
            views.ChoiceA.setVisible(true);
            views.ChoiceB.setVisible(true);
            views.ChoiceC.setVisible(true);
            views.ChoiceD.setVisible(true);
        }else {
            //判断题
            views.ChoiceA.setText(problems.getChoiceA());
            views.ChoiceA.setText(problems.getChoiceA());
            views.ChoiceA.setVisible(true);
            views.ChoiceB.setVisible(true);
            views.ChoiceC.setVisible(false);
            views.ChoiceD.setVisible(false);
        }
        System.out.println(problems.getUserAnswer());
        if (problems.getUserAnswer() != null) {
            if (problems.getUserAnswer().contains("A")) {
                views.ChoiceA.setSelected(true);
            }else {
                views.ChoiceA.setSelected(false);
            }

            if (problems.getUserAnswer().contains("B")) {
                views.ChoiceA.setSelected(true);
            }else {
                views.ChoiceA.setSelected(false);
            }

            if (problems.getUserAnswer().contains("C")) {
                views.ChoiceA.setSelected(true);
            }else {
                views.ChoiceA.setSelected(false);
            }

            if (problems.getUserAnswer().contains("D")) {
                views.ChoiceA.setSelected(true);
            }else {
                views.ChoiceA.setSelected(false);
            }
        }
        else {
            views.ChoiceA.setSelected(false);
            views.ChoiceB.setSelected(false);
            views.ChoiceC.setSelected(false);
            views.ChoiceD.setSelected(false);
        }
    }

//    public void setView(windows view){
//        this.views = view;
//    }
}
