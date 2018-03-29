package cn.lhqs.model;

import java.io.Serializable;

/**
 * @author 
 */
public class InsectInfo implements Serializable {
    /**
     * index
     */
    private Integer id;

    private String nameEnglish;

    private String nameChinese;

    private Integer size;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public String getNameChinese() {
        return nameChinese;
    }

    public void setNameChinese(String nameChinese) {
        this.nameChinese = nameChinese;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "InsectInfo{" +
                "id=" + id +
                ", nameEnglish='" + nameEnglish + '\'' +
                ", nameChinese='" + nameChinese + '\'' +
                ", size=" + size +
                '}';
    }
}