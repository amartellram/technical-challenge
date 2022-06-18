import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

    System.out.println("Test 1");
    List<String> stringsTest1 = List.of("abaccadcc", "xyzxy");
    manipulateStrings(stringsTest1);

    System.out.println("Test 2");
    List<String> stringsTest2 = List.of("dulgvgzwqg", "gxtjtmtywr", "hnlnxiupgt", "gzjotckivp",
        "dpwwsdptae", "pcscpilknb", "btvyhhmflf", "artrtnqxcr", "nrtcmcoadn", "fkdsgnekft");
    manipulateStrings(stringsTest2);

    System.out.println("Test 3");
    List<String> stringsTest3 = List.of("wzenwebuau", "vokfxzynwl", "neldfeyrxk", "wqadfiodgs",
        "ykiuvzfcbc");
    manipulateStrings(stringsTest3);

    System.out.println("Test 4");
    List<String> stringsTest4 = List.of("qakmc", "rrtbk", "vaixn", "wmpnj", "uproi", "btsqa",
        "ejqwr", "elwlg", "oaoiy", "hrqkn");
    manipulateStrings(stringsTest4);

    System.out.println("Test 5");
    List<String> stringsTest5 = List.of("pzjim", "njnfq", "xyohs");
    manipulateStrings(stringsTest5);

    System.out.println("Test 6");
    List<String> stringsTest6 = List.of("xqycs", "beoax", "afkso", "bldit", "gwrys");
    manipulateStrings(stringsTest6);

  }

  public static void manipulateStrings(List<String> strings) {
    for (String s : strings) {
      System.out.println(manipulate(s));
    }
  }

  public static String manipulate(String s) {

    //count frequency of each character and store in a map
    Map<Character, Integer> frequencyMap = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (frequencyMap.containsKey(c)) {
        int occurrences = frequencyMap.get(c) + 1;
        frequencyMap.put(c, occurrences);
      } else {
        frequencyMap.put(c, 1);
      }
    }

    // sort the values by occurrences and characters
    frequencyMap = frequencyMap.entrySet()
        .stream()
        .sorted((e1, e2) -> {

          // decision 1 -> compare by frequency from high to low
          int compareByFrequency = e2.getValue()
              .compareTo(e1.getValue());
          if (compareByFrequency != 0) {
            return compareByFrequency;
          }

          // decision 2 -> compare by character in alphabetical order
          return e1.getKey().compareTo(e2.getKey());
        })
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
            LinkedHashMap::new));

    //process the sorted map to build the new string
    StringBuilder sb = new StringBuilder();
    for (Entry<Character, Integer> entry : frequencyMap.entrySet()) {

      char c = entry.getKey();
      int frequency = entry.getValue();

      // repeat and add each character by frequency
      for (int i = 0; i < frequency; i++) {
        sb.append(String.valueOf(c));
      }

    }
    return sb.toString();
  }


}
