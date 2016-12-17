package hu.schonherz.java.training.kovtamas.jdbcpractice.service.impl;

import hu.schonherz.java.training.kovtamas.jdbcpractice.data.dao.GenericDAO;
import hu.schonherz.java.training.kovtamas.jdbcpractice.data.dto.ParticipantDTO;
import hu.schonherz.java.training.kovtamas.jdbcpractice.service.api.ParticipantService;
import hu.schonherz.java.training.kovtamas.jdbcpractice.service.vo.ParticipantVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    @Autowired
    private GenericDAO<ParticipantDTO> dao;

    @Override
    public void save(ParticipantVO vo) {
        dao.save(VoToDTO(vo));
    }

    private static ParticipantDTO VoToDTO(ParticipantVO vo) {
        ParticipantDTO dto = new ParticipantDTO();
        dto.setId(vo.getId());
        dto.setName(vo.getName());
        dto.setEmail(vo.getEmail());
        return dto;
    }

}
