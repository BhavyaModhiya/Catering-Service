package com.example.vasant;

public class Order {
    private static Order order;

    public String getPartyName() {
        return partyName;
    }

    public String getAddress() {
        return address;
    }

    public Long getPhoneNum() {
        return phoneNum;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getNoOfPerson() {
        return noOfPerson;
    }

    public int getPriceperdish() {
        return priceperdish;
    }


    public String getPlace() {
        return place;
    }

    String partyName;
    String address;
    Long phoneNum;
    String date;
    String time;
    int noOfPerson;
    int priceperdish;
    String place;
    public static Order getInstance(){
        if(order == null) {
            order = new Order();
            order.setData(
                    "", "", (long) 0, "", "", 0, 0,""
            );
        }
        return order;
    }
    public void setData(String partyName,
            String address,
            Long phoneNum,
            String date,
            String time,
            int noOfPerson,
            int priceperdish,
            String place) {
        this.partyName = partyName == null ? "" : partyName;
        this.address = address == null ? "" : address ;
        this.phoneNum = phoneNum;
        this.date = date == null ? "" : date ;
        this.time = time == null ? "" : time ;
        this.noOfPerson = noOfPerson ;
        this.priceperdish = priceperdish;
        this.place = place == null ? "" : place ;
    }
}
