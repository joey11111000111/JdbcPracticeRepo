package hu.schonherz.java.training.kovtamas.jdbcpractice.data.mapper;

import hu.schonherz.java.training.kovtamas.jdbcpractice.data.dto.ParticipantDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ParticipantMapper implements RowMapper<ParticipantDTO> {

    @Override
    public ParticipantDTO mapRow(ResultSet rs, int i) throws SQLException {
        ParticipantDTO dto = new ParticipantDTO();

        dto.setId(rs.getInt("id"));
        dto.setName(rs.getString("name"));
        dto.setEmail(rs.getString("email"));

        return dto;
    }

}
