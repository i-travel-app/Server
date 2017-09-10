package hello.controller;

import hello.*;
import hello.entity.Clothing;
import hello.entity.Summary;

import org.springframework.web.bind.annotation.*;

import java.sql.*;

import java.util.ArrayList;

/**
 * Обрабатывает запросы.
 */
@RestController
public class Controll {
    SQLHandler handler = new SQLHandler();

    /**
     * Получение данных по параметрам.
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ArrayList<String> update(@RequestBody Summary sd) {
        ArrayList<String> list = new ArrayList<>();
        try {
            handler.connect();
            list.addAll(handler.requestData(sd.getId_weather(), sd.getId_sex(), sd.getId_tip()));
        } catch (SQLException e) {
            System.out.println("Проблемы при работе с БД!");
            e.printStackTrace();
        } finally {
            handler.disconnect();
        }
        return list;
    }

    /**
     * Добавление данных.
     */
    @RequestMapping(value = "/s", method = RequestMethod.PUT)
    public String putMyData(@RequestBody ArrayList<Clothing> md) {
        int res = 0;
        try {
            handler.connect();
            for (Clothing a : md) {
                res = handler.insertData(a.getId_clothing(), a.getDress());
                ++res;
                System.out.println(a.getId_clothing());
                System.out.println(a.getDress());
                System.out.println(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            handler.disconnect();
        }
        return "Added " + res + " new entries";
    }

    /**
     * Удаление данных
     */
    @RequestMapping(value = "/d", method = RequestMethod.DELETE)
    public String deleteMyData(@RequestBody ArrayList<Clothing> md) {
        int res = 0;
        try {
            handler.connect();
            for (Clothing a : md) {
                res = res + handler.deleteData(a.getDress());
                System.out.println(a.getDress());
                System.out.println(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            handler.disconnect();
        }
        return "Delete " + res + " entries";
    }
}
