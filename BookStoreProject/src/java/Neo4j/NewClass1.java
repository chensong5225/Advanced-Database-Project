///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Neo4j;
//
//import java.util.List;
//import org.neo4j.driver.v1.Driver;
//import org.neo4j.driver.v1.Record;
//import org.neo4j.driver.v1.Session;
//import org.neo4j.driver.v1.StatementResult;
//import org.neo4j.driver.v1.Transaction;
//import static org.neo4j.driver.v1.Values.parameters;
//
///**
// *
// * @author hom19
// */
//import Neo4j.*;
//import Neo4j.beans.*;
//import java.util.ArrayList;
//import java.util.Iterator;
//
//public class NewClass1 {
//
//    public static void main(String[] args) {
//        Q7_demand_curve q7 = new Q7_demand_curve();
//        ArrayList<Q7_result> result = new ArrayList<>();
//        result = q7.answer("1");
//        for (Q7_result q7r : result) {
//            ArrayList<Float> pricelist = q7r.getPricelist();
//            ArrayList<Float> salelist = q7r.getSalelist();
//            for (double d : pricelist) {
//                System.out.println(d);
//            }
//            for (double e : salelist) {
//                System.out.println(e);
//            }
//        }
//
//    }
//}
