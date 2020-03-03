package com.company;

import javax.crypto.spec.PSource;
import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {


    public static void main(String[] args) {
        //kör creategraph och printar ut alla stationer och deras grannar
        showNodesAndLinks();

        //kör getroute
        RunThis();

    }

    public static ArrayList<Node> createGraph() {
        //Skapar en nod för varje tågstation
        Node hki = new Node("Helsingfors", 60.1640504, 24.7600896);
        Node tpe = new Node("Tammerfors", 61.6277369, 23.5501169);
        Node tku = new Node("Abo", 60.4327477, 22.0853171);
        Node jyv = new Node("Jyväskylä", 62.1373432, 25.0954598);
        Node kpo = new Node("Kuopio", 62.9950487, 26.556762);
        Node lhi = new Node("Lahtis", 60.9948736, 25.5747703);


        //Förbindelser från Helsingfors tågstation
        hki.addNeighbour(tpe); //Tammerfors
        hki.addNeighbour(tku); //Åbo
        hki.addNeighbour(lhi); //Lahtis

        //Förbindelser från Tammerfors tågstation
        tpe.addNeighbour(hki); //Helsingfors
        tpe.addNeighbour(tku); //Åbo
        tpe.addNeighbour(jyv); //Jyväskylä
        tpe.addNeighbour(lhi); //Lahtis

        //Förbindelser från Åbo tågstation
        tku.addNeighbour(hki); //Helsingfors
        tku.addNeighbour(tpe); //Tammerfors

        //Förbindelser från Jyväskylä tågstation
        jyv.addNeighbour(tpe); //Tammerfors

        //Förbindelser från Kuopio tågstation
        kpo.addNeighbour(lhi); //Lahtis

        //Förbindelser från Lahtis tågstation
        lhi.addNeighbour(hki); //Helsingors
        lhi.addNeighbour(tpe); //Tammerfors
        lhi.addNeighbour(kpo); //Kuopio

        //Skapar en lista för grafen och sätter in alla noder
        ArrayList<Node> graph = new ArrayList();
        graph.add(hki);
        graph.add(tpe);
        graph.add(tku);
        graph.add(jyv);
        graph.add(kpo);
        graph.add(lhi);

        return graph;
    }

    public static void showNodesAndLinks() {
        ArrayList<Node> test;
        test = createGraph();
        for (int i = 0; i < test.size(); i++) {
            Node noden = test.get(i);
            System.out.println("\n" + noden.getName());
            for (int j = 0; j < noden.getNeighbours().size(); j++) {
                System.out.println("   " + noden.getNeighbours().get(j).getName());
            }
        }
    }


    public static ArrayList<Node> getRoute(Node source, Node destination) {
        ArrayList<Node> candidates = new ArrayList<>();
        ArrayList<Node> visited = new ArrayList<>();
        Node current = source;
        boolean done = false;

        while (!done) {
            double minF = 0;
            Node next = null;

            for (int i = 0; i < current.getNeighbours().size(); i++) {

                if (!candidates.contains(current.getNeighbours().get(i)) && !visited.contains(current.getNeighbours().get(i))) {
                    candidates.add(current.getNeighbours().get(i));
                    current.getNeighbours().get(i).previous = current;
                }

            }

            for (int j = 0; j < candidates.size(); j++) {

                if (candidates.get(j) == destination) {
                    done = true;
                    break;
                } else {
                    candidates.get(j).getF(destination,source);
                    if (minF == 0 || minF > candidates.get(j).getF(destination,source)) {
                        minF = candidates.get(j).getF(destination,source);
                        next = candidates.get(j);
                    }
                }
            }
            if (!done) {
                current = next;
                visited.add(current);
                candidates.remove(current);

            }
        }

        ArrayList<Node> route = new ArrayList<Node>();
        current = destination;

        while (current != source) {

            route.add(current);
            current = current.previous;

        }
        return route;
    }
    //kör programmet
    public static void RunThis() {
        //skapar grafen stations
        ArrayList<Node> stations= createGraph();

        //destination och startpunkt in
        Scanner input = new Scanner(System.in);

        System.out.println("Var så vänlig och välj din startpunkt: \n"
                + "0: Helsingfors \n"
                + "1: Tammerfors \n"
                + "2: Åbo \n"
                + "3: Jyväskylä \n"
                + "4: Kuopio \n"
                + "5: Lahtis \n"
        );
        int firstIn = input.nextInt();

        System.out.println("Var så vänlig och välj din destination: \n"
                + "0: Helsingfors \n"
                + "1: Tammerfors \n"
                + "2: Åbo \n"
                + "3: Jyväskylä \n"
                + "4: Kuopio \n"
                + "5: Lahtis \n"
        );

        int secondIn = input.nextInt();

        System.out.println("Den kortaste rutten är: \n" + "");
        //kör getRoute
        ArrayList<Node> result = getRoute(stations.get(secondIn),stations.get(firstIn));


      //printar rutten
      for(int i = 0; i < result.size(); i++){
          System.out.println(result.get(i).getName());
      }
      //printar destinationen, eftersom den inte kommer med i route arrayn
        System.out.println(stations.get(secondIn).getName());

    }


}

