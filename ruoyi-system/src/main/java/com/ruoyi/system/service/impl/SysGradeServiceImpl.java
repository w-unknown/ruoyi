package com.ruoyi.system.service.impl;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysGrade;
import com.ruoyi.system.mapper.SysGradeMapper;
import com.ruoyi.system.service.ISysGradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LanZhiWei
 * @date 2022/02/07 16:09
 **/
@Service
public class SysGradeServiceImpl implements ISysGradeService {
    private static final Logger log = LoggerFactory.getLogger(SysGradeServiceImpl.class);

    @Autowired
    private SysGradeMapper sysGradeMapper;
    @Override
    public List<SysGrade> getSysGradeList(SysGrade sysGrade) {
        return sysGradeMapper.getSysGradeList(sysGrade);
    }

    @Override
    public int insertSysGrade(SysGrade sysGrade) {
        SysGrade sysGradeById = sysGradeMapper.getSysGradeById(sysGrade.getId());
        if (sysGradeById!=null){
            throw new RuntimeException("学生已存在，不能重复添加!");
        }
        return sysGradeMapper.insertSysGrade(sysGrade);
    }

    @Override
    public SysGrade getSysGradeById(Integer id) {
        return sysGradeMapper.getSysGradeById(id);
    }

    @Override
    public SysGrade getSysGradeByName(String name) {
        return sysGradeMapper.getSysGradeByName(name);
    }

    @Override
    public int updateSysGrade(SysGrade sysGrade) {
        return sysGradeMapper.updateSysGrade(sysGrade);
    }

    @Override
    public int deleteSysGradeByIds(Integer[] ids) {
        return sysGradeMapper.deleteSysGradeByIds(ids);
    }

    @Override
    public SysGrade getSysGradeSum() {
        return sysGradeMapper.getSysGradeSum();
    }

    @Override
    public List<SysGrade> getSysGradeByProject(String project) {
        return sysGradeMapper.getSysGradeByProject(project);
    }

    /**
     * 导入学生成绩数据
     *
     * @param gradeList  学生成绩列表
     * @param isUpdateSupport 是否支持更新，如果已存在，就更新数据
     * @param operName 操作用户
     * @return
     */
    @Override
    public String importGrade(List<SysGrade> gradeList, Boolean isUpdateSupport, String operName) {
        if(StringUtils.isNull(gradeList)||gradeList.size()==0){
            throw new ServiceException("导入学生成绩数据不能为空");
        }
        int successNum=0;
        int failureNum=0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (SysGrade sysGrade : gradeList) {
            try {
                SysGrade sysGradeByName = sysGradeMapper.getSysGradeByName(sysGrade.getName());
                if (StringUtils.isNull(sysGradeByName)){
                    this.insertSysGrade(sysGrade);
                    successNum++;
                    successMsg.append("<br/>"+successNum+"、学生成绩"+sysGrade.getName()+" 导入成功");
                }else if(isUpdateSupport){
                    this.updateSysGrade(sysGrade);
                    successNum++;
                    successMsg.append("<br/>"+successNum+"、学生成绩"+sysGrade.getName()+" 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、学生成绩 " + sysGrade.getName() + " 已存在");
                }
            } catch (Exception e) {
                failureNum++;
                String msg="<br/>" + failureNum + "、学生成绩 " + sysGrade.getName() + " 已存在";
                failureMsg.append(msg+e.getMessage());
                log.error(msg,e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
