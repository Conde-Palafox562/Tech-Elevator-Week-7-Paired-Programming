package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @RequestMapping(path="/api/cards", method=RequestMethod.GET)
    public List<CatCard> getUserCollection(){
        return catCardDao.list();
    }

    @RequestMapping(path="/api/cards/{id}", method=RequestMethod.GET)
    public CatCard getByID(@PathVariable int id) {
        return catCardDao.get(id);
    }

    @RequestMapping(path="/api/cards/random", method=RequestMethod.GET)
    public CatCard getNew() {
        CatCard newCard = new CatCard();
        newCard.setCatFact(catFactService.getFact().getText());
        newCard.setImgUrl(catPicService.getPic().getFile());
        newCard.setCaption("");
        return newCard;
    }

}