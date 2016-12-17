package hu.schonherz.java.training.kovtamas.jdbcpractice.data.dao;

import hu.schonherz.java.training.kovtamas.jdbcpractice.data.datasource.DataSourceManager;
import hu.schonherz.java.training.kovtamas.jdbcpractice.data.dto.ParticipantDTO;
import hu.schonherz.java.training.kovtamas.jdbcpractice.data.queries.ParticipantQueries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ParticipantDAO implements GenericDAO<ParticipantDTO> {

    @Override
    public Collection<ParticipantDTO> findAll() {
        List<ParticipantDTO> participants = new ArrayList<>();

        try (Connection conn = DataSourceManager.getDataSource().getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(ParticipantQueries.QUERY_FIND_ALL);

            while (rs.next()) {
                participants.add(toDTO(rs));
            }
        } catch (SQLException sqle) {
            System.err.println("sql exception while communication with the database");
            sqle.printStackTrace();
        }

        return participants;
    }

    @Override
    public ParticipantDTO findById(int id) {
        ParticipantDTO dto = new ParticipantDTO();

        try (Connection conn = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement prStatement = conn.prepareStatement(ParticipantQueries.QUERY_FIND_BY_ID);
            prStatement.setInt(1, id);
            ResultSet rs = prStatement.executeQuery();
            if (rs.next()) {
                dto = toDTO(rs);
            }
        } catch (SQLException sqle) {
            System.err.println("sql exception while communication with the database");
            sqle.printStackTrace();
        }

        return dto;
    }

    @Override
    public int save(ParticipantDTO dto) {
        try (Connection conn = DataSourceManager.getDataSource().getConnection()) {
            PreparedStatement prStatement
                    = conn.prepareStatement(ParticipantQueries.QUERY_SAVE, Statement.RETURN_GENERATED_KEYS);
            prStatement.setString(1, dto.getName());
            prStatement.setString(2, dto.getEmail());
            prStatement.execute();

            ResultSet ids = prStatement.getGeneratedKeys();
            if (ids.next()) {
                return ids.getInt("id");
            }
        } catch (SQLException sqle) {
            System.err.println("sql exception while communication with the database");
            sqle.printStackTrace();
        }

        return 0;
    }

    private static ParticipantDTO toDTO(ResultSet rs) throws SQLException {
        ParticipantDTO dto = new ParticipantDTO();
        dto.setId(rs.getInt("id"));
        dto.setName(rs.getString("name"));
        dto.setEmail(rs.getString("email"));

        return dto;
    }

}
