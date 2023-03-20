package org.akademija.six.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Regularni izrazi..
 * <p>
 * IZRAZ      +   String
 * <p>
 * <li>1.  java.util.regex.Pattern REGEX
 * <li>2. java.util.regex.Matcher
 *
 * (?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])
 * </p>
 */
public class RegexDemo {
    public static void main(String[] args) {
        //Program: Definira REGEX izraz
        //Korisnika da unese TEXT koji će biti podvrgnut testiranju da li zadovoljava
        //REGEX izraz  -> ZADOVOLJAVA / NE ZADOVOLJAVA
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Unesi regularni izraz ili PRAVILO: ");
                String regexInput = scanner.nextLine();//ZAKOCENUTI
                Pattern pattern = Pattern.compile(regexInput);
                System.out.println("Unesite tekst kojeg želite testirati:");
                String text = scanner.nextLine();//ZAKOCENUTI
                Matcher matcher = pattern.matcher(text);
                boolean foundIt = false;
                while (matcher.find()){
                    //matcher -> rezultati testiranj text pomoću pattern
                    String dioTekstaKojiPratiPattern = matcher.group();
                    int startIndex = matcher.start();
                    int endIndex = matcher.end();
                    System.out.format("Pronašao sam tekst '%s' na startnoj poziciji '%d' koji završava na poziciji '%d'%n",
                            dioTekstaKojiPratiPattern, startIndex,  endIndex);
                    foundIt = true;
                }
                if(!foundIt){
                    System.out.format("Nema dijela teksta koji zadovoljava uslov. %n");
                }
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
