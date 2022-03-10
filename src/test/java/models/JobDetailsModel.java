package models;

import constants.Job;
import utils.DatePicker;

public class JobDetailsModel {
    private String startDate, startTime, finishTime, duration, urgency, description, region, addressType, address, billable, travelArea, serviceSetting, deliveryMethod, category, serviceAgreement, quantity;


    /**
     * Default constructor --> create default job
     */
    public JobDetailsModel() {
        System.out.println("Start Date equals currentDate + 7");
        this.startDate = new DatePicker().getDateFromCurrentDate(7);
        this.startTime = "10:00 AM";
        this.duration = "2";
        this.finishTime = "12:00 PM";
        this.urgency = Job.Urgency.NORMAL;
        this.description = "This is a test automation of VienPham";
        this.region = "Sydney";
        this.addressType = Job.AdressType.CLIENT;
        this.address = "14 Victoria Avenue, Castle Hill NSW, Australia";
        this.billable = Job.Billable.BILLABLE;
        this.travelArea = Job.TravelArea.REMOTE;
        this.serviceSetting = Job.ServiceSetting.ONLINE_SERVICE;
        this.deliveryMethod = Job.DeliveryMethod.FIXED_QUANTITY;
        this.category = Job.Category.UN_CATEGORISED;
        this.serviceAgreement = Job.ServiceAgreement.SERVICE1;
        this.quantity = "2";
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBillable(String billable) {
        this.billable = billable;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setTravelArea(String travelArea) {
        this.travelArea = travelArea;
    }

    public void setServiceSetting(String serviceSetting) {
        this.serviceSetting = serviceSetting;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setServiceAgreement(String serviceAgreement) {
        this.serviceAgreement = serviceAgreement;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }


    public String getDuration() {
        return duration;
    }

    public String getUrgency() {
        return urgency;
    }

    public String getDescription() {
        return description;
    }

    public String getRegion() {
        return region;
    }

    public String getAddressType() {
        return addressType;
    }

    public String getAddress() {
        return address;
    }

    public String getBillable() {
        return billable;
    }

    public String getTravelArea() {
        return travelArea;
    }

    public String getServiceSetting() {
        return serviceSetting;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public String getCategory() {
        return category;
    }

    public String getServiceAgreement() {
        return serviceAgreement;
    }
}
