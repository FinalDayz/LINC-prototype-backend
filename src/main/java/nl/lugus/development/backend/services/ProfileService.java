package nl.lugus.development.backend.services;

import nl.lugus.development.backend.model.User;
import nl.lugus.development.backend.persistence.DAOFactory;
import nl.lugus.development.backend.persistence.ProfileDAO;

import javax.inject.Inject;

public class ProfileService {

    private ProfileDAO dao;

    @Inject
    public ProfileService(DAOFactory factory) {
        this.dao = factory.onDemand(ProfileDAO.class);
    }

    public User getUserById(int id) {
        return dao.findUserById(id);
    }

    public void updateUserById(int id, User user) {
        dao.updateUserById(id, user);
    }
}
