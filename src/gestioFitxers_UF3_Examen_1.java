import java.io.*;


public class gestioFitxers_UF3_Examen_1 {

    /** 1. Escriu un programa que donat un pathname realitzi les següents operacions,
    informant-ne per pantalla:

     • Comprovar si existeix (1 punt)

     • Si existeix informar del tamany si és un fitxer, i del número de fitxers que conté si és un
    directori (2 punts)

     • Si no existeix, crear un fitxer buit si el pathname conté el caràcter punt '.' i un directori en
    cas contrari (2 punts)
     **/



    final String ruta = "src/holamon";


    public static void main(String[] args) {
        ex1();
        ex2();
    }


    public static void ex2(){

        String arxiuText = "/src/arxiuDeParaules.txt";

        gestioFitxers_UF3_Examen_1 g = new gestioFitxers_UF3_Examen_1();
        g.analitzadorParaules(arxiuText);
        g.analitzadorParaules02(arxiuText);
        
    }





    /** Segon Exercici. Segona part**/


    public void analitzadorParaules02(String arxiu){

        String arxiuDesti = "src/log";

        int totalParaules = 0;

        try {

            BufferedReader br = new BufferedReader(new FileReader(arxiu));

            while(br.readLine() != null){

                //La separació es fa només per espais en blanc.
                //Es sumen les paraules per cada linia
                String [] linia =  br.readLine().split(" ");
                totalParaules = totalParaules + linia.length;
            }

            File f = new File(arxiu);
            String linia = (f.getAbsolutePath().toString()) + "/" + f.getName() + totalParaules;


            BufferedWriter bw = new BufferedWriter(new FileWriter(arxiuDesti, true));

            bw.write(linia);
            bw.newLine();
            bw.close();



        }catch (IOException e){
            e.printStackTrace();
        }
    }


    /** Segon Exercici. Primera part**/


    public void analitzadorParaules(String arxiu){

        int totalParaules = 0;

        try {

            BufferedReader br = new BufferedReader(new FileReader(arxiu));

            while(br.readLine() != null){

                //La separació es fa només per espais en blanc.
                //Es sumen les paraules per cada linia
                String [] linia =  br.readLine().split(" ");
                totalParaules = totalParaules + linia.length;
            }

            System.out.println("El total de linies es: "+ totalParaules);

        }catch (IOException e){
            e.printStackTrace();
        }
    }





    /** Primer Exercici **/
    public static void ex1(){

        gestioFitxers_UF3_Examen_1 ex1 = new gestioFitxers_UF3_Examen_1();

        if(ex1.existenciaPath()){
            if(ex1.esUnfitxer()){
                ex1.pintaMidaFitxer();
            }else{
                ex1.pintaNumFitxers();
            }
        }else{
            if(ex1.contePunt()){
                ex1.creaFitxerBuit();
            }else{
                ex1.creaDirectori();
            }
        }
    }



    public void creaDirectori(){

        File ff = new File (ruta.concat("/directoriBuit"));
        ff.mkdir();
    }




    public void creaFitxerBuit(){

        File ff = new File (ruta.concat("/fitxerbuit"));

        try{
            ff.createNewFile();

        }catch (IOException e){
            e.printStackTrace();
        }

    }





    public void pintaNumFitxers(){

        File d = new File(ruta);
        File [] llistaFitxers = d.listFiles();

        int numFitxers = 0;

        for (File ff: llistaFitxers) {
            if (ff.isFile()){
                numFitxers++;
            }
        }

        System.out.println("El número de fitxers es "+ numFitxers);

    }



    public boolean contePunt(){

        boolean sortida = false;

        File f = new File(ruta);

        String cadena = f.getName();

        char[] caracters =  cadena.toCharArray();

        for (int i = 0; i < caracters.length ; i++) {
            if(caracters[i]== '.'){
                sortida = true;
            }
        }

        return sortida;
    }



    public void pintaMidaFitxer(){

        File f = new File(ruta);

        System.out.println("La mida es de" + f.length());
    }




    public boolean esUnfitxer(){

        boolean esFitxer = false;

        File f = new File(ruta);

        if(f.isFile()){
            esFitxer = true;
        }

        return esFitxer;
    }




    public boolean existenciaPath(){
        boolean existeix = false;

        File f = new File(ruta);

        if(f.exists()){
            existeix = true;
        }

        return existeix;
    }



}
