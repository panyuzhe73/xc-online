package com.xuecheng.content.api;

import com.xuecheng.content.domain.CourseTeacher;
import com.xuecheng.content.service.CourseTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "教师信息编辑接口",tags = "教师信息编辑接口")
@RestController
public class CourseTeacherController {

    @Resource

    private CourseTeacherService courseTeacherService;
    @ApiOperation("查询教师接口")
    @GetMapping("/courseTeacher/list/{courseId}")
    public List<CourseTeacher> getCourseTeacherById(@PathVariable Long courseId){
        return courseTeacherService.list(courseId);
    }
    @ApiOperation("添加教师接口")
    @PostMapping("/courseTeacher")
    public CourseTeacher saveCourseTeacher(@RequestBody CourseTeacher courseTeacher){
        return courseTeacherService.saveCourseTeacher(courseTeacher);
    }

    @ApiOperation("删除教师")
    @DeleteMapping("/courseTeacher/course/{courseId}/{id}")
    public void deleteCourseTeacher(@PathVariable Long courseId,@PathVariable Long id){
        courseTeacherService.deleteCourseTeacher(courseId,id);
    }
}
