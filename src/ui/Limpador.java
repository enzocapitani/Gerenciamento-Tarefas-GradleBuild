package ui;

public class Limpador {
    
    public static void limpar(){
        try {
            String os = System.getProperty("os.name");

            if(os.contains("Windows")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }else{
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
