package com.xuecheng.content.api;



import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.model.QueryCourseParamsDto;
import com.xuecheng.content.model.domain.CourseBase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 课程信息编辑接口
 */
@RestController
public class CourseBaseInfoController {


    @PostMapping("/course/list")
    public PageResult<CourseBase> list(PageParams pageParams,  @RequestBody QueryCourseParamsDto queryCourseParams){

        return null;

    }
}
