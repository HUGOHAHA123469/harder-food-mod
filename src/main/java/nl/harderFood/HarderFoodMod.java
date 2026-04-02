package nl.harderFood;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class HarderFoodMod implements ModInitializer {
    public static final String MOD_ID = "harder_food";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        LOGGER.info("HarderFood geladen!");
    }
}
