package com.java.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.java.Model.User;
import com.java.service.ToyService;

@RestController
@RequestMapping("/api")
public class ToyController {

    @Autowired
    private ToyService toyService;

    @PostMapping("/toys")
    public ResponseEntity<User> addToy(@RequestBody User toy) {
        User newToy = toyService.createToy(toy);
        if (newToy != null) {
            return new ResponseEntity<>(newToy, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/toys")
    public ResponseEntity<Page<User>> getAllToy(
            @RequestParam int pageNo,
            @RequestParam int pageSize,
            @RequestParam String sortBy) {
        Page<User> toys = toyService.getAllToy(pageNo, pageSize, sortBy);
        if (!toys.isEmpty()) {
            return new ResponseEntity<>(toys, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/toys/{toyId}")
    public ResponseEntity<User> updateToy(@PathVariable int toyId, @RequestBody User toy) {
        boolean updated = toyService.updateToy(toyId, toy);
        if (updated) {
            return new ResponseEntity<>(toy, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/toys/{toyId}")
    public ResponseEntity<Boolean> deleteToy(@PathVariable int toyId) {
        boolean deleted = toyService.deleteToy(toyId);
        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
