package hnit.llc.cpms.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 物业费表
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
public class Propercost extends Model<Propercost> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "prid", type = IdType.UUID)
    private String prid;

    @NotBlank(message = "电梯使用费不能为空")
    @TableField("elevatorCost")
    private String elevatorCost;

    @TableField("garbageCost")
    private String garbageCost;

    @TableField("lightingCost")
    private String lightingCost;

    @TableField("beginTime")
    private String beginTime;

    @TableField("endTime")
    private String endTime;

    private String pstatus;

    @TableField("ownerId")
    private String ownerId;

    @TableField(exist = false)
    private String ownerName;

    private String money;



    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getPrid() {
        return prid;
    }

    public void setPrid(String prid) {
        this.prid = prid;
    }

    public String getElevatorCost() {
        return elevatorCost;
    }

    public void setElevatorCost(String elevatorCost) {
        this.elevatorCost = elevatorCost;
    }

    public String getGarbageCost() {
        return garbageCost;
    }

    public void setGarbageCost(String garbageCost) {
        this.garbageCost = garbageCost;
    }

    public String getLightingCost() {
        return lightingCost;
    }

    public void setLightingCost(String lightingCost) {
        this.lightingCost = lightingCost;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String status) {
        this.pstatus = status;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }


    @Override
    protected Serializable pkVal() {
        return this.prid;
    }

    @Override
    public String toString() {
        return "Propercost{" +
                "prid='" + prid + '\'' +
                ", elevatorCost='" + elevatorCost + '\'' +
                ", garbageCost='" + garbageCost + '\'' +
                ", lightingCost='" + lightingCost + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", pstatus='" + pstatus + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
