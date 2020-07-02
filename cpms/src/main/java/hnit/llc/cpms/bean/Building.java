package hnit.llc.cpms.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 楼栋表
 * </p>
 *
 * @author llc
 * @since 2020-05-07
 */
public class Building extends Model<Building> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "buId", type = IdType.UUID)
    private String buId;

    @TableField("buNumber")
    private int buNumber;

    @NotBlank(message = "所属编号不能为空")
    @TableField("buUnit")
    private int buUnit;

    @TableField(exist = false)
    private List<House> houseList = new ArrayList<>();


    public List<House> getHouseList() {
        return houseList;
    }

    public void setHouseList(List<House> houseList) {
        this.houseList = houseList;
    }

    public String getBuId() {
        return buId;
    }

    public void setBuId(String buId) {
        this.buId = buId;
    }

    public int getBuNumber() {
        return buNumber;
    }

    public void setBuNumber(int buNumber) {
        this.buNumber = buNumber;
    }

    public int getBuUnit() {
        return buUnit;
    }

    public void setBuUnit(int buUnit) {
        this.buUnit = buUnit;
    }


    @Override
    protected Serializable pkVal() {
        return this.buId;
    }

    @Override
    public String toString() {
        return "Building{" +
                "buId='" + buId + '\'' +
                ", buNumber='" + buNumber + '\'' +
                ", buUnit='" + buUnit + '\'' +
                ", houseList=" + houseList +
                '}';
    }
}
