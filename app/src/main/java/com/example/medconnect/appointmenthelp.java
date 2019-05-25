package com.example.medconnect;

public class appointmenthelp {
    private String hosp,dep,time,date;

    public appointmenthelp(){

    }

    public appointmenthelp(String hosp, String dep, String time, String date) {
        this.hosp = hosp;
        this.dep = dep;
        this.time = time;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHosp() {
        return hosp;
    }

    public void setHosp(String hosp) {
        this.hosp = hosp;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = dep;
    }
}
