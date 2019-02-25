import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirContentsListing {
    public static Stream<Path> getDirContents(String start) throws IOException {
        Stream<Path> paths = Files.walk(Paths.get(start));
        return paths;
    }
}
