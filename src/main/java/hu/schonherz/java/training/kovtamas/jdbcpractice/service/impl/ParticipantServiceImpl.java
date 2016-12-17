package hu.schonherz.java.training.kovtamas.jdbcpractice.service.impl;

import hu.schonherz.java.training.kovtamas.jdbcpractice.data.dao.GenericDAO;
import hu.schonherz.java.training.kovtamas.jdbcpractice.data.dao.ParticipantDAO;
import hu.schonherz.java.training.kovtamas.jdbcpractice.data.dto.ParticipantDTO;
import hu.schonherz.java.training.kovtamas.jdbcpractice.service.api.ParticipantService;
import hu.schonherz.java.training.kovtamas.jdbcpractice.service.vo.ParticipantVO;

public class ParticipantServiceImpl implements ParticipantService {

    private final GenericDAO dao;

    public ParticipantServiceImpl() {
        dao = new ParticipantDAO();
    }

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
