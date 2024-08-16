package com.xuecheng.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.domain.CourseBase;
import com.xuecheng.content.model.QueryCourseParamsDto;

/**
* @author TNCN
* @description 针对表【course_base(课程基本信息)】的数据库操作Service
* @createDate 2024-08-15 11:11:08
*/
public interface CourseBaseService extends IService<CourseBase> {

    PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseParamsDto queryCourseParamsDto);

}
