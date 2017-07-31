package hello.controller;

import hello.*;
import hello.entity.Clothing;
import hello.entity.Summary;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;

@RestController
public class Controll {
    SQLHandler handler = new SQLHandler();

//    @Autowired
//    private ClothingRepository clothingRepository;
//
//    @RequestMapping(path="/dress", method = RequestMethod.GET)
//    public ResponseEntity<?> getAll(){
//        return ResponseEntity.ok(clothingRepository.findAll());
//    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ArrayList<String> update(@RequestBody Summary sd) {
        ArrayList<String> list = new ArrayList<>();
        try {
            handler.connect();
            list.addAll(handler.www(sd.getId_weather(), sd.getId_sex(), sd.getId_tip()));
        } catch (SQLException e) {
            System.out.println("Проблемы при работе с БД!");
            e.printStackTrace();
        } finally {
            handler.disconnect();
        }
        return list;
    }

    @RequestMapping(value = "/s", method = RequestMethod.PUT)
    //@ResponseBody
    public String putMyData(@RequestBody ArrayList<Clothing> md) {
        int res = 0;
        try {
            handler.connect();
            for (Clothing a : md) {
                res = handler.wwwinsert(a.getId_clothing(), a.getDress());
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

//    @RequestMapping(value = "/s", method = RequestMethod.PUT)
//    //@ResponseBody
//    public String putMyData(@RequestBody Clothing md) {
//        int res = 0;
//        try {
//            handler.connect();
//            res = handler.wwwinsert(md.getId_clothing(), md.getDress());
//            System.out.println(md.getId_clothing());
//            System.out.println(md.getDress());
//            System.out.println(res);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            handler.disconnect();
//        }
//        return "Added "+res+" new entries";
//    }

//@RestController
//public class Controll {
//    SQLHandler handler = new SQLHandler();
//
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public Otvet update(@RequestBody jkjkj sd) {
//        int result = 0;
////            if(sd!=null){
////            }
//        try {
//            handler.connect();
//            result = handler.select(sd.getCity());
//        } catch (SQLException e) {
//            System.out.println("Проблемы при работе с БД!");
//            e.printStackTrace();
//        } finally {
//            handler.disconnect();
//        }
//        Otvet ot = new Otvet();
//        ot.setId(result);
//
//        return new Otvet(ot.getId());
//    }
//    @RequestMapping(value = "/", method = RequestMethod.PUT)
//    public ResponseEntity<Goroda> putt(@RequestBody Goroda sd) {
//
////            if(sd!=null){
////            }
//        try {
//            handler.connect();
//            handler.insert(sd.getCountry(), sd.getCity());
//        } catch (SQLException e) {
//            System.out.println("Проблемы при работе с БД!");
//            e.printStackTrace();
//        } finally {
//            handler.disconnect();
//        }
//
//        return new ResponseEntity<Goroda>(sd, HttpStatus.OK);
//    }
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public ResponseEntity<Mass> update(@RequestBody Mass sd){
//        if(sd!=null){
//            //sd.setName(sd.getName()+"!!!!!!!!!!");
//        }
//        try{
//            connect();
//            ResultSet set = stmt.executeQuery("select id from category where city = '"+sd.getCity()+"';");
//            System.out.println(set.getInt(1));
//        }catch (SQLException e) {
//            System.out.println("Проблемы при работе с БД!");
//            e.printStackTrace();
//        }finally {
//            disconnect();
//        }
//
//
//        return new ResponseEntity<Mass>(sd, HttpStatus.OK);
//    }

//
//    @RequestMapping(value = "/")
//    public ResponseEntity<MyDataObject> get(){
//        MyDataObject as = new MyDataObject();
//
//        as.getCountry();
//        as.getCity();
//        as.getTransport();
//        as.getData1();
//        as.getData2();
//        //as.getPeopl();
//
//        return new ResponseEntity<MyDataObject>(as, HttpStatus.OK);
//    }

//    @RequestMapping(value = "test", method = RequestMethod.PUT)
//    public void testPut(MyDataObject pupil){
//        System.out.println(pupil.toString());
//    }
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public String update(@RequestBody String sd){
//        MyDataObject asa = new MyDataObject();
//        if(sd!=null){
//            asa.setName(asa.getName()+"!!!!!!!!!!");
//        }
//
//        return asa.getName();
//    }

//    @RequestMapping("/greeting")
//    public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                String.format(template, name));
//    }
//    @RequestMapping(value= "/{time}", method = RequestMethod.GET)
//    @ResponseBody
//    public MyDataObject getMyData(@PathVariable long time) {
//        return new MyDataObject(Calendar.getInstance(), "Это ответ метода GET!");
//    }


//
//    // этот метод будет методом POST отдавать объект MyDataObject
//    @RequestMapping(value = "/as",  method = RequestMethod.POST)
//    @ResponseBody
//    public MyDataObject postMyData(MyDataObject ss) {
//        MyDataObject as = new MyDataObject();
//        System.out.println(as.getName());
//        System.out.println(ss);
//
//        return new MyDataObject("это ответ метода POST!");
//    }

    // этот метод будет принимать время методом DELETE
    // и на его основе можно удалит объект
//    @RequestMapping(value= "/{time}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public MyDataObject deleteMyData(@PathVariable long time) {
//        return new MyDataObject(Calendar.getInstance(), "Это ответ метода DELETE!");
//    }
}
