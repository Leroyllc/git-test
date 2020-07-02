package hnit.llc.cpms.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 车位收费表
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
public class Carsitecost extends Model<Carsitecost> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "carsitecostId", type = IdType.UUID)
    private String carsitecostId;

    private String cost;

    @TableField("beginTime")
    private String beginTime;

    @TableField("endTime")
    private String endTime;

    @TableField("ownerId")
    private String ownerId;

    @TableField(exist = false)
    private String ownerName;

    private String cscstatus;



    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCarsitecostId() {
        return carsitecostId;
    }

    public void setCarsitecostId(String carsitecostId) {
        this.carsitecostId = carsitecostId;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
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

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getCscstatus() {
        return cscstatus;
    }

    public void setCscstatus(String status) {
        this.cscstatus = status;
    }


    @Override
    protected Serializable pkVal() {
        return this.carsitecostId;
    }

    @Override
    public String toString() {
        return "Carsitecost{" +
                "carsitecostId='" + carsitecostId + '\'' +
                ", cost='" + cost + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", cscstatus='" + cscstatus + '\'' +
                '}';
    }
}
