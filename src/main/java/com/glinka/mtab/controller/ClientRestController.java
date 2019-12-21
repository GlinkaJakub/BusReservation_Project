package com.glinka.mtab.controller;

import com.glinka.mtab.dto.*;
import com.glinka.mtab.model.entity.*;
import com.glinka.mtab.service.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientRestController {

    private final UserService userService;
    private final RoleService roleService;
    private final AgencyService agencyService;
    private final BusService busService;
    private final StopService stopService;
    private final TicketService ticketService;
    private final TripService tripService;
    private final TripScheduleService tripScheduleService;

    public ClientRestController(UserService userService, RoleService roleService, AgencyService agencyService, BusService busService, StopService stopService, TicketService ticketService, TripService tripService, TripScheduleService tripScheduleService) {
        this.userService = userService;
        this.roleService = roleService;
        this.agencyService = agencyService;
        this.busService = busService;
        this.stopService = stopService;
        this.ticketService = ticketService;
        this.tripService = tripService;
        this.tripScheduleService = tripScheduleService;
    }

    @GetMapping("/allUsers")
    public List<UserDto> findAll(){
        return userService.findAll();
    }

    @GetMapping("/allRoles")
    public List<RoleDto> findAllRoles(){
        return roleService.findAll();
    }

    @GetMapping("/allAgencies")
    public List<AgencyDto> findAllAgencies() {
        return agencyService.findAll();
    }

    @GetMapping("/allBuses")
    public List<BusDto> findAllBuses() {
        return busService.findAll();
    }

    @GetMapping("/allStops")
    public List<StopDto> findAllStops() {
        return stopService.findAll();
    }

    @GetMapping("/allTrips")
    public List<TripDto> findAllTrips() {
        return tripService.findAll();
    }

    @GetMapping("/allTickets")
    public List<TicketDto> findAllTickets() {
        return ticketService.findAll();
    }

    @GetMapping("/allTripSchedules")
    public List<TripScheduleDto> findAllTripSchedules() {
        return tripScheduleService.findAll();
    }

//-----------------------Save-element-------------------------------------------------------------------

    @Transactional
    @PostMapping("/saveRole")
    public Role addRole(@RequestBody RoleDto roleDto){
        return roleService.save(roleDto);
    }

    @Transactional
    @PostMapping("/saveUser")
    public User saveClient(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }

    @Transactional
    @PostMapping("/saveAgency")
    public Agency saveAgency(@RequestBody AgencyDto agencyDto) {
        return agencyService.save(agencyDto);
    }

    @Transactional
    @PostMapping("/saveBus")
    public Bus saveBus(@RequestBody BusDto busDto) {
        return busService.save(busDto);
    }

    @Transactional
    @PostMapping("/saveStop")
    public Stop saveStop(@RequestBody StopDto stopDto) {
        return stopService.save(stopDto);
    }

    @Transactional
    @PostMapping("/saveTicket")
    public Ticket saveTicket(@RequestBody TicketDto ticketDto) {
        return ticketService.save(ticketDto);
    }

    @Transactional
    @PostMapping("/saveTrip")
    public Trip saveTrip(@RequestBody TripDto tripDto) {
        return tripService.save(tripDto);
    }

    @Transactional
    @PostMapping("/saveTripSchedule")
    public TripSchedule saveTripSchedule(@RequestBody TripScheduleDto tripScheduleDto) {
        return tripScheduleService.save(tripScheduleDto);
    }
}
