package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuecheng.base.exception.XueChengPlusException;
import com.xuecheng.content.mapper.CourseTeacherMapper;
import com.xuecheng.content.domain.CourseTeacher;
import com.xuecheng.content.service.CourseTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author TNCN
* @description 针对表【course_teacher(课程-教师关系表)】的数据库操作Service实现
* @createDate 2024-08-15 11:11:08
*/
@Service
public class CourseTeacherServiceImpl extends ServiceImpl<CourseTeacherMapper, CourseTeacher>
    implements CourseTeacherService {

    @Autowired
    private CourseTeacherMapper courseTeacherMapper;

    @Override
    public List<CourseTeacher> list(Long courseId) {
        LambdaQueryWrapper<CourseTeacher> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CourseTeacher::getCourseId,courseId);
        List<CourseTeacher> courseTeacher = courseTeacherMapper.selectList(queryWrapper);
        return courseTeacher;
    }

    @Override
    public void deleteCourseTeacher(Long courseId, Long id) {
        LambdaQueryWrapper<CourseTeacher> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CourseTeacher::getId,id).eq(CourseTeacher::getCourseId,courseId);
        int delete = courseTeacherMapper.delete(queryWrapper);
        if(delete <= 0){
            XueChengPlusException.cast("删除教师失败");
        }

    }

    @Override
    public CourseTeacher saveCourseTeacher(CourseTeacher courseTeacher) {

        if(courseTeacher.getId() == null){
            int insert = courseTeacherMapper.insert(courseTeacher);
            if(insert <= 0){
                XueChengPlusException.cast("新增教师失败");
            }
        }else{
            int update = courseTeacherMapper.updateById(courseTeacher);
            if(update <= 0){
                XueChengPlusException.cast("修改教师失败");
            }
        }
        return courseTeacher;
    }
}




