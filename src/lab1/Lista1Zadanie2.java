package lab1;

public class Lista1Zadanie2 {
    public static void main(String[] args) {
        String inwokacja = "Litw0=0jczyzno moja, Ty jestes jak zdr0w13, ile C13=c3n1c, t3n ty1k0 si3 d0wie=_kt0 C13 stracil.";
        String id1id2 = "_poprawneid1=poprawneid2";
        String id1id2id3="_id1=id2asdf=poprawneid3";
        String zlyPoczatek="0238745Id1=id2";//0238745id2=Id1
        String id1Zleid2="id1id1=6789523zleid";//bez zmiany
        String id1Spacja="id1 ";//id1 (spacja na koncu)
        String zakonczenieRownoscia="id1=";//id1=
        String poczatekRownoscia="=id1=id2";//=id2=id1

        System.out.println("test dla inwokacji");
        System.out.println(pairSwap(inwokacja));
        System.out.println("test podstawowy _poprawneid1=poprawneid2");
        System.out.println(pairSwap(id1id2));
        System.out.println("test dla trzech poprawnych id pod rzad _poprawneId1=poprawneId2=_poprawneid3");
        System.out.println(pairSwap(id1id2id3));
        System.out.println("test dla zlego poczatku 0238745Id1=id2");
        System.out.println(pairSwap(zlyPoczatek));
        System.out.println("test dla poprawnego id1 i zlego id2");
        System.out.println(pairSwap(id1Zleid2));
        System.out.println("test dla zakonczenia spacja id1 ");
        System.out.println(pairSwap(id1Spacja));
        System.out.println("test dla zakonczenia=");
        System.out.println(pairSwap(zakonczenieRownoscia));
        System.out.println("test dla poczatku =");
        System.out.println(pairSwap(poczatekRownoscia));
    }

    public static boolean checkIfGoodBeginning(char c) {
        return Character.isLetter(c) || c == '_';
    }

    public static boolean checkIfGoodId(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }

    public static String pairSwap(String text) {
        boolean creatingId = false;
        String id1="";
        String currentId = "";
        String output="";

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            //sprawdz czy poprawny poczatek id, jesli tak rozpocznij tworzyc id, jesli nie dodaj char do output
            if (!creatingId) {

                if (checkIfGoodBeginning(c)) {
                    creatingId = true;
                    currentId += c;
                } else {
                    //przypadek typu dobreId=3ZleId  obecny char to 3
                    if(id1.length()!=0){
                        output += id1+ "=";
                        id1="";
                    }
                    output+=c;
                }

            }
            //creatingId==true
            else{
                //jezeli znak pasujacy do id, dodaje do currentId
                if(checkIfGoodId(c)){
                    currentId+=c;
                }
                //znak nie pasujacy do id np % =
                else{
                    //jezeli = to zaczynamy tworzenie drugiego id
                    if(c=='='){
                        if(id1.length()!=0){
                            output += currentId+"=";
                        }
                        else{
                            id1=currentId;
                        }
                        creatingId=false;
                        currentId="";
                    }
                    //jezeli znak niepasujacy i nie = podczas tworzenia id
                    else{
                        //poprawne id bo stworzylismy id1 i jestesmy w trakcie tworzenia drugiego id
                        if(id1.length()!=0){
                            output+=currentId+"="+id1;
                            id1="";
                        }
                        //nie stworzylismy id1 wiec nie mamy z czym zamieniac
                        else{
                            output += currentId;
                        }
                        creatingId=false;
                        currentId="";

                        //np poprawneId1=poprawneid2_kolejneId
                        if(c=='_'){
                            creatingId=true;
                            currentId+=c;
                        }
                        else{
                            output+=c;
                        }
                    }
                }
            }
        }

        //zakonczenie petli podczas tworzenia id
        if(creatingId){
            if(id1.length()!=0 && currentId.length()!=0){
                output+=currentId+"="+id1;
            }
            else{
                output+=currentId;
            }
        }
        else if( id1.length()!=0){
            output+=id1+"=";
        }
        return output;
    }
}
