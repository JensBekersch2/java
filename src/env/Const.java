package env;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Const {
	public static final Path CONFIG_LOCATION = Paths.get(System.getProperty("user.home"), ".bbox", "config.properties");
}
