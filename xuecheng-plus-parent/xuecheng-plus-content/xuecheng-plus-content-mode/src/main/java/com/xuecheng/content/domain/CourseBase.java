package com.xuecheng.content.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 课程基本信息
 * @TableName course_base
 */


@TableName(value ="course_base")
public class CourseBase implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 机构ID
     */
    private Long companyId;

    /**
     * 机构名称
     */
    private String companyName;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 适用人群
     */
    private String users;

    /**
     * 课程标签
     */
    private String tags;

    /**
     * 大分类
     */
    private String mt;

    /**
     * 小分类
     */
    private String st;

    /**
     * 课程等级
     */
    private String grade;

    /**
     * 教育模式(common普通，record 录播，live直播等）
     */
    private String teachmode;

    /**
     * 课程介绍
     */
    private String description;

    /**
     * 课程图片
     */
    private String pic;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date changeDate;

    /**
     * 创建人
     */
    private String createPeople;

    /**
     * 更新人
     */
    private String changePeople;

    /**
     * 审核状态
     */
    private String auditStatus;

    /**
     * 课程发布状态 未发布  已发布 下线
     */
    private String status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 机构ID
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 机构ID
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 机构名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 机构名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 课程名称
     */
    public String getName() {
        return name;
    }

    /**
     * 课程名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 适用人群
     */
    public String getUsers() {
        return users;
    }

    /**
     * 适用人群
     */
    public void setUsers(String users) {
        this.users = users;
    }

    /**
     * 课程标签
     */
    public String getTags() {
        return tags;
    }

    /**
     * 课程标签
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * 大分类
     */
    public String getMt() {
        return mt;
    }

    /**
     * 大分类
     */
    public void setMt(String mt) {
        this.mt = mt;
    }

    /**
     * 小分类
     */
    public String getSt() {
        return st;
    }

    /**
     * 小分类
     */
    public void setSt(String st) {
        this.st = st;
    }

    /**
     * 课程等级
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 课程等级
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * 教育模式(common普通，record 录播，live直播等）
     */
    public String getTeachmode() {
        return teachmode;
    }

    /**
     * 教育模式(common普通，record 录播，live直播等）
     */
    public void setTeachmode(String teachmode) {
        this.teachmode = teachmode;
    }

    /**
     * 课程介绍
     */
    public String getDescription() {
        return description;
    }

    /**
     * 课程介绍
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 课程图片
     */
    public String getPic() {
        return pic;
    }

    /**
     * 课程图片
     */
    public void setPic(String pic) {
        this.pic = pic;
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

    /**
     * 创建人
     */
    public String getCreatePeople() {
        return createPeople;
    }

    /**
     * 创建人
     */
    public void setCreatePeople(String createPeople) {
        this.createPeople = createPeople;
    }

    /**
     * 更新人
     */
    public String getChangePeople() {
        return changePeople;
    }

    /**
     * 更新人
     */
    public void setChangePeople(String changePeople) {
        this.changePeople = changePeople;
    }

    /**
     * 审核状态
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * 审核状态
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 课程发布状态 未发布  已发布 下线
     */
    public String getStatus() {
        return status;
    }

    /**
     * 课程发布状态 未发布  已发布 下线
     */
    public void setStatus(String status) {
        this.status = status;
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
        CourseBase other = (CourseBase) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUsers() == null ? other.getUsers() == null : this.getUsers().equals(other.getUsers()))
            && (this.getTags() == null ? other.getTags() == null : this.getTags().equals(other.getTags()))
            && (this.getMt() == null ? other.getMt() == null : this.getMt().equals(other.getMt()))
            && (this.getSt() == null ? other.getSt() == null : this.getSt().equals(other.getSt()))
            && (this.getGrade() == null ? other.getGrade() == null : this.getGrade().equals(other.getGrade()))
            && (this.getTeachmode() == null ? other.getTeachmode() == null : this.getTeachmode().equals(other.getTeachmode()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getPic() == null ? other.getPic() == null : this.getPic().equals(other.getPic()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getChangeDate() == null ? other.getChangeDate() == null : this.getChangeDate().equals(other.getChangeDate()))
            && (this.getCreatePeople() == null ? other.getCreatePeople() == null : this.getCreatePeople().equals(other.getCreatePeople()))
            && (this.getChangePeople() == null ? other.getChangePeople() == null : this.getChangePeople().equals(other.getChangePeople()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUsers() == null) ? 0 : getUsers().hashCode());
        result = prime * result + ((getTags() == null) ? 0 : getTags().hashCode());
        result = prime * result + ((getMt() == null) ? 0 : getMt().hashCode());
        result = prime * result + ((getSt() == null) ? 0 : getSt().hashCode());
        result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
        result = prime * result + ((getTeachmode() == null) ? 0 : getTeachmode().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getPic() == null) ? 0 : getPic().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getChangeDate() == null) ? 0 : getChangeDate().hashCode());
        result = prime * result + ((getCreatePeople() == null) ? 0 : getCreatePeople().hashCode());
        result = prime * result + ((getChangePeople() == null) ? 0 : getChangePeople().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", companyId=").append(companyId);
        sb.append(", companyName=").append(companyName);
        sb.append(", name=").append(name);
        sb.append(", users=").append(users);
        sb.append(", tags=").append(tags);
        sb.append(", mt=").append(mt);
        sb.append(", st=").append(st);
        sb.append(", grade=").append(grade);
        sb.append(", teachmode=").append(teachmode);
        sb.append(", description=").append(description);
        sb.append(", pic=").append(pic);
        sb.append(", createDate=").append(createDate);
        sb.append(", changeDate=").append(changeDate);
        sb.append(", createPeople=").append(createPeople);
        sb.append(", changePeople=").append(changePeople);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
