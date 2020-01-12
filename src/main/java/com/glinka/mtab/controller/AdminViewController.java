package com.glinka.mtab.controller;

import com.glinka.mtab.dto.*;
import com.glinka.mtab.model.entity.TripSchedule;
import com.glinka.mtab.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminViewController {

    private final UserService userService;
    private final RoleService roleService;
    private final AgencyService agencyService;
    private final BusService busService;
    private final StopService stopService;
    private final TicketService ticketService;
    private final TripService tripService;
    private final TripScheduleService tripScheduleService;

    public AdminViewController(UserService userService, RoleService roleService, AgencyService agencyService, BusService busService, StopService stopService, TicketService ticketService, TripService tripService, TripScheduleService tripScheduleService) {
        this.userService = userService;
        this.roleService = roleService;
        this.agencyService = agencyService;
        this.busService = busService;
        this.stopService = stopService;
        this.ticketService = ticketService;
        this.tripService = tripService;
        this.tripScheduleService = tripScheduleService;
    }

    @GetMapping("/login.html")
    public String loginUser(){
        return "login";
    }

    @GetMapping("/register.html")
    public String registerUser(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "register";
    }
//
//    @PostMapping("/signup")
//    public String signup(@RequestBody UserDto user){
//        return "signup";
//    }
//
//    @GetMapping("/agency")
//    public String viewAgency(Model model, @RequestParam("agencyId") Long agencyId){
//
//        AgencyDto agencyDto = agencyService.findDtoById(agencyId);
//
//        model.addAttribute("agency", agencyDto);
//        return "agency";

//    }

    @GetMapping("/index.html")
    public String viewBoard(){
        return "index";
    }

    @GetMapping("/agency.html")
    public String viewAgency(Model model, @RequestParam("id") Long id){
        AgencyDto agencyDto = agencyService.findDtoById(id);
        UserDto userDto = userService.findByIdDto(agencyDto.getOwner());
        model.addAttribute("agency", agencyDto);
        model.addAttribute("user", userDto);
        return "agency";
    }

    @GetMapping("/buses.html")
    public String viewBuses(Model model, @RequestParam("id") Long id){
        AgencyDto agencyDto = agencyService.findDtoById(id);
        UserDto userDto = userService.findByIdDto(agencyDto.getOwner());
        BusDto busDto = new BusDto();
        model.addAttribute("newBus", busDto);
        model.addAttribute("user", userDto);
        model.addAttribute("buses", busService.findAllByAgency(id));
        return "buses";
    }

    @GetMapping("/trips.html")
    public String viewTrips(Model model, @RequestParam("id") Long id){
        AgencyDto agencyDto = agencyService.findDtoById(id);
        UserDto userDto = userService.findByIdDto(id);
        TripDto tripDto = new TripDto();
        TripScheduleDto tripScheduleDto = new TripScheduleDto();
        StopDto stopDto = new StopDto();
        model.addAttribute("newTrip", tripDto);
        model.addAttribute("newTripSchedule", tripScheduleDto);
        model.addAttribute("newStop", stopDto);
        model.addAttribute("user", userDto);
        model.addAttribute("buses", busService.findAllByAgency(id));
        model.addAttribute("trips", tripService.findAllDtoByAgency(id));
        model.addAttribute("tripSchedules", tripScheduleService.findAllDtoByAgency(id));
        model.addAttribute("stops", stopService.findAll());
        return "trips";
    }

    @GetMapping("/profile.html")
    public String viewProfile(Model model, @RequestParam("id") Long id){
        model.addAttribute("user", userService.findByIdDto(id));
        return "profile";
    }
//
//    @GetMapping("/buses")
//    public String viewBuses(@RequestParam("agencyId") Long agencyId){
//        return "buses";
//    }
//
//    @GetMapping("/trips")
//    public String viewTrips(@RequestParam("agencyId") Long agencyId){
//        return "trips";
//    }

}
