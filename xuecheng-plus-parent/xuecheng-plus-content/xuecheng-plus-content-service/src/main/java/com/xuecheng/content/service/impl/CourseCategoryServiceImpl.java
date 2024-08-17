package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xuecheng.content.mapper.CourseCategoryMapper;
import com.xuecheng.content.domain.CourseCategory;
import com.xuecheng.content.model.CourseCategoryTreeDto;
import com.xuecheng.content.service.CourseCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @author TNCN
* @description 针对表【course_category(课程分类)】的数据库操作Service实现
* @createDate 2024-08-15 11:11:08
*/
@Service
public class CourseCategoryServiceImpl extends ServiceImpl<CourseCategoryMapper, CourseCategory>
    implements CourseCategoryService {

    @Resource
    CourseCategoryMapper courseCategoryMapper;
    @Override
    public List<CourseCategoryTreeDto> queryTreeNodes(String id) {
        List<CourseCategoryTreeDto> courseCategoryTreeDtos = courseCategoryMapper.selectTreeNodes(id);
        //将list转为map
        Map<String, CourseCategoryTreeDto> mapTemp = courseCategoryTreeDtos.stream().filter(item -> !id.equals(item.getId())).collect(Collectors.toMap(key -> key.getId(), value -> value, (key1, key2) -> key2));

        //最终返回的list
        ArrayList<CourseCategoryTreeDto> categoryTreeDtos = new ArrayList<>();

        courseCategoryTreeDtos.stream().filter(item->!id.equals(item.getId())).forEach(item->{
            if(item.getParentid().equals(id)){
                categoryTreeDtos.add(item);
            }

            CourseCategoryTreeDto categoryTreeDto = mapTemp.get(item.getParentid());
            if(categoryTreeDto != null){
                if(categoryTreeDto.getChildrenTreeNodes()==null){
                    categoryTreeDto.setChildrenTreeNodes(new ArrayList<>());
                }
                categoryTreeDto.getChildrenTreeNodes().add(item);
            }


        });
        return categoryTreeDtos;
    }
}




