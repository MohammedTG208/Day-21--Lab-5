package com.example.week5lab1tracker.Controller;

import com.example.week5lab1tracker.Api.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import com.example.week5lab1tracker.model.Tracker;
@RestController
@RequestMapping("/project/tracker")
public class TrackerController {
ArrayList<Tracker> trackers = new ArrayList<Tracker>();

//
//    Requirement
// 1   Display all project .
//•2 Update a project
//•3 Delete a project
//•4 Change the project status as done or not done
//•5 Search for a project by given title
//•6 Display All project for one company by companyName.

    @GetMapping("/get/all")
    public ArrayList<Tracker> getAllTrackers() {
        return trackers;
    }

    @PutMapping("/update/project/{id}")
    public ApiResponse updateProject(@PathVariable int id,@RequestBody Tracker tracker) {
        for (int i = 0; i <trackers.size() ; i++) {
            if (trackers.get(i).getId() == id) {
                trackers.set(i, tracker);
                return new ApiResponse("Successfully updated tracker");
            }
        }
        return new ApiResponse("Tracker not found");
    }
    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteTracker(@PathVariable int id) {
        for (int i = 0; i <trackers.size() ; i++) {
            if (trackers.get(i).getId() == id) {
                trackers.remove(i);
                return new ApiResponse("Successfully deleted tracker");
            }
        }
        return new ApiResponse("Tracker not found");
    }

    @PutMapping("/status/{isDone}/{index}")
    public ApiResponse updateStatus(@PathVariable int index,@PathVariable String isDone) {
        for (int i = 0; i <trackers.size() ; i++) {
            if (trackers.get(i).getId() == index) {
                if (trackers.get(i).getStatus().equalsIgnoreCase("done")){
                    return new ApiResponse("Tracker is already done");
                }else {
                    trackers.get(i).setStatus(isDone);
                    return new ApiResponse("Successfully updated status");
                }
            }
        }
        return new ApiResponse("Tracker not found");
    }

    @GetMapping("/search/{title}")
    public ArrayList searchTracker(@PathVariable String title) {
        ArrayList trackers1 = new ArrayList();
        for (int i = 0; i <trackers.size() ; i++) {
            if (trackers.get(i).getTitle().equalsIgnoreCase(title)) {
                trackers1.add(trackers.get(i));
            }
        }
        return trackers1;
    }

    @GetMapping("/companyName/{companyName}")
    public ArrayList getCompanyName(@PathVariable String companyName) {
        ArrayList trackers1 = new ArrayList();
        for (int i = 0; i <trackers.size() ; i++) {
            if (trackers.get(i).getCompanyName().equalsIgnoreCase(companyName)) {
                trackers1.add(trackers.get(i));
            }
        }
        return trackers1;
    }

    @PostMapping("/add")
    public ApiResponse addTracker(@RequestBody Tracker tracker) {
        trackers.add(tracker);
        return new ApiResponse("Successfully added tracker");
    }

}
