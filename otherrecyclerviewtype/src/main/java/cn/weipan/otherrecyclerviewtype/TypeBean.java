package cn.weipan.otherrecyclerviewtype;

/**
 * 作者：Created by cc on 2016/11/24 14:04.
 * 邮箱：904359289@QQ.com.
 * 类 ：
 */
public class TypeBean {
    private String Type;
    private String Title;

    public TypeBean(String type, String title) {
        Type = type;
        Title = title;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
