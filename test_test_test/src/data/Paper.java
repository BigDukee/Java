//试卷格式
package data;

public class Paper{

    problem problems[]; //问题数组
    int index = -1;      //索引
    String problemSource;

    //获取问题
    public problem[] getProblems() {
        if (problems == null || problems.length == 0) {
            return null;
        }
        return problems;
    }

    //设置问题
    public void setProblems(problem[] problems) {
        this.problems = problems;
    }

    //评分，关联起来teacher
    public void judgeTeacher(Teacher teacher){
        teacher.giveScore(this);
    }

    //下一个问题
    public problem nextProblem(){
        index++;
        if (index == problems.length) {   //不能越界
            index=problems.length-1;
        }
        return problems[index];

    }

    //上一个问题
    public problem previousProblem(){
        index--;
        if (index < 0) {              //不能越界
            index=0;
        }
        return problems[index];

    }



}
