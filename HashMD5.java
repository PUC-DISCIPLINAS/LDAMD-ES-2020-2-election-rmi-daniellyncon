import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashMD5 {

   public static String generateHString (String electorName) {

      try {
         // Gera o hash MD5 baseado no nome do eleitor
         MessageDigest md = MessageDigest.getInstance("MD5");
         md.update(electorName.getBytes());
         byte[] md5 = md.digest();

         // Formata em Hexadecimal min�sculo para exibir na tela
         BigInteger numMd5 = new BigInteger(1, md5);
         String hashMd5 = String.format("%022x", numMd5); 
         System.out.println("Elector name: " + electorName + "\nMD5: " + hashMd5);
         return hashMd5;

      } catch (NoSuchAlgorithmException e) {

         throw new RuntimeException(e);

      }

   }

}
