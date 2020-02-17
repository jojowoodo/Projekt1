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

    public static double getDistance(double lon1, double lat1, double lon2, double lat2)
    {
        lon1 = lon1*Math.PI/180.0;
        lat1 = lat1*Math.PI/180.0;
        lon2 = lon2*Math.PI/180.0;
        lat2 = lat2*Math.PI/180.0;


        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat/2), 2) + Math.cos(lat1) * Math.cos(lat2) *        Math.pow(Math.sin(dlon/2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double km = 6367 * c;

        return km;
    }


    public static double calculateH(Node Current,Node destination){
        double H;
       H = getDistance(destination.getLongitude(),destination.getLatitude(),Current.getLongitude(),Current.getLatitude());
        System.out.println(H);
        return H;
    }



}