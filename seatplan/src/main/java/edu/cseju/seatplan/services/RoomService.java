package edu.cseju.seatplan.services;

import edu.cseju.seatplan.models.Room;

import java.util.List;

public interface RoomService {

    public List<Room> get_All_Rooms();
    public Room getRoomById(String roomNo);
    public void saveOrUpdate(Room room);
    public void removeRoom(String roomNo);
}
