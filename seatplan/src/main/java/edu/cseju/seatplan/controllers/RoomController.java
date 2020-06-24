package edu.cseju.seatplan.controllers;

import edu.cseju.seatplan.models.Room;
import edu.cseju.seatplan.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/abc")
@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showAllRoom()
    {
        ModelAndView allRooms = new ModelAndView();
        List<Room> list = roomService.get_All_Rooms();
        allRooms.addObject("roomObj", list);
        allRooms.setViewName("Home");
        return allRooms;
    }

    @RequestMapping(value = "/addNew", method = RequestMethod.GET)
    public ModelAndView addNewRoom()
    {
        ModelAndView allRooms = new ModelAndView();
        Room room = new Room();
        allRooms.addObject("hello",room);
        allRooms.setViewName("roomForm");
        return allRooms;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveRoom(@ModelAttribute("hello") Room room)
    {
        System.out.println(room.toString());

        roomService.saveOrUpdate(room);
        return new ModelAndView("redirect:/abc");
    }

    @RequestMapping(value = "/edit/{roomNo}", method = RequestMethod.GET)
    public ModelAndView updateRoom(@PathVariable("roomNo") String roomN)
    {
        ModelAndView mv = new ModelAndView();
        Room room = roomService.getRoomById(roomN);
        mv.addObject("hello", room);
        mv.setViewName("roomForm");
        return mv;
    }

    @RequestMapping(value = "/remove/{roomNo}", method = RequestMethod.GET)
    public ModelAndView removeRoom(@PathVariable("roomNo") String roomN)
    {
        roomService.removeRoom(roomN);
        return new ModelAndView("redirect:/abc");
    }
}
