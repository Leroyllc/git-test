package hnit.llc.cpms.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 投诉表
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
public class Complaint extends Model<Complaint> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "comid", type = IdType.UUID)
    private String comid;

    @TableField("comItem")
    private String comItem;

    @TableField("comTime")
    private String comTime;

    @TableField("pTime")
    private String pTime;

    @TableField("pName")
    private String pName;

    private String cstatus;

    @TableField("ownerId")
    private String ownerId;

    @TableField(exist = false)
    private String ownerName;

    @TableField(exist = false)
    private String tel;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }


    public String getComid() {
        return comid;
    }

    public void setComid(String comid) {
        this.comid = comid;
    }

    public String getComItem() {
        return comItem;
    }

    public void setComItem(String comItem) {
        this.comItem = comItem;
    }

    public String getComTime() {
        return comTime;
    }

    public void setComTime(String comTime) {
        this.comTime = comTime;
    }

    public String getpTime() {
        return pTime;
    }

    public void setpTime(String pTime) {
        this.pTime = pTime;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getCstatus() {
        return cstatus;
    }

    public void setCstatus(String status) {
        this.cstatus = status;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    protected Serializable pkVal() {
        return this.comid;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "comid='" + comid + '\'' +
                ", comItem='" + comItem + '\'' +
                ", comTime='" + comTime + '\'' +
                ", pTime='" + pTime + '\'' +
                ", pName='" + pName + '\'' +
                ", cstatus='" + cstatus + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
