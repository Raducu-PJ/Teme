
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void scriere(List<Pereche> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            File file=new File("C:\\ss\\Lab5\\src\\perechi.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<PerecheNumere> citire() {
        try {
            File file=new File("C:\\ss\\Lab5\\src\\perechi.json");
            ObjectMapper mapper=new ObjectMapper();
            List<PerecheNumere> persoane = mapper
                    .readValue(file, new TypeReference<List<PerecheNumere>>(){});
            return persoane;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {


        List<PerecheNumere> p2=citire();
        p2.forEach(System.out::println);

        System.out.println("\n");
        System.out.println("Consecutive:");
        for(PerecheNumere perecheNumere:p2){
            System.out.println(perecheNumere.isConsecutive());
        }

        System.out.println("\n");
        System.out.println("CMMDC:");
        for(PerecheNumere perecheNumere:p2){
            System.out.println(perecheNumere.cmmdc());
        }

        System.out.println("\n");
        System.out.println("Suma cifrelor egala:");
        for(PerecheNumere perecheNumere:p2){
            System.out.println(perecheNumere.isSumaCifrelorEgala());
        }

        System.out.println("\n");
        System.out.println("Perechile cu nr cifre pare egale:");
        for(PerecheNumere perecheNumere:p2){
            if(perecheNumere.isNumarCifrePareEgale()){
                System.out.println(perecheNumere);
            }
        }
    }
}
