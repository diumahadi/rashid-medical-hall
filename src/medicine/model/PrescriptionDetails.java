package medicine.model;

public class PrescriptionDetails {
    private long detailId;
    private PrescriptionMaster master;
    private Medicine medicine;
    private String dozeFormat;
    private String duration;
    private String others;

    public long getDetailId() {
        return detailId;
    }

    public void setDetailId(long detailId) {
        this.detailId = detailId;
    }

    public PrescriptionMaster getMaster() {
        return master;
    }

    public void setMaster(PrescriptionMaster master) {
        this.master = master;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public String getDozeFormat() {
        return dozeFormat;
    }

    public void setDozeFormat(String dozeFormat) {
        this.dozeFormat = dozeFormat;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
    
    
}
