package com.company;

import java.util.ArrayList;

public class Node {
    String name;

    double latitude;

    double longtitude;

    ArrayList <Node>neighbours = new ArrayList<Node>();

   public String getName() {

       return name;
    }

setName(name : String)

getLatitude() : double

setLatitude(latitude : double)

getLongitude() : double

setLongitude(longitude : double)

addNeighbour(neighbour : Node)

getNeighbours() : ArrayList<Node>
}
