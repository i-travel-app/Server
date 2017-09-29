package de.rest.controllers;


import de.rest.entity.Put;
import de.rest.repositories.ClothingRepository;
import de.rest.repositories.PutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Обрабатывает запросы.
 */
@RestController
public class Controller {

    @Autowired
    ClothingRepository clothingRepository;

    @Autowired
    PutRepository putRepository;

    /**
     * Выводим данные всех таблиц.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<?> allPrint() {
        return clothingRepository.allPrint();
    }

    /**
     * Выводим данные по трем характеристикам.
     */
    @RequestMapping(value = "/three", method = RequestMethod.GET)
    public List<?> threeElement(int w, int s, int t) {
        System.out.println(w + " " + s + " " + t);
        return clothingRepository.threeElement(w, s, t);
    }

//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public Integer temp(@RequestBody Summary sd){
//        sd.setId_weather(9);
//        System.out.println(sd.getId_weather()+" "+sd.getId_sex());
//        return sd.getId_sex();
//    }

    /**
     * Добавляем данные в таблицу обработки.
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Integer saveData(@RequestBody ArrayList<Put> md) {
        putRepository.save(md);
        return md.size();
    }

    /**
     * Выводит все данные из таблицы обработки.
     */
    @RequestMapping(value = "/p", method = RequestMethod.GET)
    public List<Put> printPutAll() {
        return putRepository.findAll();
    }

    /**
     * Удаляет данные из таблицы обработки.
     */
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deletePut(@RequestBody ArrayList<Put> md) {
        putRepository.delete(md);
    }
}
