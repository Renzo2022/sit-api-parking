package com.parking.apiparking.controller;


import com.parking.apiparking.entities.Car;
import com.parking.apiparking.services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Aquella clase que definir cuales son los metodos que se van a ejecutar con un GET
// o un POST y tambien la clase en donde se va identificar el nombre de la URL.

//@RestController, indicar a la clase de que va tener el comportamiento de poder tener
//acceso a los HTTP, a los status de respuesta y cada metodo va a tener una URL, que
//va a identificar al recurso que quiere acceder.
@RestController
//RequestMapping, Dandonle el nombre al recurso.
@RequestMapping("/parking")//parking => URL
public class ParkingController {

    //Inyección de Dependencias, se encarga de entregarte la instancia del objeto que tu
    //necesitas.
    private final ParkingService parkingService;
    public ParkingController(ParkingService parkingService){
        this.parkingService = parkingService;
    }
    //2da Manera de inyectar dependencias.
    //@Autowired
    //private ParkingService parkingService;

    //Los metodos tienen que tener una verbo HTTP, obtener un listado, el
    //verbo que se utiliza es @GetMapping, con esto el controlador va a
    //saber cual es el metodo que tiene que ejecutar, en este caso el getAllCars

    //GET: http://dominio/parking/cars
    //Primera forma
    //@GetMapping("/cars")
    //public List<Car> getAllCars(){
    //    return parkingService.getAllCars();
    //}
    //ResponseEntity Para hacer las confirmaciones, que es lo que va a ejecutar.
    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars(){
        return ResponseEntity.ok(this.parkingService.getAllCars());//ok=200
    }

    //POST: http://dominio/parking/cars
    //@RequestBody sirve para que el IDE entienda el formato que se esta pidiiendo en
    //en el Postman.
    @PostMapping("/cars")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        this.parkingService.addCar(car);
        return new ResponseEntity<>(car, HttpStatus.CREATED);//CREATED=201
    }
}
