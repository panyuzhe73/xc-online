package com.xuecheng.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuecheng.content.domain.Teachplan;
import com.xuecheng.content.model.SaveTeachplanDto;
import com.xuecheng.content.model.TeachplanDto;

import java.util.List;

/**
* @author TNCN
* @description 针对表【teachplan(课程计划)】的数据库操作Service
* @createDate 2024-08-15 11:11:08
*/
public interface TeachplanService extends IService<Teachplan> {
    List<TeachplanDto> findTeachplanTree(Long courseId);

    /***
     * 保存课程计划
     * @param saveTeachplanDto
     */
    void saveTeachplan(SaveTeachplanDto saveTeachplanDto);

    void deleteTeachplan(Long courseId);

    void moveTeachplan(Long id,String moveType);


}
