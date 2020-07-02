package hnit.llc.cpms.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 业主表
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
public class Owner extends Model<Owner> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ownerId", type = IdType.UUID)
    private String ownerId;

    @NotBlank(message = "业主名称不能为空")
    @TableField("ownerName")
    private String ownerName;
    @NotBlank(message = "性别不能为空")
    private String sex;
    @NotBlank(message = "联系电话不能为空")
    private String tel;
    @NotBlank(message = "紧急联系电话不能为空")
    private String phone;

    @TableField("houseId")
    private String houseId;

    @TableField(exist = false)
    private String houseNum;

    @TableField(exist = false)
    private String buId;

    @TableField(exist = false)
    private String buNumber;

    @TableField(exist = false)
    private String buUnit;

    @TableField(exist = false)
    private String carsiteNumber;

    public String getCarsiteNumber() {
        return carsiteNumber;
    }

    public void setCarsiteNumber(String carsiteNumber) {
        this.carsiteNumber = carsiteNumber;
    }

    public String getBuUnit() {

        return buUnit;
    }

    public void setBuUnit(String buUnit) {
        this.buUnit = buUnit;
    }

    public String getBuId() {
        return buId;
    }

    public void setBuId(String buId) {
        this.buId = buId;
    }

    public String getBuNumber() {
        return buNumber;
    }

    public void setBuNumber(String buNumber) {
        this.buNumber = buNumber;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }


    @Override
    protected Serializable pkVal() {
        return this.ownerId;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId='" + ownerId + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", phone='" + phone + '\'' +
                ", houseId='" + houseId + '\'' +
                ", houseNum='" + houseNum + '\'' +
                ", buNumber='" + buNumber + '\'' +
                '}';
    }
}
