import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class DirContentsListingTest {
    @Test
    public void listerReturnsStreamOfPaths() throws IOException {
        String start = "src/test/resources/test-folders";
        assertEquals(8, DirContentsListing.getDirContents(start).count());
        assertThat(DirContentsListing.getDirContents(start)
                                     .skip(1)
                                     .findFirst())
                                     .hasValue(Paths.get("src/test/resources/test-folders/t1"));

    }
}
