package com.xuecheng.content.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 课程分类
 * @TableName course_category
 */
@TableName(value ="course_category")
public class CourseCategory implements Serializable {
    /**
     * 主键
     */
    @TableId
    private String id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 分类标签默认和名称一样
     */
    private String label;

    /**
     * 父结点id（第一级的父节点是0，自关联字段id）
     */
    private String parentid;

    /**
     * 是否显示
     */
    private Integer isShow;

    /**
     * 排序字段
     */
    private Integer orderby;

    /**
     * 是否叶子
     */
    private Integer isLeaf;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 分类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 分类标签默认和名称一样
     */
    public String getLabel() {
        return label;
    }

    /**
     * 分类标签默认和名称一样
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 父结点id（第一级的父节点是0，自关联字段id）
     */
    public String getParentid() {
        return parentid;
    }

    /**
     * 父结点id（第一级的父节点是0，自关联字段id）
     */
    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    /**
     * 是否显示
     */
    public Integer getIsShow() {
        return isShow;
    }

    /**
     * 是否显示
     */
    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
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
     * 是否叶子
     */
    public Integer getIsLeaf() {
        return isLeaf;
    }

    /**
     * 是否叶子
     */
    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
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
        CourseCategory other = (CourseCategory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getLabel() == null ? other.getLabel() == null : this.getLabel().equals(other.getLabel()))
            && (this.getParentid() == null ? other.getParentid() == null : this.getParentid().equals(other.getParentid()))
            && (this.getIsShow() == null ? other.getIsShow() == null : this.getIsShow().equals(other.getIsShow()))
            && (this.getOrderby() == null ? other.getOrderby() == null : this.getOrderby().equals(other.getOrderby()))
            && (this.getIsLeaf() == null ? other.getIsLeaf() == null : this.getIsLeaf().equals(other.getIsLeaf()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getLabel() == null) ? 0 : getLabel().hashCode());
        result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
        result = prime * result + ((getIsShow() == null) ? 0 : getIsShow().hashCode());
        result = prime * result + ((getOrderby() == null) ? 0 : getOrderby().hashCode());
        result = prime * result + ((getIsLeaf() == null) ? 0 : getIsLeaf().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", label=").append(label);
        sb.append(", parentid=").append(parentid);
        sb.append(", isShow=").append(isShow);
        sb.append(", orderby=").append(orderby);
        sb.append(", isLeaf=").append(isLeaf);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
