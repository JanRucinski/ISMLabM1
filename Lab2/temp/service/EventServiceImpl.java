package com.example.com_rucinski.service;

import com.murad.sh.carbootsale.model.SaleEvent;
import com.murad.sh.carbootsale.model.User;
import com.murad.sh.carbootsale.repository.SaleEventRepository;
import com.murad.sh.carbootsale.repository.UserRepository;
import com.murad.sh.model.SaleEventDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    @Autowired
    private SaleEventRepository saleEventRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public SaleEventDTO createSaleEvent(SaleEventDTO saleEventDTO) {
        SaleEvent saleEvent = new SaleEvent(saleEventDTO.getLocation(), saleEventDTO.getDate(), saleEventDTO.getTime(), saleEventDTO.getName(), saleEventDTO.getContactInfo(), saleEventDTO.getImage());
        System.out.println(saleEventDTO);

        System.out.println(saleEventDTO.getEventOrganizer());
        if (saleEventDTO.getEventOrganizer() != null) {
            saleEvent.setEventOrganizer(userRepository.findById(saleEventDTO.getEventOrganizer()).orElse(null));
        }
        saleEvent = saleEventRepository.save(saleEvent);
        saleEventDTO.setEventId(saleEvent.getEventId());
        return saleEventDTO;
    }

    @Override
    public SaleEventDTO getSaleEvent(Long eventId) {
        Optional<SaleEvent> saleEvent = saleEventRepository.findById(eventId);
        return saleEvent.map(this::mapToDTO).orElse(null);
    }

    @Override
    public List<SaleEventDTO> getAllSaleEvents() {
        List<SaleEvent> saleEvents = saleEventRepository.findAll();
        return saleEvents.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public SaleEventDTO updateSaleEvent(Long eventId, SaleEventDTO saleEventDTO) {
        Optional<SaleEvent> saleEventOptional = saleEventRepository.findById(eventId);
        if (saleEventOptional.isPresent()) {
            SaleEvent saleEvent = updateEntityFromDTO(saleEventDTO, saleEventOptional.get());
            saleEventRepository.save(saleEvent);
            return mapToDTO(saleEvent);
        }
        return null;
    }

    @Override
    public boolean deleteSaleEvent(Long eventId) {
        Optional<SaleEvent> saleEvent = saleEventRepository.findById(eventId);
        if (saleEvent.isPresent()) {
            saleEventRepository.deleteById(eventId);
            return true;
        }
        return false;
    }


    @Override
    public boolean registerForEvent(Long eventId, Long userId) {
        Optional<SaleEvent> saleEvent = saleEventRepository.findById(eventId);
        if (saleEvent.isPresent()) {
            Optional<User> user = userRepository.findById(userId);
            if (user.isPresent() && user.get().getRole() == User.Role.SELLER) {
                saleEvent.get().getRegisteredUsers().add(user.get());
                saleEventRepository.save(saleEvent.get());
                return true;
            }
        }
        return false;
    }

    private SaleEventDTO mapToDTO(SaleEvent saleEvent) {
        SaleEventDTO saleEventDTO = new SaleEventDTO(saleEvent.getLocation(), saleEvent.getDate(), saleEvent.getTime(), saleEvent.getName(),  saleEvent.getImage(),saleEvent.getContactInfo(),saleEvent.getEventOrganizer().getUserId());
        saleEventDTO.setEventId(saleEvent.getEventId());
        if (saleEvent.getEventOrganizer() != null) {
            saleEventDTO.setEventOrganizer(saleEvent.getEventOrganizer().getUserId());
        }
        if (saleEvent.getRegisteredUsers() != null) {
            saleEventDTO.setRegisteredUsers(saleEvent.getRegisteredUsers().stream().map(User::getUserId).collect(Collectors.toList()));
        }

        return saleEventDTO;
    }

    private SaleEvent updateEntityFromDTO(SaleEventDTO saleEventDTO, SaleEvent saleEvent) {
        saleEvent.setLocation(saleEventDTO.getLocation());
        saleEvent.setDate(saleEventDTO.getDate());
        saleEvent.setTime(saleEventDTO.getTime());
        saleEvent.setName(saleEventDTO.getName());
        saleEvent.setContactInfo(saleEventDTO.getContactInfo());
        saleEvent.setImage(saleEventDTO.getImage());
        return saleEvent;
    }



}
