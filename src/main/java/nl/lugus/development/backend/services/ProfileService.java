package nl.lugus.development.backend.services;

import nl.lugus.development.backend.persistance.ProfileDAO;

import javax.inject.Inject;

public class ProfileService {

    private ProfileDAO dao;

    @Inject
    public ProfileService(ProfileDAO dao) {
        this.dao = dao;
    }
}
