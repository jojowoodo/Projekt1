package com.company;

import java.util.ArrayList;

public class Node {
   private  String name;

  private  double latitude;

  private  double longtitude;

  private  ArrayList <Node>neighbours = new ArrayList<Node>();

    public Node(name, latitude, longitude, neighbours){
        setName(name);
        setLatitude(latitude);
        setLongitude(longitude);
        neighbours = new ArrayList<>();

    }

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