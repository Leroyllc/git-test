package hnit.llc.cpms.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 车位表
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
public class Carsite extends Model<Carsite> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "carsiteId", type = IdType.UUID)
    private String carsiteId;

    @TableField("carsiteNumber")
    private int carsiteNumber;

    private String csstatus;

    @TableField("ownerId")
    private String ownerId;



    public String getCarsiteId() {
        return carsiteId;
    }

    public void setCarsiteId(String carsiteId) {
        this.carsiteId = carsiteId;
    }

    public int getCarsiteNumber() {
        return carsiteNumber;
    }

    public void setCarsiteNumber(int carsiteNumber) {
        this.carsiteNumber = carsiteNumber;
    }

    public String getCsstatus() {
        return csstatus;
    }

    public void setCsstatus(String status) {
        this.csstatus = status;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }


    @Override
    protected Serializable pkVal() {
        return this.carsiteId;
    }

    @Override
    public String toString() {
        return "Carsite{" +
                "carsiteId='" + carsiteId + '\'' +
                ", carsiteNumber='" + carsiteNumber + '\'' +
                ", csstatus='" + csstatus + '\'' +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }
}
