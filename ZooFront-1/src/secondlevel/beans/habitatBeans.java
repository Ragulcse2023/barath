package com.Zoo.beans;

//Bean class for Habitat
public class habitatBeans {
 private int id;
 private String name;
 private String type;
 private int capacity;
 private String location;
 private double size;
 private boolean temperatureControl;
 private boolean isClean;

 // getters and setters for each property
 public int getId() {
     return id;
 }

 public void setId(int id) {
     this.id = id;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public String getType() {
     return type;
 }

 public void setType(String type) {
     this.type = type;
 }

 public int getCapacity() {
     return capacity;
 }

 public void setCapacity(int capacity) {
     this.capacity = capacity;
 }

 public String getLocation() {
     return location;
 }

 public void setLocation(String location) {
     this.location = location;
 }

 public double getSize() {
     return size;
 }

 public void setSize(double size) {
     this.size = size;
 }

 public boolean isTemperatureControl() {
     return temperatureControl;
 }

 public void setTemperatureControl(boolean temperatureControl) {
     this.temperatureControl = temperatureControl;
 }

 public boolean isClean() {
     return isClean;
 }

 public void setClean(boolean clean) {
     isClean = clean;
 }
}

//DAO class for Habitat

//Similarly, create Bean and DAO classes for Veterinarian, Employee, and Visitor
