package com.parking.apiparking.services;

import com.parking.apiparking.entities.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ParkingService {
    //Utilizamos List para crear nuestra lista de carros.
    private List<Car> parkingLot;

    //Este constructor ayuda a inicializar a la lista.
    public ParkingService(){
        this.parkingLot = new ArrayList<>();
    }

    //Todo:US01Como usuario, quiero poder ver la lista de todos los autos estacionados en el
    //parqueo, para poder tener una visión general del estado actual del estacionamiento.
    public List<Car> getAllCars(){
        return this.parkingLot;
    }

    //Todo:US02Como usuario, quiero poder agregar un auto al parqueo, para poder estacionar mi vehiculo.
    public void addCar(Car car){
        this.parkingLot.add(car);
    }

}



