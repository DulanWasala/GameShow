package sheridan.wasala.gameshow.service;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class RollerEx implements Roller{

    private final Random r;
    public RollerEx(Random random){
        this.r = random;
    }

    public RollerEx (){
        this(new Random());
    }

    @Override
    public GiftData getGifts(){
        List<Integer> temp = r.ints(3,1,4).boxed().collect(Collectors.toList());
        return new GiftDataEx(temp);
    }


}
