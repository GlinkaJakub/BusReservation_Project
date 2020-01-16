package com.glinka.mtab.controller;

import com.glinka.mtab.dto.*;
import com.glinka.mtab.model.entity.Agency;
import com.glinka.mtab.model.entity.Stop;
import com.glinka.mtab.model.entity.Trip;
import com.glinka.mtab.model.entity.TripSchedule;
import com.glinka.mtab.service.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;

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

//    ----------------------------------------------------------------------------
//    ----------------------------------------------------------------------------

    @GetMapping("/index.html")
    public String viewBoard(Model model, Authentication authentication){

        String login = authentication.getName();
        UserDto user = userService.findByLogin(login);
        Long userId = userService.findByLogin(login).getId();
        model.addAttribute("user", user);
        model.addAttribute("userName", login);
        model.addAttribute("userId", userId);
        try {
            Long agencyId = agencyService.findAllByOwner(userService.findById(userId)).get(0).getId();
            model.addAttribute("agencyId", agencyId);
        } catch (Exception e){
            System.out.println(e);
        }

        return "index";
    }

    @GetMapping("/agency.html")
    public String viewAgency(Model model, Authentication authentication){
        String login = authentication.getName();
        Long userId = userService.findByLogin(login).getId();
        Long agencyId = agencyService.findAllByOwner(userService.findById(userId)).get(0).getId();
        AgencyDto agencyDto = agencyService.findDtoById(agencyId);
        UserDto userDto = userService.findByIdDto(agencyDto.getOwner());

        model.addAttribute("userName", login);
        model.addAttribute("userId", userId);
        model.addAttribute("agencyId", agencyId);

        model.addAttribute("agency", agencyDto);
        model.addAttribute("user", userDto);
        return "agency";
    }

    @GetMapping("/buses.html")
    public String viewBuses(Model model, Authentication authentication){
        String login = authentication.getName();
        Long userId = userService.findByLogin(login).getId();
        Long agencyId = agencyService.findAllByOwner(userService.findById(userId)).get(0).getId();

        AgencyDto agencyDto = agencyService.findDtoById(agencyId);
        UserDto userDto = userService.findByIdDto(agencyDto.getOwner());
        BusDto busDto = new BusDto();

        model.addAttribute("userName", login);
        model.addAttribute("userId", userId);
        model.addAttribute("agencyId", agencyId);

        model.addAttribute("newBus", busDto);
        model.addAttribute("user", userDto);
        model.addAttribute("buses", busService.findAllByAgency(agencyId));
        return "buses";
    }

    @GetMapping("/trips.html")
    public String viewTrips(Model model, Authentication authentication){
        String login = authentication.getName();
        Long userId = userService.findByLogin(login).getId();

        AgencyDto agencyDto = agencyService.findDtoById(userId);
        UserDto userDto = userService.findByIdDto(userId);
        TripDto tripDto = new TripDto();
        TripScheduleDto tripScheduleDto = new TripScheduleDto();
        StopDto stopDto = new StopDto();

        model.addAttribute("userName", login);
        model.addAttribute("userId", userId);
        Long agencyId = agencyService.findAllByOwner(userService.findById(userId)).get(0).getId();
        model.addAttribute("agencyId", agencyId);

        model.addAttribute("newTrip", tripDto);
        model.addAttribute("newTripSchedule", tripScheduleDto);
        model.addAttribute("newStop", stopDto);
        model.addAttribute("user", userDto);
        model.addAttribute("buses", busService.findAllByAgency(agencyId));
        model.addAttribute("trips", tripService.findAllDtoByAgency(agencyId));
        model.addAttribute("tripSchedules", tripScheduleService.findAllDtoByAgency(agencyId));
        model.addAttribute("stops", stopService.findAll());
        return "trips";
    }

    @GetMapping("/profile.html")
    public String viewProfile(Model model, Authentication authentication){

        String login = authentication.getName();
        Long userId = userService.findByLogin(login).getId();
        model.addAttribute("userName", login);
        model.addAttribute("userId", userId);
        model.addAttribute("user", userService.findByIdDto(userId));

        return "profile";
    }

    @Transactional
    @PostMapping("/saveAdmin")
    public String saveAdmin(@ModelAttribute("user") UserDto userDto, Authentication authentication){
        String login = authentication.getName();
        Long userId = userService.findByLogin(login).getId();

        if (userDto.getRoleId() != null)
            userDto.setRoleId(6L);
        userDto.setId(userId);
        userService.save(userDto);
        return "redirect:/profile.html";
    }

    @Transactional
    @PostMapping("/saveAgency")
    public String saveAgency(@ModelAttribute("agency") AgencyDto agencyDto, Authentication authentication) {
        String login = authentication.getName();
        Long userId = userService.findByLogin(login).getId();
        Long agencyId = agencyService.findAllByOwner(userService.findById(userId)).get(0).getId();
        agencyDto.setId(agencyId);
        agencyService.save(agencyDto);
        return "redirect:/agency.html";
    }

    @Transactional
    @PostMapping("/saveBus")
    public String saveBus(@ModelAttribute("newBus") BusDto busDto, Authentication authentication) {
        String login = authentication.getName();
        Long userId = userService.findByLogin(login).getId();
        Long agencyId = agencyService.findAllByOwner(userService.findById(userId)).get(0).getId();
        busDto.setAgencyId(agencyId);
        busService.save(busDto);
        return "redirect:/buses.html";
    }

    @Transactional
    @PostMapping("/saveTrip")
    public String saveTrip(@ModelAttribute("newTrip") TripDto tripDto) {
        tripDto.setAgencyId(9L);
        tripService.save(tripDto);
        return "redirect:/trips.html";
    }

    @Transactional
    @PostMapping("/saveTripSchedule")
    public String saveTripSchedule(@ModelAttribute("tripSchedule") TripScheduleDto tripScheduleDto) {
        tripScheduleService.save(tripScheduleDto);
        return "redirect:/trips.html";
    }

    @Transactional
    @PostMapping("/saveStop")
    public String saveStop(@ModelAttribute("stop") StopDto stopDto) {
        stopService.save(stopDto);
        return "redirect:/trips.html";
    }


}
