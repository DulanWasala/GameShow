package sheridan.wasala.gameshow.service;
import java.util.Collections;
import java.util.List;


public class GiftDataEx implements GiftData {

    // Variables
    private final List<Integer> gifts;

    public GiftDataEx (List<Integer> gifts){
        this.gifts = gifts;

    }
    @Override
    public List<Integer> getValues() {

        return gifts;
    }

}
