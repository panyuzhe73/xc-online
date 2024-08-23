package com.xuecheng.content.model;

import com.xuecheng.content.domain.Teachplan;
import com.xuecheng.content.domain.TeachplanMedia;
import lombok.Data;

import java.util.List;

@Data
public class TeachplanDto extends Teachplan {

    //子节点
    private List<TeachplanDto> teachPlanTreeNodes;

    //课程计划关联的媒资信息
    private TeachplanMedia teachplanMedia;
}
