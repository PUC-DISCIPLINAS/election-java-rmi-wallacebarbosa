package Utils;

import java.text.Normalizer;

public class StringUtils {
	  public static String accentsTidy(String r){
		    r = r.toLowerCase();
		    return Normalizer
					.normalize(r, Normalizer.Form.NFD)
					.replaceAll("[^\\p{ASCII}]", "");
		};
}
