//生成试卷接口
package data;

public interface GivePaper {
    Paper getPaper(String filename, int amount);

    public Paper getPaper();
}
