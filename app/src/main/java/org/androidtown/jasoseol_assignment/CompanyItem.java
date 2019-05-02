package org.androidtown.jasoseol_assignment;

public class CompanyItem {

    private String companyName;
    private String fields;
    private String image;
    private String endTime;

    public CompanyItem(String companyName, String fields, String image, String endTime) {
        this.companyName = companyName;
        this.fields = fields;
        this.image = image;
        this.endTime = endTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEndTime() {
        String[] dateTime = endTime.split(" ");
        String[] date = dateTime[0].split("-");
        String[] time = dateTime[1].split(":");

        return "~" + date[1] + "월 " + date[2] + "일 " + time[0] + "시 " + time[1] + "분";
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }



}
