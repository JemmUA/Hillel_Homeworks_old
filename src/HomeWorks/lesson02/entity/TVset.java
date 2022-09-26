package HomeWorks.lesson02.entity;

import java.util.Scanner;

public class TVset {
    private boolean power;
    private int channel;
    private  int volume;

    //Constructors
    public TVset() {
    }
    public TVset(boolean power, int channel, int volume) {
        this.power = power;
        this.channel = channel;
        this.volume = volume;
    }

    //Methods
    //Power
    public void setPower(boolean power) {
        this.power = power;
        if (this.power == true) {
            System.out.println("TV is On");
        } else {
            System.out.println("TV is Off");
        }
    }
    public boolean getPower() {
        System.out.println("TV power: " + power);
        return power;
    }
    //Channels
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("TV channel: " + this.channel);
    }
    public int getChannel() {
        System.out.println("TV channel: " + channel);
        return channel;
    }
    public void plusChannel() {
        ++this.channel;
        System.out.println("TV channel +: " + channel);
    }
    public void minusChannel() {
        --this.channel;
        System.out.println("TV channel -: " + channel);
    }
    //Volume
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("TV volume: " + this.volume);
    }
    public int getVolume() {
        System.out.println("TV volume: " + volume);
        return volume;
    }
    public void plusVolume() {
        ++this.volume;
        System.out.println("TV volume +: " + volume);
    }
    public void minusVolume() {
        --this.volume;
        System.out.println("TV volume -: " + volume);
    }

    public static class User {
        //Data
        private String name ;
        private String surName ;
        private String password ;
        private String sex ;
        private String country ;

        //Constructors
        public User() {
        }
        public User(String name, String surName, String sex) {
            this.name = name;
            this.surName = surName;
            this.sex = sex;
        }
        public User(String name, String surName, String password, String sex, String country) {
            this.name = name;
            this.surName = surName;
            this.password = password;
            this.sex = sex;
            this.country = country;
        }

        //Getters, setters
        public void setName(String name) {
            this.name = name;
        }
        public void setSurName(String surName) {
            this.surName = surName;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public void setSex(String sex) {
            this.sex = sex;
        }
        public void setCountry(String country) {
            this.country = country;
        }

        public String getName() {
            return name;
        }
        public String getSurName() {
            return surName;
        }
        public String getPassword() {
            return password;
        }
        public String getSex() {
            return sex;
        }
        public String getCountry() {
            return country;
        }

        //Methods
        public void readingMessage (String message) {
            System.out.println(this.getName() + " reads: " + message);
        }
        public void typingMessage () {
            Scanner scannerFirst = new Scanner(System.in);
            String typeInput = scannerFirst.next();
            typeInput += scannerFirst.nextLine();
            scannerFirst.close();
            System.out.println(this.getName() + " wrights: " + typeInput);
        }
    }
}
