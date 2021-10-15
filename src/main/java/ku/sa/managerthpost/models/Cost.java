package ku.sa.managerthpost.models;

public class Cost {
    private String cost_id;

    public Cost (String cost_id) {
        this.cost_id = cost_id;
    }

    public String getCost_id() {
        return cost_id;
    }

    public void setCost_id(String cost_id) {
        this.cost_id = cost_id;
    }
}
