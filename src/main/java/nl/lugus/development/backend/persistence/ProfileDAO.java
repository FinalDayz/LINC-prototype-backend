package nl.lugus.development.backend.persistence;

import nl.lugus.development.backend.model.User;
import nl.lugus.development.backend.persistence.mappers.UserMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface ProfileDAO {

    @SqlQuery("SELECT * FROM USERS WHERE user_id = :id")
    @Mapper(UserMapper.class)
    User findUserById(@Bind("id") int id);

    @SqlUpdate("UPDATE USERS SET " +
            "name = :name, email = :email, mobile = :mobile, profession = :profession, is_public= :isPublic " +
            "WHERE user_id = :id")
    void updateUserById(@Bind("id") int id, @BindBean User user);
}
