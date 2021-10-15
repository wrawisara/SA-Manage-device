package ku.sa.managerthpost.models;

public class RepairOrder {
    private String repair_id;

    public RepairOrder(String repair_id) {
        this.repair_id = repair_id;
    }

    public String getRepair_id() {
        return repair_id;
    }

    public void setRepair_id(String repair_id) {
        this.repair_id = repair_id;
    }
}
