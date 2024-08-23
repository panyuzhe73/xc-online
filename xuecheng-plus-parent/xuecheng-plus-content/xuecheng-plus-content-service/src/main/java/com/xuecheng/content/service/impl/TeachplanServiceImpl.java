package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xuecheng.base.exception.XueChengPlusException;
import com.xuecheng.content.domain.TeachplanMedia;
import com.xuecheng.content.mapper.TeachplanMapper;
import com.xuecheng.content.domain.Teachplan;
import com.xuecheng.content.mapper.TeachplanMediaMapper;
import com.xuecheng.content.model.SaveTeachplanDto;
import com.xuecheng.content.model.TeachplanDto;
import com.xuecheng.content.service.TeachplanService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author TNCN
* @description 针对表【teachplan(课程计划)】的数据库操作Service实现
* @createDate 2024-08-15 11:11:08
*/
@Service
public class TeachplanServiceImpl extends ServiceImpl<TeachplanMapper, Teachplan>
    implements TeachplanService {

    @Autowired
    private TeachplanMapper teachplanMapper;

    @Autowired
    private TeachplanMediaMapper teachplanMediaMapper;
    @Override
    public List<TeachplanDto> findTeachplanTree(Long courseId) {
        return teachplanMapper.selectTreeNodes(courseId);
    }

    @Override
    public void saveTeachplan(SaveTeachplanDto saveTeachplanDto) {
        //课程计划id
        Long id = saveTeachplanDto.getId();
        //修改课程计划
        if(id != null){
            Teachplan teachplan = teachplanMapper.selectById(id);
            BeanUtils.copyProperties(saveTeachplanDto, teachplan);
           teachplanMapper.updateById(teachplan);
        }else{
            //取出同父同级别的课程计划数量
            int count = getTeachplanCount(saveTeachplanDto.getParentid(), saveTeachplanDto.getGrade());
            Teachplan teachplan = new Teachplan();

            teachplan.setOrderby(count+1);
            BeanUtils.copyProperties(saveTeachplanDto,teachplan);
            teachplanMapper.insert(teachplan);
        }
    }


    /**
     * 获取最新的排序号
     * @param parentid
     * @param grade
     * @return
     */
    private int getTeachplanCount(Long parentid, Integer grade) {

        LambdaQueryWrapper<Teachplan> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(Teachplan::getParentid,parentid);
        queryWrapper.eq(Teachplan::getGrade,grade);
        queryWrapper.orderByDesc(Teachplan::getOrderby);
        queryWrapper.last("limit 0,1");
        Teachplan teachplan = teachplanMapper.selectOne(queryWrapper);
        return teachplan.getOrderby();

    }
    @Override
    public void deleteTeachplan(Long courseId) {

        //查询要删除的课程信息
        Teachplan teachplan = teachplanMapper.selectById(courseId);

        //如果是小章节删除关联的媒资信息
        if(teachplan.getGrade().intValue() == 2){
            LambdaQueryWrapper<TeachplanMedia> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(TeachplanMedia::getTeachplanId,teachplan.getId());
            TeachplanMedia teachplanMedia = teachplanMediaMapper.selectOne(queryWrapper);
            if(teachplanMedia != null){
                teachplanMediaMapper.deleteById(teachplanMedia.getId());
            }
            teachplanMapper.deleteById(teachplan.getId());
        }else {
            LambdaQueryWrapper<Teachplan> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Teachplan::getParentid,teachplan.getId());
            Integer i = teachplanMapper.selectCount(wrapper);
            if(i > 0){
                XueChengPlusException.cast("课程计划信息还有子级信息，无法操作");
            }
            teachplanMapper.deleteById(teachplan.getId());
        }
    }

    @Override
    @Transactional
    public void moveTeachplan(Long id,String movetype) {
        Teachplan teachplan = teachplanMapper.selectById(id);

        LambdaQueryWrapper<Teachplan> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Teachplan::getParentid,teachplan.getParentid()).eq(Teachplan::getCourseId,teachplan.getCourseId());
        if(movetype.equals("moveup")){
            queryWrapper.lt(Teachplan::getOrderby,teachplan.getOrderby()).orderByDesc(Teachplan::getOrderby);
        }else{
            queryWrapper.gt(Teachplan::getOrderby,teachplan.getOrderby()).orderByDesc(Teachplan::getOrderby);
        }

        Teachplan teachplanUp = teachplanMapper.selectOne(queryWrapper);
        if(teachplanUp != null ){
            int orderBy = teachplanUp.getOrderby();
            teachplanUp.setOrderby(teachplan.getOrderby());
            teachplan.setOrderby(orderBy);
            teachplanMapper.updateById(teachplanUp);
            teachplanMapper.updateById(teachplan);
        }else{
            if(movetype.equals("moveup")){
                XueChengPlusException.cast("当前排序已经是第一个了");
            }else{
                XueChengPlusException.cast("当前排序已经是最后一个了");
            }
        }
    }
}




