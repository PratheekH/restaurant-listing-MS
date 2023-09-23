package com.pratheek.restaurentlisting.controller;

import com.pratheek.restaurentlisting.dto.RestaurentDto;
import com.pratheek.restaurentlisting.service.RestaurentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurentController {

    @Autowired
    RestaurentService service;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurentDto>> fetchAllRestaurents(){
        List<RestaurentDto> allRestaurents = service.findAllRestaurents();
        return new ResponseEntity<>(allRestaurents, HttpStatus.OK);
    }

    @PostMapping("/addRestaurent")
    public ResponseEntity<RestaurentDto> saveRestaurent(@RequestBody RestaurentDto restaurentDto){
        RestaurentDto restaurent = service.addRestaurentInDB(restaurentDto);
        return new ResponseEntity<>(restaurent,HttpStatus.CREATED);
    }

    @GetMapping("/fetchById/{id}")
    public ResponseEntity<RestaurentDto> findRestaurentById(@PathVariable Integer id){
        return service.fetchRestaurentById(id);
    }
}
