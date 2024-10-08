package com.xuecheng.content.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuecheng.content.domain.CourseTeacher;

import java.util.List;

/**
* @author TNCN
* @description 针对表【course_teacher(课程-教师关系表)】的数据库操作Service
* @createDate 2024-08-15 11:11:08
*/
public interface CourseTeacherService extends IService<CourseTeacher> {

    List<CourseTeacher> list(Long courseId);
    CourseTeacher saveCourseTeacher(CourseTeacher courseTeacher);

    void deleteCourseTeacher(Long courseId,Long id);


}
