package sheridan.wasala.gameshow.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sheridan.wasala.gameshow.service.Roller;
import sheridan.wasala.gameshow.service.GiftData;

@Controller
public class GameShowController {

    private final Roller Sroller;

    public GameShowController (Roller Sroller){
        this.Sroller = Sroller;
    }

    @GetMapping(value = {"/", "/Game-Show"})
    public ModelAndView gameShow(
            @RequestParam(defaultValue = "false") boolean madeG
    ){
        if(madeG){
            GiftData giftData;
            giftData = Sroller.getGifts();
            return new ModelAndView("GameResult","giftData",giftData);

        }else{
            return new ModelAndView("GamePlay");
        }
    }


}
