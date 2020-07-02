package hnit.llc.cpms.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 房屋表
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
public class House extends Model<House> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "houseId", type = IdType.UUID)
    private String houseId;

    @TableField("houseNum")
    private int houseNum;

    @TableField("houseLevel")
    private int houseLevel;

    private String hstatus;

    @TableField("inTime")
    private String inTime;

    @NotBlank(message = "楼栋外键不能位空")
    @TableField("buId")
    private String buId;

    @TableField(exist = false, value = "buNumber")
    private int buNumber;

    @TableField(exist = false)
    private int buUnit;


    public int getBuUnit() {
        return buUnit;
    }

    public void setBuUnit(int buUnit) {
        this.buUnit = buUnit;
    }

    public int getBuNumber() {
        return buNumber;
    }

    public void setBuNumber(int buNumber) {
        this.buNumber = buNumber;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public int getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(int houseNum) {
        this.houseNum = houseNum;
    }

    public int getHouseLevel() {
        return houseLevel;
    }

    public void setHouseLevel(int houseLevel) {
        this.houseLevel = houseLevel;
    }

    public String getHstatus() {
        return hstatus;
    }

    public void setHstatus(String status) {
        this.hstatus = status;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getBuId() {
        return buId;
    }

    public void setBuId(String buId) {
        this.buId = buId;
    }



    @Override
    protected Serializable pkVal() {
        return this.houseId;
    }

    @Override
    public String toString() {
        return "House{" +
                "houseId='" + houseId + '\'' +
                ", houseNum='" + houseNum + '\'' +
                ", houseLevel='" + houseLevel + '\'' +
                ", hstatus='" + hstatus + '\'' +
                ", inTime='" + inTime + '\'' +
                ", buId='" + buId + '\'' +
                ", buNumber='" + buNumber + '\'' +
                ", buUnit='" + buUnit + '\'' +
                '}';
    }
}
