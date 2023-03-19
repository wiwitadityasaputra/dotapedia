package wiwitaditya.demo.dotapedia.db.utility;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class RegionServiceTest {

    @InjectMocks
    private RegionService regionService;

    @Test
    public void getAllRegions() {
        List<String> regions = regionService.getAllRegions();
        assertEquals(regions.size(), 6);
    }

    @Test
    public void toRegions() {
        List<String> regions = regionService.toRegions(Region.CHINA);
        assertEquals(regions.size(), 1);
        assertEquals(regions.get(0), Region.CHINA.toString());
    }
}
