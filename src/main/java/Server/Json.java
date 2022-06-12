package Server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Json {
    public String Type;
    public int angka;

    public Json(String Type, int angka){
        this.Type = Type;
        this.angka = angka;
    }
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

//    public static void main(String[] args) {
        //Json json = new Json("T", 1);
       // System.out.println(json);
        //json.toString();
     //   System.out.println(json.toString());
   // }
}
