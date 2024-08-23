package com.xuecheng.content.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuecheng.content.domain.Teachplan;
import com.xuecheng.content.model.TeachplanDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author TNCN
* @description 针对表【teachplan(课程计划)】的数据库操作Mapper
* @createDate 2024-08-15 11:11:08
* @Entity generator.domain.Teachplan
*/
@Mapper
public interface TeachplanMapper extends BaseMapper<Teachplan> {

    /***
     * 查询某课程的课程计划，组成树形结构
     * @param courseId
     * @return
     */
     List<TeachplanDto> selectTreeNodes(Long courseId);

}




