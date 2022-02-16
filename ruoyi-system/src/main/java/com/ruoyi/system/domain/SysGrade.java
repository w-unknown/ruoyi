package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @author LanZhiWei
 * @date 2022/02/07 15:57
 **/
public class SysGrade extends BaseEntity {
    @Excel(name = "学号",type = Excel.Type.EXPORT)
    private Integer id;
    @Excel(name = "姓名")
    private String name;
    @Excel(name = "语文")
    private String chinese;
    @Excel(name = "英语")
    private String english;
    @Excel(name = "数学")
    private String mathematics;
    @Excel(name = "历史")
    private String history;
    @Excel(name = "生物")
    private String biology;
    @Excel(name = "化学")
    private String chemistry;
    @Excel(name = "物理")
    private String physics;
    @Excel(name = "地理")
    private String geography;
    @Excel(name = "政治")
    private String politics;
    @Excel(name = "平均成绩",type= Excel.Type.EXPORT)
    private String avg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getMathematics() {
        return mathematics;
    }

    public void setMathematics(String mathematics) {
        this.mathematics = mathematics;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getBiology() {
        return biology;
    }

    public void setBiology(String biology) {
        this.biology = biology;
    }

    public String getChemistry() {
        return chemistry;
    }

    public void setChemistry(String chemistry) {
        this.chemistry = chemistry;
    }

    public String getPhysics() {
        return physics;
    }

    public void setPhysics(String physics) {
        this.physics = physics;
    }

    public String getGeography() {
        return geography;
    }

    public void setGeography(String geography) {
        this.geography = geography;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "SysGrade{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", chinese='" + chinese + '\'' +
                ", english='" + english + '\'' +
                ", mathematics='" + mathematics + '\'' +
                ", history='" + history + '\'' +
                ", biology='" + biology + '\'' +
                ", chemistry='" + chemistry + '\'' +
                ", physics='" + physics + '\'' +
                ", geography='" + geography + '\'' +
                ", politics='" + politics + '\'' +
                ", avg='" + avg + '\'' +
                '}';
    }
}
