package com.xuecheng.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuecheng.content.domain.CourseCategory;
import com.xuecheng.content.model.CourseCategoryTreeDto;

import java.util.List;


/**
* @author TNCN
* @description 针对表【course_category(课程分类)】的数据库操作Service
* @createDate 2024-08-15 11:11:08
*/
public interface CourseCategoryService extends IService<CourseCategory> {


    List<CourseCategoryTreeDto> queryTreeNodes(String id);
}
