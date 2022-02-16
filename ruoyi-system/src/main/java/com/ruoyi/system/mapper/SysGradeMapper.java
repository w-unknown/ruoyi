package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysGrade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysGradeMapper {

    /**
     * 获取所有学生成绩信息
     * @param sysGrade
     * @return
     */
    public List<SysGrade> getSysGradeList(SysGrade sysGrade);

    /**
     * 添加学生记录
     * @param sysGrade
     * @return
     */
    public int insertSysGrade(SysGrade sysGrade);

    /**
     * 根据学号查询学生信息
     * @param id
     * @return
     */
    public SysGrade getSysGradeById(@Param("id") Integer id);

    /**
     * 根据姓名查询学生信息
     * @param name
     * @return
     */
    public SysGrade getSysGradeByName(@Param("name") String name);

    /**
     * 修改学生成绩
     * @param sysGrade
     * @return
     */
    public int updateSysGrade(SysGrade sysGrade);
    /**
     * 批量删除学生成绩
     * @param ids
     * @return
     */
    public int deleteSysGradeByIds(Integer[] ids);

    /**
     * 统计学生成绩
     * @return
     */
    public SysGrade getSysGradeSum();

    /**
     * 根据科目名称查询学生指定科目成绩
     * @param project
     * @return
     */
    public List<SysGrade> getSysGradeByProject(@Param("project")String project);

    /**
     * 导入学生成绩
     * @param gradeList  学生成绩列表
     * @param isUpdateSupport 是否支持更新，如果已存在，就更新数据
     * @param operName 操作用户
     * @return
     */
    public String importGrade(List<SysGrade> gradeList, Boolean isUpdateSupport, String operName);
}
