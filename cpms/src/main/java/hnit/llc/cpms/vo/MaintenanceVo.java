package hnit.llc.cpms.vo;

public class MaintenanceVo {
    private String mcount;
    private String ownerName;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getMcount() {
        return mcount;
    }

    public void setMcount(String mcount) {
        this.mcount = mcount;
    }

    public MaintenanceVo() {
        super();
    }

    public MaintenanceVo(String mcount, String ownerName) {
        super();
        this.mcount = mcount;
        this.ownerName = ownerName;
    }
}
