/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        boolean eof = false;
        int total = 0;
        char[] red4 = new char[4];
        
        while(!eof){
            int count = read4(red4);
            
            eof = count != 4;
            
            
            //true count, we could reach the limit n first before eof
            count = Math.min(count, n-total);
            
            for(int i = 0; i < count; i++){
                buf[total++] = red4[i];
            }
        }
        
        return total;
    }
}

/*
want to populate buf with up to n chars

int read4(char[])
returns number of chars read(up to 4) and populates char[] with that number of element;

*/