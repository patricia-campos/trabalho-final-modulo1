package validadores;

public class Validadores {

    public boolean verificarCaso(int caso) {
        String frase = String.valueOf(caso);

        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (Character.isDigit(c)) {
                System.out.println(c + " é número");
                return true;
            } else if (Character.isLetter(c)) {
                System.out.println(c + " é letra");
                return false;
            } else {
                System.out.println(c + " não é letra nem número");
                return false;
            }
        }
        return false;
    }

}
