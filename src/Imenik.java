import java.util.ArrayList;
import java.util.List;

public class Imenik {
    private List<Kontakt> kontaktList;

    public Imenik() {
        kontaktList = new ArrayList<>();
    }

    public void addKontakt(Kontakt kontakt){
        kontaktList.add(kontakt);
    }

    public void printDetails(){
        for (int i = 0; i < kontaktList.size(); i++) {
            System.out.println(i + ") " + kontaktList.get(i).getIme() + ": " + kontaktList.get(i).getBroj());
        }
    }
    public boolean isValidIndex(int index){
        if(index < 0 || index >= kontaktList.size()){
            return false;
        }
        return true;
    }
    public void smeniBroj(int index, String novBroj) {
        kontaktList.get(index).setBroj(novBroj);
    }

    public void promeniImeNaKontakt(int index, String newName) {
        kontaktList.get(index).setIme(newName);
    }
}
