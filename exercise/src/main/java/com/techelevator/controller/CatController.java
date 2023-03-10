package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping(path="/api/cards", method = RequestMethod.GET)
    public List<CatCard> list(@RequestParam int catCardId,
                              @RequestParam String imgUrl,
                              @RequestParam String catFact,
                              @RequestParam String caption) {

        return catCardDao.list();
    }

    @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.GET)
    public CatCard get (long id) {
        CatCard catCard = catCardDao.get(id);
        if (catCard == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cat Card not found");
        } else {
            return catCardDao.get(id);
        }

    }

    @RequestMapping(path = "/api/cards/random", method = RequestMethod.GET)
    public CatCard getRandom (long id) {
        return catCardDao.get(id);
    }
}