package com.lucasbrunori.unittesting.business;

import com.lucasbrunori.unittesting.data.*;
import org.springframework.beans.factory.annotation.*;

public class SomeBusinessImpl {

    @Autowired
    SomeDataService somedateService;

    public int calculateSum(int[] data){
        int sum = 0;
        for (int value: data){
            sum += value;
        }
        return sum;
    }

    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = somedateService.retreiveAllData();
        for (int value: data){
            sum += value;
        }
        return sum;
    }

    public void setSomedateService(SomeDataService somedateService) {
        this.somedateService = somedateService;
    }
}
