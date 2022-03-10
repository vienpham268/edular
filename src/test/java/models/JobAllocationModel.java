package models;

public class JobAllocationModel {
    private String resource, status;

    public JobAllocationModel() {
        this.resource = "Jill Kline";
        this.status = "Dispatched";
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResource() {
        return resource;
    }

    public String getStatus() {
        return status;
    }
}
