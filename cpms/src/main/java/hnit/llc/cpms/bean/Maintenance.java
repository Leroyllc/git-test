package hnit.llc.cpms.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
/**
 * <p>
 * 报修表
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
public class Maintenance extends Model<Maintenance> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "mId", type = IdType.UUID)
    private String mId;

    private String mitem;

    private String mtime;

    private String ptime;

    private String cost;

    private String mstatus;

    private String pname;

    @TableField("ownerId")
    private String ownerId;

    @TableField(exist = false)
    private String ownerName;

    @TableField(exist = false)
    private String tel;



    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getMitem() {
        return mitem;
    }

    public void setMitem(String mitem) {
        this.mitem = mitem;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMstatus() {
        return mstatus;
    }

    public void setMstatus(String status) {
        this.mstatus = status;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }


    @Override
    protected Serializable pkVal() {
        return this.mId;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "mId='" + mId + '\'' +
                ", mitem='" + mitem + '\'' +
                ", mtime='" + mtime + '\'' +
                ", ptime='" + ptime + '\'' +
                ", cost='" + cost + '\'' +
                ", mstatus='" + mstatus + '\'' +
                ", pname='" + pname + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
