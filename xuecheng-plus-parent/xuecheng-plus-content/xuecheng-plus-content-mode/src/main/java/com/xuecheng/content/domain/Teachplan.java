package com.xuecheng.content.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 课程计划
 * @TableName teachplan
 */
@TableName(value ="teachplan")
public class Teachplan implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 课程计划名称
     */
    private String pname;

    /**
     * 课程计划父级Id
     */
    private Long parentid;

    /**
     * 层级，分为1、2、3级
     */
    private Integer grade;

    /**
     * 课程类型:1视频、2文档
     */
    private String mediaType;

    /**
     * 开始直播时间
     */
    private Date startTime;

    /**
     * 直播结束时间
     */
    private Date endTime;

    /**
     * 章节及课程时介绍
     */
    private String description;

    /**
     * 时长，单位时:分:秒
     */
    private String timelength;

    /**
     * 排序字段
     */
    private Integer orderby;

    /**
     * 课程标识
     */
    private Long courseId;

    /**
     * 课程发布标识
     */
    private Long coursePubId;

    /**
     * 状态（1正常  0删除）
     */
    private Integer status;

    /**
     * 是否支持试学或预览（试看）
     */
    private String isPreview;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date changeDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public Long getId() {
        return id;
    }

    /**
     *
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 课程计划名称
     */
    public String getPname() {
        return pname;
    }

    /**
     * 课程计划名称
     */
    public void setPname(String pname) {
        this.pname = pname;
    }

    /**
     * 课程计划父级Id
     */
    public  Long getParentid() {
        return parentid;
    }

    /**
     * 课程计划父级Id
     */
    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    /**
     * 层级，分为1、2、3级
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * 层级，分为1、2、3级
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * 课程类型:1视频、2文档
     */
    public String getMediaType() {
        return mediaType;
    }

    /**
     * 课程类型:1视频、2文档
     */
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    /**
     * 开始直播时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 开始直播时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 直播结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 直播结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 章节及课程时介绍
     */
    public String getDescription() {
        return description;
    }

    /**
     * 章节及课程时介绍
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 时长，单位时:分:秒
     */
    public String getTimelength() {
        return timelength;
    }

    /**
     * 时长，单位时:分:秒
     */
    public void setTimelength(String timelength) {
        this.timelength = timelength;
    }

    /**
     * 排序字段
     */
    public Integer getOrderby() {
        return orderby;
    }

    /**
     * 排序字段
     */
    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    /**
     * 课程标识
     */
    public Long getCourseId() {
        return courseId;
    }

    /**
     * 课程标识
     */
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    /**
     * 课程发布标识
     */
    public Long getCoursePubId() {
        return coursePubId;
    }

    /**
     * 课程发布标识
     */
    public void setCoursePubId(Long coursePubId) {
        this.coursePubId = coursePubId;
    }

    /**
     * 状态（1正常  0删除）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态（1正常  0删除）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 是否支持试学或预览（试看）
     */
    public String getIsPreview() {
        return isPreview;
    }

    /**
     * 是否支持试学或预览（试看）
     */
    public void setIsPreview(String isPreview) {
        this.isPreview = isPreview;
    }

    /**
     * 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 修改时间
     */
    public Date getChangeDate() {
        return changeDate;
    }

    /**
     * 修改时间
     */
    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Teachplan other = (Teachplan) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPname() == null ? other.getPname() == null : this.getPname().equals(other.getPname()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getGrade() == null ? other.getGrade() == null : this.getGrade().equals(other.getGrade()))
            && (this.getMediaType() == null ? other.getMediaType() == null : this.getMediaType().equals(other.getMediaType()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getTimelength() == null ? other.getTimelength() == null : this.getTimelength().equals(other.getTimelength()))
            && (this.getOrderby() == null ? other.getOrderby() == null : this.getOrderby().equals(other.getOrderby()))
            && (this.getCourseId() == null ? other.getCourseId() == null : this.getCourseId().equals(other.getCourseId()))
            && (this.getCoursePubId() == null ? other.getCoursePubId() == null : this.getCoursePubId().equals(other.getCoursePubId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIsPreview() == null ? other.getIsPreview() == null : this.getIsPreview().equals(other.getIsPreview()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getChangeDate() == null ? other.getChangeDate() == null : this.getChangeDate().equals(other.getChangeDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPname() == null) ? 0 : getPname().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
        result = prime * result + ((getMediaType() == null) ? 0 : getMediaType().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getTimelength() == null) ? 0 : getTimelength().hashCode());
        result = prime * result + ((getOrderby() == null) ? 0 : getOrderby().hashCode());
        result = prime * result + ((getCourseId() == null) ? 0 : getCourseId().hashCode());
        result = prime * result + ((getCoursePubId() == null) ? 0 : getCoursePubId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIsPreview() == null) ? 0 : getIsPreview().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getChangeDate() == null) ? 0 : getChangeDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pname=").append(pname);
        sb.append(", parentid=").append(parentid);
        sb.append(", grade=").append(grade);
        sb.append(", mediaType=").append(mediaType);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", description=").append(description);
        sb.append(", timelength=").append(timelength);
        sb.append(", orderby=").append(orderby);
        sb.append(", courseId=").append(courseId);
        sb.append(", coursePubId=").append(coursePubId);
        sb.append(", status=").append(status);
        sb.append(", isPreview=").append(isPreview);
        sb.append(", createDate=").append(createDate);
        sb.append(", changeDate=").append(changeDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }



}
