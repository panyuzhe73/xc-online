package com.xuecheng.content.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 课程发布
 * @TableName course_publish
 */
@TableName(value ="course_publish")
public class CoursePublish implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 机构ID
     */
    private Long companyId;

    /**
     * 公司名称
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
     * 标签
     */
    private String tags;

    /**
     * 创建人
     */
    private String username;

    /**
     * 大分类
     */
    private String mt;

    /**
     * 大分类名称
     */
    private String mtName;

    /**
     * 小分类
     */
    private String st;

    /**
     * 小分类名称
     */
    private String stName;

    /**
     * 课程等级
     */
    private String grade;

    /**
     * 教育模式
     */
    private String teachmode;

    /**
     * 课程图片
     */
    private String pic;

    /**
     * 课程介绍
     */
    private String description;

    /**
     * 课程营销信息，json格式
     */
    private String market;

    /**
     * 所有课程计划，json格式
     */
    private String teachplan;

    /**
     * 教师信息，json格式
     */
    private String teachers;

    /**
     * 发布时间
     */
    private Date createDate;

    /**
     * 上架时间
     */
    private Date onlineDate;

    /**
     * 下架时间
     */
    private Date offlineDate;

    /**
     * 发布状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 收费规则，对应数据字典--203
     */
    private String charge;

    /**
     * 现价
     */
    private Double price;

    /**
     * 原价
     */
    private Double originalPrice;

    /**
     * 课程有效期天数
     */
    private Integer validDays;

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
     * 公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 公司名称
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
     * 标签
     */
    public String getTags() {
        return tags;
    }

    /**
     * 标签
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * 创建人
     */
    public String getUsername() {
        return username;
    }

    /**
     * 创建人
     */
    public void setUsername(String username) {
        this.username = username;
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
     * 大分类名称
     */
    public String getMtName() {
        return mtName;
    }

    /**
     * 大分类名称
     */
    public void setMtName(String mtName) {
        this.mtName = mtName;
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
     * 小分类名称
     */
    public String getStName() {
        return stName;
    }

    /**
     * 小分类名称
     */
    public void setStName(String stName) {
        this.stName = stName;
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
     * 教育模式
     */
    public String getTeachmode() {
        return teachmode;
    }

    /**
     * 教育模式
     */
    public void setTeachmode(String teachmode) {
        this.teachmode = teachmode;
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
     * 课程营销信息，json格式
     */
    public String getMarket() {
        return market;
    }

    /**
     * 课程营销信息，json格式
     */
    public void setMarket(String market) {
        this.market = market;
    }

    /**
     * 所有课程计划，json格式
     */
    public String getTeachplan() {
        return teachplan;
    }

    /**
     * 所有课程计划，json格式
     */
    public void setTeachplan(String teachplan) {
        this.teachplan = teachplan;
    }

    /**
     * 教师信息，json格式
     */
    public String getTeachers() {
        return teachers;
    }

    /**
     * 教师信息，json格式
     */
    public void setTeachers(String teachers) {
        this.teachers = teachers;
    }

    /**
     * 发布时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 发布时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 上架时间
     */
    public Date getOnlineDate() {
        return onlineDate;
    }

    /**
     * 上架时间
     */
    public void setOnlineDate(Date onlineDate) {
        this.onlineDate = onlineDate;
    }

    /**
     * 下架时间
     */
    public Date getOfflineDate() {
        return offlineDate;
    }

    /**
     * 下架时间
     */
    public void setOfflineDate(Date offlineDate) {
        this.offlineDate = offlineDate;
    }

    /**
     * 发布状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 发布状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 收费规则，对应数据字典--203
     */
    public String getCharge() {
        return charge;
    }

    /**
     * 收费规则，对应数据字典--203
     */
    public void setCharge(String charge) {
        this.charge = charge;
    }

    /**
     * 现价
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 现价
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 原价
     */
    public Double getOriginalPrice() {
        return originalPrice;
    }

    /**
     * 原价
     */
    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * 课程有效期天数
     */
    public Integer getValidDays() {
        return validDays;
    }

    /**
     * 课程有效期天数
     */
    public void setValidDays(Integer validDays) {
        this.validDays = validDays;
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
        CoursePublish other = (CoursePublish) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUsers() == null ? other.getUsers() == null : this.getUsers().equals(other.getUsers()))
            && (this.getTags() == null ? other.getTags() == null : this.getTags().equals(other.getTags()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getMt() == null ? other.getMt() == null : this.getMt().equals(other.getMt()))
            && (this.getMtName() == null ? other.getMtName() == null : this.getMtName().equals(other.getMtName()))
            && (this.getSt() == null ? other.getSt() == null : this.getSt().equals(other.getSt()))
            && (this.getStName() == null ? other.getStName() == null : this.getStName().equals(other.getStName()))
            && (this.getGrade() == null ? other.getGrade() == null : this.getGrade().equals(other.getGrade()))
            && (this.getTeachmode() == null ? other.getTeachmode() == null : this.getTeachmode().equals(other.getTeachmode()))
            && (this.getPic() == null ? other.getPic() == null : this.getPic().equals(other.getPic()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getMarket() == null ? other.getMarket() == null : this.getMarket().equals(other.getMarket()))
            && (this.getTeachplan() == null ? other.getTeachplan() == null : this.getTeachplan().equals(other.getTeachplan()))
            && (this.getTeachers() == null ? other.getTeachers() == null : this.getTeachers().equals(other.getTeachers()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getOnlineDate() == null ? other.getOnlineDate() == null : this.getOnlineDate().equals(other.getOnlineDate()))
            && (this.getOfflineDate() == null ? other.getOfflineDate() == null : this.getOfflineDate().equals(other.getOfflineDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCharge() == null ? other.getCharge() == null : this.getCharge().equals(other.getCharge()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getOriginalPrice() == null ? other.getOriginalPrice() == null : this.getOriginalPrice().equals(other.getOriginalPrice()))
            && (this.getValidDays() == null ? other.getValidDays() == null : this.getValidDays().equals(other.getValidDays()));
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
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getMt() == null) ? 0 : getMt().hashCode());
        result = prime * result + ((getMtName() == null) ? 0 : getMtName().hashCode());
        result = prime * result + ((getSt() == null) ? 0 : getSt().hashCode());
        result = prime * result + ((getStName() == null) ? 0 : getStName().hashCode());
        result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
        result = prime * result + ((getTeachmode() == null) ? 0 : getTeachmode().hashCode());
        result = prime * result + ((getPic() == null) ? 0 : getPic().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getMarket() == null) ? 0 : getMarket().hashCode());
        result = prime * result + ((getTeachplan() == null) ? 0 : getTeachplan().hashCode());
        result = prime * result + ((getTeachers() == null) ? 0 : getTeachers().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getOnlineDate() == null) ? 0 : getOnlineDate().hashCode());
        result = prime * result + ((getOfflineDate() == null) ? 0 : getOfflineDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCharge() == null) ? 0 : getCharge().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getOriginalPrice() == null) ? 0 : getOriginalPrice().hashCode());
        result = prime * result + ((getValidDays() == null) ? 0 : getValidDays().hashCode());
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
        sb.append(", username=").append(username);
        sb.append(", mt=").append(mt);
        sb.append(", mtName=").append(mtName);
        sb.append(", st=").append(st);
        sb.append(", stName=").append(stName);
        sb.append(", grade=").append(grade);
        sb.append(", teachmode=").append(teachmode);
        sb.append(", pic=").append(pic);
        sb.append(", description=").append(description);
        sb.append(", market=").append(market);
        sb.append(", teachplan=").append(teachplan);
        sb.append(", teachers=").append(teachers);
        sb.append(", createDate=").append(createDate);
        sb.append(", onlineDate=").append(onlineDate);
        sb.append(", offlineDate=").append(offlineDate);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", charge=").append(charge);
        sb.append(", price=").append(price);
        sb.append(", originalPrice=").append(originalPrice);
        sb.append(", validDays=").append(validDays);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
