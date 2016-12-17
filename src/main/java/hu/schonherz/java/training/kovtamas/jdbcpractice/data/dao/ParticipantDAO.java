package hu.schonherz.java.training.kovtamas.jdbcpractice.data.dao;

import hu.schonherz.java.training.kovtamas.jdbcpractice.data.dto.ParticipantDTO;
import hu.schonherz.java.training.kovtamas.jdbcpractice.data.mapper.ParticipantMapper;
import hu.schonherz.java.training.kovtamas.jdbcpractice.data.queries.ParticipantQueries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class ParticipantDAO implements GenericDAO<ParticipantDTO> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Collection<ParticipantDTO> findAll() {
        return jdbcTemplate.query(ParticipantQueries.QUERY_FIND_ALL, new ParticipantMapper());
    }

    @Override
    public ParticipantDTO findById(int id) {
        return jdbcTemplate.queryForObject(ParticipantQueries.QUERY_FIND_BY_ID, new Integer[]{id}, new ParticipantMapper());
    }

    @Override
    public int save(ParticipantDTO dto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection cnctn) throws SQLException {
                PreparedStatement prStatement = cnctn.prepareStatement(
                        ParticipantQueries.QUERY_SAVE, PreparedStatement.RETURN_GENERATED_KEYS);
                prStatement.setString(1, dto.getName());
                prStatement.setString(2, dto.getEmail());

                return prStatement;
            }
        }, keyHolder);

        return keyHolder.getKey().intValue();

        // if the key is not needed:
//        return jdbcTemplate.update(ParticipantQueries.QUERY_SAVE, dto.getName(), dto.getEmail());
    }

}
