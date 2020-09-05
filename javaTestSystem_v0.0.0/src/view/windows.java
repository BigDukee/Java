package view;

import data.*;

import javax.swing.*;
import java.awt.*;

public class windows extends JFrame {

//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }

//    public void setPaper(Paper paper) {
//        this.paper = paper;
//        handelPaper.setPaper(paper);
//    }

    public static Teacher teacher;
    public static Paper paper;
    public JPanel north_panel, south_panel, south_panel_up, south_panel_down;
    public JButton start_text_button, hand_paper_button, try_again_button, ensure_button, next_problem_button, previous_problem_button;
    public JLabel test_information, test_remaining_time, test_remaining_time_number;
    public JTextArea test_content;
    public JCheckBox ChoiceA, ChoiceB, ChoiceC, ChoiceD;

    Handel handel;
    public Handel handelPaper;

    public int total_time = 90*60;
    public javax.swing.Timer time;

    public windows(){
//        time = new Timer(1000, this);
        initview();
        register();
    }

    private void register() {
        handel = new Handel();
        start_text_button.addActionListener(handel);
        hand_paper_button.addActionListener(handel);
        try_again_button.addActionListener(handel);
        next_problem_button.addActionListener(handel);
        previous_problem_button.addActionListener(handel);
        ensure_button.addActionListener(handel);
        handel.setViews(this);
    }

//    public void


    private void initview() {

        setBounds(920/4,580/4,1000,500);

        //NORTH
        north_panel = new JPanel();
        start_text_button = new JButton("开始考试");
        hand_paper_button = new JButton("交卷");
        try_again_button = new JButton("再试一次");
        test_information = new JLabel("【Java基础1】");
        test_remaining_time = new JLabel("考试剩余时间");

        north_panel.add(test_information);
        north_panel.add(start_text_button);
        north_panel.add(hand_paper_button);
        north_panel.add(try_again_button);
        north_panel.add(test_remaining_time);

        hand_paper_button.setVisible(false);
        try_again_button.setVisible(false);

        add(north_panel, BorderLayout.NORTH);
        north_panel.setBackground(Color.cyan);

//        //Center
        test_content = new JTextArea();
        test_content.setLineWrap(true);
        add(new JScrollPane(test_content),BorderLayout.CENTER);



        //south
        south_panel = new JPanel();
        south_panel.setLayout(new GridLayout(2,1));

        south_panel_down = new JPanel();
        south_panel_up = new JPanel();

        ChoiceA = new JCheckBox("A");
        ChoiceB = new JCheckBox("B");
        ChoiceC = new JCheckBox("C");
        ChoiceD = new JCheckBox("D");
        ChoiceA.setVisible(false);
        ChoiceB.setVisible(false);
        ChoiceC.setVisible(false);
        ChoiceD.setVisible(false);


        next_problem_button = new JButton("下一题");
        previous_problem_button = new JButton("上一题");
        ensure_button = new JButton("确认");

        south_panel_up.add(ChoiceA);
        south_panel_up.add(ChoiceB);
        south_panel_up.add(ChoiceC);
        south_panel_up.add(ChoiceD);
        south_panel_up.add(ensure_button);
        south_panel_down.add(previous_problem_button);
        south_panel_down.add(next_problem_button);

        south_panel.add(south_panel_up);
        south_panel.add(south_panel_down);

        add(south_panel,BorderLayout.SOUTH);
        south_panel.setVisible(false);

        south_panel_up.setBackground(Color.green);

        //display
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new windows();
        GivePaper init = new RandomPaper();
        System.out.println("11");
        paper = init.getPaper("D:\\java\\test\\材料\\题库\\Java基础1.xls", 20);


    }
}
