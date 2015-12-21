package Public;

public class StrCount {
	
    public static void main(String[] args) {
        String  a = "[{\"songlist_id\":303873821,\"title\":\"闽南语\",\"desc\":null,\"source\":2,\"type\":3,\"status\":1,\"songs\":[{\"song_id\":1510424},{\"song_id\":1837114},{\"song_id\":2669107},{\"song_id\":2669540},{\"song_id\":3010380},{\"song_id\":1034254},{\"song_id\":1631149}],\"image\":{\"pic\":\"http://3p.pic.ttdtweb.com/3p.ttpod.com/album/250/6/644125.jpg\",\"source\":2},\"owner\":{\"user_id\":203032181,\"identity\":0},\"tags\":[],\"version\":0,\"created_time\":1441885358412,\"last_updated\":1441967681698,\"order\":null}]";
        String  b = "song_id";
        System.out.println(Count(a,b));
  
    }
       
    /**
     * 
     * @param a
     *            被匹配的长字符串
     * @param b
     *            匹配的短字符串
     * @return 匹配次数
     */
    public static int Count(String result, String str) {
        if (result.length() < str.length()) {
            return 0;
        }
        char[] a_t = result.toCharArray();
        char[] b_t = str.toCharArray();
        int count = 0, temp = 0, j = 0;
        for (int i = 0; i < a_t.length; i++) {
            if (a_t[i] == b_t[j] && j < b_t.length) {
                temp++;
                j++;
                if (temp == b_t.length) {
                    count++;
                    temp = 0;
                    j = 0;
                }
            }
            else {
                temp = 0;
                j = 0;
            }
        }
 
        return count;
    }
    
} 
    
    