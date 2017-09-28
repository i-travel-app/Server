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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<?> allPrint(){
        return clothingRepository.allPrint();
    }

    @RequestMapping(value = "/three", method = RequestMethod.GET)
    public List<?> threeElement(int w, int s, int t){
        System.out.println(w+" "+ s+" "+ t);
        return clothingRepository.threeElement(w, s, t);
    }

//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public Integer temp(@RequestBody Summary sd){
//        sd.setId_weather(9);
//        System.out.println(sd.getId_weather()+" "+sd.getId_sex());
//        return sd.getId_sex();
//    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Integer saveData(@RequestBody ArrayList<Put> md){
        putRepository.save(md);
        return md.size();
    }

    @RequestMapping(value = "/p", method = RequestMethod.GET)
    public List<Put> printPutAll(){
        return putRepository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deletePut(@RequestBody ArrayList<Put> md){
        putRepository.delete(md);
    }


//    /**
//     * Получение данных по параметрам.
//     */
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public ArrayList<String> update(@RequestBody Summary sd) {
//        ArrayList<String> list = new ArrayList<>();
//        try {
//            handler.connect();
//            list.addAll(handler.requestData(sd.getId_weather(), sd.getId_sex(), sd.getId_tip()));
//        } catch (SQLException e) {
//            System.out.println("Проблемы при работе с БД!");
//            e.printStackTrace();
//        } finally {
//            handler.disconnect();
//        }
//        return list;
//    }
//
//    /**
//     * Добавление данных.
//     */
//    @RequestMapping(value = "/s", method = RequestMethod.PUT)
//    public String putMyData(@RequestBody ArrayList<Clothing> md) {
//        int res = 0;
//        try {
//            handler.connect();
//            for (Clothing a : md) {
//                res = handler.insertData(a.getId_clothing(), a.getDress());
//                ++res;
//                System.out.println(a.getId_clothing());
//                System.out.println(a.getDress());
//                System.out.println(res);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            handler.disconnect();
//        }
//        return "Added " + res + " new entries";
//    }
//
//    /**
//     * Удаление данных
//     */
//    @RequestMapping(value = "/d", method = RequestMethod.DELETE)
//    public String deleteMyData(@RequestBody ArrayList<Clothing> md) {
//        int res = 0;
//        try {
//            handler.connect();
//            for (Clothing a : md) {
//                res = res + handler.deleteData(a.getDress());
//                System.out.println(a.getDress());
//                System.out.println(res);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            handler.disconnect();
//        }
//        return "Delete " + res + " entries";
//    }
}
