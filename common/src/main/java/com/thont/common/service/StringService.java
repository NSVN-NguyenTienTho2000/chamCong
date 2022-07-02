package com.thont.common.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class StringService {
    private Random rnd = new Random();
    public String randomString() {
        return this.randomString(64);
    }

    public String randomString(int length) {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        while (salt.length() < length) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }
    public Integer randomInt(int length){
        Random rand = new Random();
        int randLength = 1;
        for(int i = 1; i<=length;i++){
            randLength *=10;
        }
        int ranNum = rand.nextInt(randLength)+1;
        return ranNum;
    }
    public Integer randomInt(){
        return this.randomInt(5);
    }
}
