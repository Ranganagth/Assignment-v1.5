package com.example.microservices.MicroService_1.producer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserData {

    //This will Map with data which coming from API
    private Integer vinCount;
    public Integer getVinCount() {
        return vinCount;
    }
    public void setVinCount(Integer vinCount) {
        this.vinCount = vinCount;
    }
    public Integer getDelay() {
        return delay;
    }
    public void setDelay(Integer delay) {
        this.delay = delay;
    }
    public String getDifferent() {
        return different;
    }
    public void setDifferent(String different) {
        this.different = different;
    }
    private Integer delay;
    private String different;
}

