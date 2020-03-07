import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Imenik imenik = new Imenik();

        System.out.println("Dali sakash sam da gi vnesuvash kontaktite ?");
        String daliSam = scanner.nextLine();
        if(daliSam.equals("yes")){
            String inputNaKontakt = "";
            System.out.println("Vnesi nov kontakt");
            while (!(inputNaKontakt = scanner.nextLine()).equals("done")){
                String[] splitedKontakt = inputNaKontakt.split(" ");
                if(splitedKontakt.length > 2 || splitedKontakt.length < 2){
                    System.out.println("Ne validen input");
                    continue;
                }
                String name = splitedKontakt[0];
                if(name.equals("") || name.contains(" ")){
                    System.out.println("Nevalidno ime vnesi pak");
                    System.out.println("Vnesi nov kontakt");
                    continue;
                }
                String broj = splitedKontakt[1];
                if(broj.contains(" ") || broj.equals("")){

                    System.out.println("Vnesi validen broj");
                    System.out.println("Vnesi nov kontakt");
                    continue;
                }
                try {
                    Integer.parseInt(broj);
                } catch (Exception e){
                    System.out.println("Vnesi validen format za broj");
                    System.out.println("Vnesi nov kontakt");
                    continue;
                }
                Kontakt newKontakt = new Kontakt(name, broj);
                imenik.addKontakt(newKontakt);
                System.out.println("Vnesi nov kontakt");
            }
        } else {

            Kontakt kontakt1 = new Kontakt("Marko", "123450");
            Kontakt kontakt2 = new Kontakt("Darko", "123459");
            Kontakt kontakt3 = new Kontakt("Sharko", "123458");
            Kontakt kontakt4 = new Kontakt("Stanko", "123457");
            Kontakt kontakt5 = new Kontakt("Petko", "123456");

            imenik.addKontakt(kontakt1);
            imenik.addKontakt(kontakt2);
            imenik.addKontakt(kontakt3);
            imenik.addKontakt(kontakt4);
            imenik.addKontakt(kontakt5);

        }



        while (true) {
            System.out.println("Dali sakas da smenish kontakt ili done za kraj");
            imenik.printDetails();
            String input = scanner.nextLine();
            if (input.equals("done")) {
                break;
            }
            if(!neMeZezaj(input, imenik)){
                continue;
            }
            String[] splitedInput = input.split(" ");
            int index = Integer.parseInt(splitedInput[0]);
            String novBroj = splitedInput[1];
            System.out.println("Dali sakash da go promenish i imeto ?");
            String promenaNaIme = scanner.nextLine();
            if(promenaNaIme.equals("yes")){
                System.out.println("Vnesi go imeto shto sakash da bide ");
                String newName = scanner.nextLine();
                if(newName.contains(" ")){
                    System.out.println("Imeto shto go vnese ne ti e validno");
                    continue;
                }
                imenik.promeniImeNaKontakt(index,newName);
            }
            imenik.smeniBroj(index, novBroj);

        }
    }
    public static boolean neMeZezaj(String input, Imenik imenik){
        String[] splitedInput = input.split(" ");
        if(splitedInput.length > 2 || splitedInput.length < 2){
            System.out.println("Nemoes da me zeznesh");
            return false;
        }
        try {
            Integer.parseInt(splitedInput[0]);
            Integer.parseInt(splitedInput[1]);
        } catch (Exception e){
            System.out.println("Nemozesh da mi vnesesh bukva za broj !!!!");
            return false;
        }
        if(!imenik.isValidIndex(Integer.parseInt(splitedInput[0]))){
            System.out.println("Vnesovte id out of bounds");
            return false;
        }

        return true;
    }
}
