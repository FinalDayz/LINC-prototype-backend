package nl.lugus.development.backend;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class LINCApplication extends Application<Configuration> {

    public static void main(final String[] args) throws Exception {
        new LINCApplication().run(args);
    }

    @Override
    public String getName() {
        return "LINC-ptorotype-backend";
    }

    @Override
    public void initialize(final Bootstrap<Configuration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final Configuration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
