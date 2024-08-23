package com.xuecheng.content.model;

import com.xuecheng.content.domain.CourseCategory;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 课程分类树型节点DTO
 */
@Data
public class CourseCategoryTreeDto extends CourseCategory implements Serializable {
    private List<CourseCategoryTreeDto> ChildrenTreeNodes;
}
