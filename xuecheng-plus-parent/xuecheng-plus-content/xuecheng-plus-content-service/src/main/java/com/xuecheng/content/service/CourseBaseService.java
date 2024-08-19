package com.xuecheng.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.domain.CourseBase;
import com.xuecheng.content.model.AddCourseDto;
import com.xuecheng.content.model.CourseBaseInfoDto;
import com.xuecheng.content.model.EditCourseDto;
import com.xuecheng.content.model.QueryCourseParamsDto;

/**
* @author TNCN
* @description 针对表【course_base(课程基本信息)】的数据库操作Service
* @createDate 2024-08-15 11:11:08
*/
public interface CourseBaseService extends IService<CourseBase> {

    PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseParamsDto queryCourseParamsDto);

    /***
     * 添加课程基本信息
     * @param companyId 教学机构id
     * @param addCourseDto 课程基本信息
     * @return
     */
    CourseBaseInfoDto createCourseBase(Long companyId, AddCourseDto addCourseDto);

    /**
     * @description 根据id查询课程基本信息
     * @param courseId  课程id
     * @return com.xuecheng.content.model.dto.CourseBaseInfoDto
     * @author Mr.M
     * @date 2022/10/9 8:13
     */
    CourseBaseInfoDto getCourseBaseInfo(Long courseId);

    /**
     * @description 修改课程信息
     * @param companyId  机构id
     * @param dto  课程信息
     * @return com.xuecheng.content.model.dto.CourseBaseInfoDto
     * @author Mr.M
     * @date 2022/9/8 21:04
     */
    CourseBaseInfoDto updateCourseBase(Long companyId,EditCourseDto dto);

}
