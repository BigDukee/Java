//问题格式
package data;

public class problem {
    private String content;//内容
    private String userAnswer;//用户答案
    private String CorrectAnswer;//正确答案
    private boolean isChoice;//选择题
    private boolean isJudge;//判断题
    private String ChoiceA,ChoiceB,ChoiceC,ChoiceD;//用户选择

    public boolean isChoice() {
        return isChoice;
    }

    public void setChoice(boolean choice) {
        isChoice = choice;
    }

    public boolean isJudge() {
        return isJudge;
    }

    public void setJudge(boolean judge) {
        isJudge = judge;
    }

    public String getChoiceA() {
        return ChoiceA;
    }

    public void setChoiceA(String choiceA) {
        ChoiceA = choiceA;
    }

    public String getChoiceB() {
        return ChoiceB;
    }

    public void setChoiceB(String choiceB) {
        ChoiceB = choiceB;
    }

    public String getChoiceC() {
        return ChoiceC;
    }

    public void setChoiceC(String choiceC) {
        ChoiceC = choiceC;
    }

    public String getChoiceD() {
        return ChoiceD;
    }

    public void setChoiceD(String choiceD) {
        ChoiceD = choiceD;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        CorrectAnswer = correctAnswer;
    }
}
