package sheridan.wasala.gameshow.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sheridan.wasala.gameshow.service.Roller;
import sheridan.wasala.gameshow.service.GiftData;

@Controller
public class GameShowController {

    private final Roller Sroller;
    private final Logger log = LoggerFactory.getLogger(GameShowController.class);
    public GameShowController (Roller Sroller){
        this.Sroller = Sroller;
    }

    @GetMapping(value = {"/", "/Game-Show"})
    public ModelAndView gameShow(
            @RequestParam(defaultValue = "false") boolean madeG
    ){
        log.trace("GameShow is called");
        log.debug("isRolled = " + madeG);
        if(madeG == true){
            log.debug("Guess is made");
            GiftData giftData;
            giftData = Sroller.getGifts();
            log.debug("giftData = " + giftData);
            return new ModelAndView("GameResult","giftData",giftData);

        }else{
            log.debug("dice is not rolled");
            return new ModelAndView("GamePlay");
        }
    }


}
