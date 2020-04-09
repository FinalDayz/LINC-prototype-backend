package nl.lugus.development.backend.persistence;

import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

import javax.inject.Inject;

public class DAOFactory {
    private final DBI factory;

    @Inject
    public DAOFactory(Environment env, DataSourceFactory dataSourceFactory) throws ClassNotFoundException {
        this.factory = (new DBIFactory()).build(env, dataSourceFactory, "postgresql");
    }

    public <T> T onDemand(Class<T> dao) {
        return this.factory.onDemand(dao);
    }
}
