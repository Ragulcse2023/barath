package com.Zoo.beans;

//Bean class for Food
public class foodBeans {
 private int id;
 private String name;
 private int nutritionValue;
 private int quantityInStock;
 private double cost;
 private String suitableFor;

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

 public int getNutritionValue() {
     return nutritionValue;
 }

 public void setNutritionValue(int nutritionValue) {
     this.nutritionValue = nutritionValue;
 }

 public int getQuantityInStock() {
     return quantityInStock;
 }

 public void setQuantityInStock(int quantityInStock) {
     this.quantityInStock = quantityInStock;
 }

 public double getCost() {
     return cost;
 }

 public void setCost(double cost) {
     this.cost = cost;
 }

 public String getSuitableFor() {
     return suitableFor;
 }

 public void setSuitableFor(String suitableFor) {
     this.suitableFor = suitableFor;
 }
}

//DAO class for Food

//Similarly, create Bean and DAO classes for Habitat, Veterinarian, Employee, and Visitor
