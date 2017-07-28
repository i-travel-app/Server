package hello;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class My {
//    public ArrayList<Integer> sut(int a){
//
//
//
//        return new ArrayList<>().add(a);
//    }

    public static void main(String[] args) throws SQLException {
        SQLHandler handler = new SQLHandler();
        handler.connect();
        //System.out.println(handler.www("2", "1"));
        handler.disconnect();



    }

//    static class Sdd{
//        private ArrayList<Integer> list;
//
//        public Sdd() {
//        }
//
//        public ArrayList<Integer> getList() {
//            return list;
//        }
//
//        public void setList(ArrayList<Integer> list) {
//            this.list = list;
//        }
//    }


}
