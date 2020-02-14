package com.company;

import java.util.ArrayList;

public class Node {
    private String name;
    private double latitude;
    private double longitude;
    private ArrayList<Node> neighbours;

    public Node(String n, double lat, double lon) {
        neighbours = new ArrayList<>();
        setName(n);
        setLatitude(lat);
        setLongitude(lon);


    }

    public void setName(String n) {
        name = n;
    }

    public void setLatitude(double lat) {
        latitude = lat;
    }

    public void setLongitude(double lon) {
        longitude = lon;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }


    public void addNeighbour(Node town) {
        neighbours.add(town);
    }

    public ArrayList<Node> getNeighbours() {
        return neighbours;
    }



}