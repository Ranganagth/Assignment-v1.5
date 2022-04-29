package com.example.microservices.MicroService_1.producer;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.ThreadLocalRandom;

import com.example.microservices.MicroService_1.config.ConfigFile;


@CrossOrigin
@RestController
@Async

public class M1 {


//@Autowired
//	MoneProducer producer;

    @Autowired
    private RabbitTemplate template;


    //Generate Random VIN Number
    public String generateVin()
    {
        StringBuilder sb = new StringBuilder(10);
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
        for (int j = 0; j < 11; j++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        String covertednumber = String.format("%06d", number);
        String vin = sb+covertednumber;
        return vin;
    }


    //Add Delay to Generate VIN Number
    public void addDelay(Integer delay)
    {
        long sleepTime = delay*1000;        //Delay starts
        try
        {
            Thread.sleep(sleepTime);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }                                        //Delay ends

    }

    //Generate Random Speed
    public String generateSpeed() {
        int randomSpeed = ThreadLocalRandom.current().nextInt(101, 101 + 1);
        return String.format("%03d", randomSpeed);

    }

    //Generate TimeStamp
    public String generateTimestamp() {

        /*
         * Date date = new Date(); Timestamp timestamp = new Timestamp(date.getTime());
         * SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         * String timeStamp = dateFormat.format(timestamp);
         */

        SimpleDateFormat gmtDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        gmtDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata")); //CurrentDate Time in GMT
        String timeStamp = gmtDateFormat.format(new Date());

        return timeStamp;

    }


    //Request Come from Front End and Hit this API
    @PostMapping("/data")
    public String genereateVins(@RequestBody UserData requestdetails ) {
        Integer vinCount = requestdetails.getVinCount();
        Integer delay = requestdetails.getDelay();
        String same_Vin = requestdetails.getDifferent();
        System.out.println(vinCount);
        System.out.println(delay);
        System.out.println(same_Vin);
        String vin;
        ArrayList<String> myArr = new ArrayList<String>();

        switch(same_Vin) {
            case "Y":                                   //For SAME VIN NUMBER
                vin = generateVin();
                String sSpeed = generateSpeed();              //Generate VIN Number
                for(int i = 0;i<vinCount;i++) {
                    if(i==0) {
                        myArr.add(sSpeed);
                        String vinAndSpeedAndTime = vin+sSpeed+generateTimestamp();
//					producer.publicToTopic(vinAndSpeedAndTime);
                        System.out.println(vinAndSpeedAndTime);
                        template.convertAndSend(ConfigFile.EXCHANGE, ConfigFile.ROUTING_KEY, vinAndSpeedAndTime);
                        addDelay(delay);
                    }
                    else {
                        String updatedSpeed = getSpeedWithPercentage(sSpeed,delay);
                        sSpeed = updatedSpeed;
                        myArr.add(sSpeed);
                        String vinAndSpeedAndTime = vin+String.format("%03d",Integer.parseInt(sSpeed))+generateTimestamp();
//					producer.publicToTopic(vinAndSpeedAndTime);

                        System.out.println(vinAndSpeedAndTime);
                        template.convertAndSend(ConfigFile.EXCHANGE, ConfigFile.ROUTING_KEY, vinAndSpeedAndTime);
                        addDelay(delay);
                    }
                }
                System.out.println(myArr);
                myArr.clear();
                return "DATA GENERATED";

            case "N":
                for(int i = 0;i<vinCount;i++)
                {
                    //Delay starts
                    vin = generateVin();
                    addDelay(delay);
                    sSpeed = generateSpeed();
                    String vinAndSpeedAndTime = vin+sSpeed+ generateTimestamp();


                    System.out.println(vinAndSpeedAndTime);
                    template.convertAndSend(ConfigFile.EXCHANGE, ConfigFile.ROUTING_KEY, vinAndSpeedAndTime);
//	             producer.publicToTopic(vinAndSpeedAndTime);
                }

                return "DATA GENERATED";
        }

        return "DATA GENERATED";
    }
    
    
    //Request Come from Front End and Hit this API
    @PostMapping("/dataApp")
    public String genereateVinsApp( UserData requestdetails ) {
        Integer vinCount = requestdetails.getVinCount();
        Integer delay = requestdetails.getDelay();
        String same_Vin = requestdetails.getDifferent();
        System.out.println(vinCount);
        System.out.println(delay);
        System.out.println(same_Vin);
        String vin;
        ArrayList<String> myArr = new ArrayList<String>();

        switch(same_Vin) {
            case "Y":                                   //For SAME VIN NUMBER
                vin = generateVin();
                String sSpeed = generateSpeed();              //Generate VIN Number
                for(int i = 0;i<vinCount;i++) {
                    if(i==0) {
                        myArr.add(sSpeed);
                        String vinAndSpeedAndTime = vin+sSpeed+generateTimestamp();
//					producer.publicToTopic(vinAndSpeedAndTime);
                        System.out.println(vinAndSpeedAndTime);
                        template.convertAndSend(ConfigFile.EXCHANGE, ConfigFile.ROUTING_KEY, vinAndSpeedAndTime);
                        addDelay(delay);
                    }
                    else {
                        String updatedSpeed = getSpeedWithPercentage(sSpeed,delay);
                        sSpeed = updatedSpeed;
                        myArr.add(sSpeed);
                        String vinAndSpeedAndTime = vin+String.format("%03d",Integer.parseInt(sSpeed))+generateTimestamp();
//					producer.publicToTopic(vinAndSpeedAndTime);

                        System.out.println(vinAndSpeedAndTime);
                        template.convertAndSend(ConfigFile.EXCHANGE, ConfigFile.ROUTING_KEY, vinAndSpeedAndTime);
                        addDelay(delay);
                    }
                }
                System.out.println(myArr);
                myArr.clear();
                return "DATA GENERATED";

            case "N":
                for(int i = 0;i<vinCount;i++)
                {
                    //Delay starts
                    vin = generateVin();
                    addDelay(delay);
                    sSpeed = generateSpeed();
                    String vinAndSpeedAndTime = vin+sSpeed+ generateTimestamp();


                    System.out.println(vinAndSpeedAndTime);
                    template.convertAndSend(ConfigFile.EXCHANGE, ConfigFile.ROUTING_KEY, vinAndSpeedAndTime);
//	             producer.publicToTopic(vinAndSpeedAndTime);
                }

                return "DATA GENERATED";
        }

        return "DATA GENERATED";
    }
    private String getSpeedWithPercentage(String speed, Integer Delay) {
        Integer sp= Integer.parseInt(speed);
        Integer delay = Delay;
        int percent = 0;
        Boolean inc_or_dec = incOrDec();
        //System.out.println(inc_or_dec);
        if(inc_or_dec) {
            if(delay>=1 && delay<=5) {
                percent = (int)Math.floor( Math.random()*(5-1+1)+1);
            }
            else if(delay>5 && delay <=10) {
                percent = (int)Math.floor(Math.random()*(10-2+1)+2);
            }
            else if(delay>10 && delay <=15) {
                if(sp<=150) percent = (int)Math.floor(Math.random()*(20-11+1)+11);
                else percent=(int)Math.floor(Math.random()*(15-11+1)+11);
            }
            else if(delay>15 && delay <=30) {
                if(sp<=150) percent = (int)Math.floor(Math.random()*(30-16+1)+16);
                else percent = (int)Math.floor(Math.random()*(25-16+1)+16);
            }
            else {
                if(sp<=150) percent = (int)Math.floor(Math.random()*(30-40+1)+40);
                else percent = (int)Math.floor(Math.random()*(25-16+1)+16);
            }
            sp = sp + percent;
        }else
        {
            if(delay>=1 && delay<=5) {
                percent = (int)Math.floor(Math.random()*(5-1+1)+1);
            }
            else if(delay>5 && delay <=10) {
                percent = (int)Math.floor(Math.random()*(10-2+1)+2);
            }
            else if(delay>10 && delay <=15) {
                if(sp<=150) percent=(int)Math.floor(Math.random()*(15-11+1)+11);
                else percent = (int)Math.floor(Math.random()*(20-11+1)+11);
            }
            else if(delay>15 && delay <=30) {
                if(sp<=150) percent =(int)Math.floor(Math.random()*(25-16+1)+16);
                else percent =  (int)Math.floor(Math.random()*(30-16+1)+16);
            }
            else {
                if(sp<=150) percent = (int)Math.floor(Math.random()*(25-16+1)+16);
                else percent = (int)Math.floor(Math.random()*(30-40+1)+40);
            }
            sp = sp - percent;

        }

        if(sp>=300)sp = 300;
        else if(sp<=0) sp = 0;
        System.out.println("final speed = "+sp);
        return Integer.toString(sp);
    }



    private Boolean incOrDec() {
        Random myrand = new Random();
        return myrand.nextBoolean();
    }

}
