// Note : This is a very slow implementation of substring search

// Have to optimize this ! 

public class SubstringSearch {

    private static int indexOf(String par, String sub) {
        if (par == null || sub == null || par.length() == 0 || sub.length() == 0 || sub.length() > par.length()) {
            return -1;
        }
                                                                                                                                                                                                                     
        int first = -1;
        int s = 0;
        for (int p=0; p < par.length() && s < sub.length() ; p++ ) {
            if (sub.charAt(s) == par.charAt(p)) {
                if (first == -1) {
                    first = p                                                                                                                                                                   
                }
                s++;                                                                                                          
            } else {
                if (first != -1) {
                    p = p - first;
                    first = -1;
                    s = 0;
                }
            }

        }
        if (s == sub.length() && first != -1) {
            return first;
        }
        return -1;
    }

    public static void main(String[] args) {
        int index = indexOf("xaabdx", "abc");
        if (index != -1) {
            System.out.println("Found the substring at index: " + index);
        } else {
            System.out.println("Did not find substring in the parent string!");
        }
    }
}

