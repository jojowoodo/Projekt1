package com.company;

import java.util.ArrayList;

public class Node {
    private String name;
    private double latitude;
    private double longitude;
    private ArrayList<ArrayList> neighbours;
    private Node previous;

    public Node(String n, double lat, double lon) {
        neighbours = new ArrayList<ArrayList>();
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

    public void setPrevious(Node p) {
        previous = p;
    }


    public void addNeighbour(ArrayList town) {
        neighbours.add(town);
    }

    public ArrayList<ArrayList> getNeighbours() {
        return neighbours;
    }

    public static double getDistance(double lon1, double lat1, double lon2, double lat2) {
        lon1 = lon1 * Math.PI / 180.0;
        lat1 = lat1 * Math.PI / 180.0;
        lon2 = lon2 * Math.PI / 180.0;
        lat2 = lat2 * Math.PI / 180.0;


        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double km = 6367 * c;

        return km;
    }


    public double calculateH(Node destination) {
        double H;
        H = getDistance(destination.getLongitude(), destination.getLatitude(), getLongitude(), getLatitude());
        System.out.println(H);
        return H;
    }

    public double calculateG(Node source) {
        double G = 0;
        Node current = this;

        current.calculateH(current.previous);

        return G;
    }

    public double getF(ArrayList candidates) {
        double F = calculateH() + calculateG();
        return F;
    }

    public getRoute(Node source,Node destination) {
        ArrayList candidates = new ArrayList<>(), visited = new ArrayList();
        Node current = source;
        boolean done;

        if (done = false) {
            double minF = 0;
            Object next = null;
            for (int i = 0; i < current.neighbours.size(); i++) {
                neighbours.add(candidates);
                previous = current;

                for (int j = 0; j < candidates.size(); j++) {

                    if (candidates = destination) {
                        done = true;
                        break;
                    } else {
                        getF(candidates);
                        if (minF == 0 || minF > getF(candidates)) {
                            minF = getF(candidates);
                            next = candidates;
                        }
                    }
                }
                if (done == false) {
                    current = next;
                    visited += current;
                    candidates.remove(current);

                }
            }
            if (current != source) {

                current.previous();
            }
            return route;
        }
    }
}