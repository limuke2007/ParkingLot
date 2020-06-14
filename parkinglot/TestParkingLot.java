package com.laioffer.OOD.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class TestParkingLot {
    public static void main(String[] args) {

        ParkingLot lot = new ParkingLot(4, 5);                  // 一个camry来到"停车楼"
        Car camry = new Car();
        System.out.println(lot.hasSpot(camry));                 // 问有没有车位

        Level l = new Level(5);                                 // 如果"l层"有5个车位
        l.park(camry);                                          // 连续停了5辆camry
        l.park(camry);
        l.park(camry);
        l.park(camry);
        l.park(camry);
        System.out.println(l.hasSpot(camry));                    // 再来一辆camry有没有车位

        ParkingSpot s1 = new ParkingSpot(VehicleSize.Compact);       // "某一车位s1"的size是Compact
        System.out.println(s1.fit(camry));                           // 问能否装得下camry

        List<Vehicle> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            final Vehicle v = i % 2 == 0 ? new Car() : new Truck();
            list.add(v);
            boolean hasSpot = lot.hasSpot(v);
            if (i < 40) {
                assert hasSpot;
                assert lot.park(v);
            } else {
                assert !hasSpot;
                assert !lot.park(v);
            }
        }
        assert list.size() == 50;
        int i = 0;
        for (Vehicle v : list) {
            assert i >= 40 || lot.leave(v);
            i++;
        }
    }
}
