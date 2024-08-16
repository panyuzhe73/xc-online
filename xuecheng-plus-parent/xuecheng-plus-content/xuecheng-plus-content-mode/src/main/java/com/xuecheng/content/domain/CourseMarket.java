package com.xuecheng.content.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 课程营销信息
 * @TableName course_market
 */
@TableName(value ="course_market")
public class CourseMarket implements Serializable {
    /**
     * 主键，课程id
     */
    @TableId
    private Long id;

    /**
     * 收费规则，对应数据字典
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
     * 咨询qq
     */
    private String qq;

    /**
     * 微信
     */
    private String wechat;

    /**
     * 电话
     */
    private String phone;

    /**
     * 有效期天数
     */
    private Integer validDays;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键，课程id
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键，课程id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 收费规则，对应数据字典
     */
    public String getCharge() {
        return charge;
    }

    /**
     * 收费规则，对应数据字典
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
     * 咨询qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * 咨询qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 微信
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * 微信
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    /**
     * 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 有效期天数
     */
    public Integer getValidDays() {
        return validDays;
    }

    /**
     * 有效期天数
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
        CourseMarket other = (CourseMarket) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCharge() == null ? other.getCharge() == null : this.getCharge().equals(other.getCharge()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getOriginalPrice() == null ? other.getOriginalPrice() == null : this.getOriginalPrice().equals(other.getOriginalPrice()))
            && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
            && (this.getWechat() == null ? other.getWechat() == null : this.getWechat().equals(other.getWechat()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getValidDays() == null ? other.getValidDays() == null : this.getValidDays().equals(other.getValidDays()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCharge() == null) ? 0 : getCharge().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getOriginalPrice() == null) ? 0 : getOriginalPrice().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getWechat() == null) ? 0 : getWechat().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
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
        sb.append(", charge=").append(charge);
        sb.append(", price=").append(price);
        sb.append(", originalPrice=").append(originalPrice);
        sb.append(", qq=").append(qq);
        sb.append(", wechat=").append(wechat);
        sb.append(", phone=").append(phone);
        sb.append(", validDays=").append(validDays);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
