package com.example.Kafkastreamprocessing.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class userModel {

    private String name;
    private String address;

    public userModel() {
    }
}
