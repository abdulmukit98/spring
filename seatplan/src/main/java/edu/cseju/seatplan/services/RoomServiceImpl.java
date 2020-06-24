package edu.cseju.seatplan.services;

import edu.cseju.seatplan.models.Room;
import edu.cseju.seatplan.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Override
    public List<Room> get_All_Rooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(String roomNo) {
        return roomRepository.getOne(roomNo);
    }

    @Override
    public void saveOrUpdate(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void removeRoom(String roomNo) {
        roomRepository.deleteById(roomNo);
    }
}
