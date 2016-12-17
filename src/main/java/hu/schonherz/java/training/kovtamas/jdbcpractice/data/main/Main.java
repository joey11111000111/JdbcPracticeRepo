package hu.schonherz.java.training.kovtamas.jdbcpractice.data.main;

import hu.schonherz.java.training.kovtamas.jdbcpractice.data.dao.GenericDAO;
import hu.schonherz.java.training.kovtamas.jdbcpractice.data.dao.ParticipantDAO;
import hu.schonherz.java.training.kovtamas.jdbcpractice.data.dto.ParticipantDTO;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        GenericDAO<ParticipantDTO> participantDAO = new ParticipantDAO();
        Collection<ParticipantDTO> results = participantDAO.findAll();
        System.out.println(results);

        ParticipantDTO dto = new ParticipantDTO();
        dto.setEmail("valami@asd.de");
        dto.setName("Somebody Here");
        participantDAO.save(dto);

        dto = participantDAO.findById(8);
        System.out.println(dto);
    }

}
