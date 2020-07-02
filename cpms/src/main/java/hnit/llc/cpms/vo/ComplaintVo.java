package hnit.llc.cpms.vo;

public class ComplaintVo {
    private String ccount;
    private String ownerName;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCcount() {
        return ccount;
    }

    public void setCcount(String ccount) {
        this.ccount = ccount;
    }

    public ComplaintVo() {
        super();
    }

    public ComplaintVo(String ccount, String ownerName) {
        super();
        this.ccount = ccount;
        this.ownerName = ownerName;
    }
}
