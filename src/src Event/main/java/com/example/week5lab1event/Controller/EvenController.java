package com.example.week5lab1event.Controller;

import com.example.week5lab1event.model.EvenSystem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EvenController {
//Display all event .
//• Update a event
//• Delete a event
//• Change capacity
//• Search for a event by given id
    ArrayList<EvenSystem> evenSystems = new ArrayList<>();
    @GetMapping("/get")
    public ArrayList getAll() {
        if (evenSystems.isEmpty()) {
            ArrayList msg = new ArrayList<>();
            msg.add("No events found");
            return msg;

        }else {
            return evenSystems;
        }
    }
    @PutMapping("/update/event/{id}")
    public String updateEvenSystem(@PathVariable int id, @RequestBody EvenSystem evenSystem) {
        if (id>evenSystems.size()){
            return "check ID value";
        }else {
            evenSystems.set(id, evenSystem);
            return "Update successful";
        }
    }
    @DeleteMapping("/delete/{index}")
    public String deleteEvenSystem(@PathVariable int index) {
        if (index>evenSystems.size()) {
           return  "check ID value";
        }else{
                evenSystems.remove(index-1);
                return "Deleted event";
        }
    }
//    Change capacity
    @PutMapping("/update/capacity/{index}/{capacity}")
    public String updateCapacity(@PathVariable int index, @PathVariable double capacity) {
        evenSystems.get(index-1).setCapacity(capacity);
        return "capacity change";
    }
//    Search for a event by given id
    @GetMapping("/search/{id}")
    public EvenSystem searchEvenSystem(@PathVariable int id) {
        return evenSystems.get(id-1);
    }
    @PostMapping("/add")
    public String addEvenSystem(@RequestBody EvenSystem evenSystem) {
        evenSystems.add(evenSystem);
        return "success";
    }
}
