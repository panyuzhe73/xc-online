package com.xuecheng.content.api;

import com.xuecheng.content.model.SaveTeachplanDto;
import com.xuecheng.content.model.TeachplanDto;
import com.xuecheng.content.service.TeachplanService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class TeachplanController {

    @Resource
    private TeachplanService teachplanService;
    @ApiOperation("查询课程计划树形结构")
    @ApiImplicitParam(value = "课程id",required = true,dataType = "Long",name = "courseId",paramType = "path")
    @GetMapping("/teachplan/{courseId}/tree-nodes")
    public List<TeachplanDto> getTreeNodes(@PathVariable Long courseId){
        return teachplanService.findTeachplanTree(courseId);
    }

    @ApiOperation("课程计划创建或修改")
    @PostMapping("/teachplan")
    public void saveTeachplan(@RequestBody SaveTeachplanDto saveTeachplanDto){
        teachplanService.saveTeachplan(saveTeachplanDto);
    }

    @ApiOperation("课程计划删除")
    @DeleteMapping("/teachplan/{courseId}")
    public void deleteTeachplan(@PathVariable Long courseId){
        teachplanService.deleteTeachplan(courseId);
    }

    @ApiOperation("课程计划上移")
    @PostMapping("/teachplan/moveup/{id}")
    public void moveUpTeachplan(@PathVariable Long id){
        teachplanService.moveTeachplan(id,"moveup");
    }

    @ApiOperation("课程计划下移")
    @PostMapping("/teachplan/movedown/{id}")
    public void moveDownTeachplan(@PathVariable Long id){
        teachplanService.moveTeachplan(id,"movedown");
    }
}
