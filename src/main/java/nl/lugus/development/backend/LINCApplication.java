package nl.lugus.development.backend;

import io.dropwizard.Application;
import io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.migrations.MigrationsBundle;
import nl.lugus.development.backend.persistance.ProfileDAO;
import nl.lugus.development.backend.resources.ProfileResource;
import nl.lugus.development.backend.services.ProfileService;
import nl.lugus.development.backend.util.DatabaseConnector;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import ru.vyarus.dropwizard.guice.GuiceBundle;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.sql.DataSource;
import java.util.EnumSet;

public class LINCApplication extends Application<LINCConfiguration> {

    public static void main(final String[] args) throws Exception {
        new LINCApplication().run(args);
    }

    @Override
    public String getName() {
        return "LINC-prototype-backend";
    }

    @Override
    public void initialize(final Bootstrap<LINCConfiguration> bootstrap) {
        System.out.println(
                getClass().getPackage()
        );
        bootstrap.addBundle(new MultiPartBundle());
        bootstrap.addBundle(GuiceBundle.builder()
                .enableAutoConfig(getClass().getPackage().getName())
                .build());

        bootstrap.addBundle(new MigrationsBundle<LINCConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(LINCConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(final LINCConfiguration configuration,
                    final Environment environment) {
        DataSourceFactory factory = configuration.getDataSourceFactory();
        DataSource dataSource = factory.build(environment.metrics(), "webshop");

        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin,token");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        environment.jersey().packages("app.resource");

        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        registerInjections(environment);

        new DatabaseConnector();
        DatabaseConnector.getInstance().setDataSource(dataSource);

    }

    private void registerInjections(Environment environment) {

        environment.jersey().register(new JsonProcessingExceptionMapper(true));

        environment.jersey().register(new ProfileResource(
                new ProfileService(
                        new ProfileDAO()
                )
        ));

    }

}
