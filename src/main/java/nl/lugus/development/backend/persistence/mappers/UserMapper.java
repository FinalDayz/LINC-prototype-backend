package nl.lugus.development.backend.persistence.mappers;

import nl.lugus.development.backend.model.User;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements ResultSetMapper<User> {
    @Override
    public User map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        String name = resultSet.getString("name");
        String profession = resultSet.getString("profession");
        String email = resultSet.getString("email");
        String mobile = resultSet.getString("mobile");
        boolean isPublic = resultSet.getBoolean("is_public");
        return new User(name, profession, email, mobile, isPublic);
    }
}
