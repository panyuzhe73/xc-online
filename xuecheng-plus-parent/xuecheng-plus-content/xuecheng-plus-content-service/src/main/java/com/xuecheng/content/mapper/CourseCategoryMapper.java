package com.xuecheng.content.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuecheng.content.domain.CourseCategory;
import com.xuecheng.content.model.CourseCategoryTreeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author TNCN
* @description 针对表【course_category(课程分类)】的数据库操作Mapper
* @createDate 2024-08-15 11:11:08
* @Entity generator.domain.CourseCategory
*/
@Mapper
public interface CourseCategoryMapper extends BaseMapper<CourseCategory> {
     List<CourseCategoryTreeDto> selectTreeNodes( String id);

}




