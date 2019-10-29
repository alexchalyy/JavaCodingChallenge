import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WordFrequency {

    private static String[] w = null;
    private static int[] r = null;
    private static String MostUsed = null;

    public void CalculateFrequency() {

    //  This method calculates and displays 10 most frequently used words from a given text file and displays them in sorted order from the most frequently used.

        try {
            int n = 10;
            w = new String[n];
            r = new int[n];
            FileReader fr = new FileReader("passage.txt");
            BufferedReader br = new BufferedReader(fr);
            String text = "";
            String sz = null;
            
            while((sz=br.readLine())!=null){
                text = text.concat(sz);
            }
            String[] words = text.split(" ");
            String[] uniqueLabels;
            int count = 0;
            uniqueLabels = getUniqLabels(words);
            for(int j=0; j<n; j++){
                    r[j] = 0;
                }
            for(String l: uniqueLabels)
            {
                if("".equals(l) || null == l)
                {
                    break;
                }           
                for(String s : words)
                {
                    if(l.equals(s))
                    {
                        count++;
                    }               
                }
    
                for(int i=0; i<n; i++){
                    if(count>r[i]){
                        r[i] = count;
                        w[i] = l;
                        break;
                    }
                }
                count=0;
            }
            display(n);
        } catch (Exception e) {
            System.err.println("ERR "+e.getMessage());
        }
    }
    
//--------------------------------------------------------------------------------

    public static void display(int n){
        for(int k=0; k<n; k++){
            if (k == 0) {
                MostUsed = w[k];
            }
            System.out.println("Label :: "+w[k]+"\tCount :: "+r[k]);
        }
        //System.out.println("Most used word is " + MostUsed);
    }
    
//--------------------------------------------------------------------------------

    private static String[] getUniqLabels(String[] keys)
    {
        String[] uniqueKeys = new String[keys.length];
    
        uniqueKeys[0] = keys[0];
        int uniqueKeyIndex = 1;
        boolean keyAlreadyExists = false;
    
        for(int i=1; i<keys.length ; i++)
        {
            for(int j=0; j<=uniqueKeyIndex; j++)
            {
                if(keys[i].equals(uniqueKeys[j]))
                {
                    keyAlreadyExists = true;
                }
            }           
    
            if(!keyAlreadyExists)
            {
                uniqueKeys[uniqueKeyIndex] = keys[i];
                uniqueKeyIndex++;               
            }
            keyAlreadyExists = false;
        }       
        return uniqueKeys;
    }    
}