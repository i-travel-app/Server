package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controll {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<MyDataObject> update(@RequestBody MyDataObject sd){
            if(sd!=null){
                sd.setName(sd.getName()+"!!!!!!!!!!");
            }

        return new ResponseEntity<MyDataObject>(sd, HttpStatus.OK);
    }


//    @RequestMapping(value = "/")
//    public ResponseEntity<MyDataObject> get(){
//        MyDataObject as = new MyDataObject();
//
//        as.setName("Anatoly");
//
//        return new ResponseEntity<MyDataObject>(as, HttpStatus.OK);
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

//    @RequestMapping(method = RequestMethod.PUT)
//    @ResponseBody
//    public MyDataObject putMyData(@RequestBody MyDataObject md) {
//        return md;
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
