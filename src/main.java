import javax.sound.midi.Sequence;

public class main {
    public static String SequenceDP(String word){
        String[] Memory = new String[word.length()+2];
        StringBuilder temp;
        int last;
        for (int i=word.length()-1; i>=0;i-- ){
            temp = new StringBuilder();
            temp.append(word.charAt(i));
            last = i;
            for (int j=i+1; j<word.length(); j++){
                if(word.charAt(last)<word.charAt(j)){
                    if(Memory[j] != null){
                        temp.append(Memory[j]);
                        break;
                    }
                    temp.append(word.charAt(j));
                    last=j;
                }
            }
            Memory[i]=""+temp;
            if(Memory[word.length()]==null ||Memory[word.length()].length() < Memory[i].length()) {
                Memory[word.length()] = Memory[i];
            }else{
                String tempSecond="";
                for (int j=0; j<Memory[word.length()].length();j++){
                    System.out.println("E: "+ word.charAt(i)  +"  F: "+Memory[word.length()].charAt(j));
                    if(word.charAt(i)<Memory[word.length()].charAt(j)){
                        tempSecond=word.charAt(i)+Memory[word.length()].substring(j);
                        break;
                    }
                }
                System.out.println("-------------B: "+ tempSecond +"  A: "+Memory[word.length()]);
                if(Memory[word.length()].length()<=tempSecond.length()){
                    Memory[word.length()] = tempSecond;
                }
            }
        }
        return Memory[word.length()];
    }
   /* public static String SequenceDP(String word){
        String[] Memory = new String[word.length()+2];
        StringBuilder temp;
        int last;
        for (int i=word.length()-1; i>=0;i-- ){
            temp = new StringBuilder();
            temp.append(word.charAt(i));
            last = i;
            for (int j=i+1; j<word.length(); j++){
                if(word.charAt(last)<word.charAt(j)){
                    if(Memory[j] != null){
                        temp.append(Memory[j]);
                        break;
                    }
                    temp.append(word.charAt(j));
                    last=j;
                }
            }
            Memory[i]=""+temp;
            if(Memory[word.length()]==null ||Memory[word.length()].length() < Memory[i].length()) {
                if(Memory[word.length() + 1]!=null&&!Memory[word.length() + 1].equals(Memory[word.length()]))
                    Memory[word.length()+1] = Memory[word.length()];

                    Memory[word.length()] = Memory[i];
            }else{
                if(Memory[word.length()+1]==null || (Memory[word.length()+1].length()<Memory[i].length())){
                    Memory[word.length()+1] = Memory[i];
                }
            }
            if(Memory[word.length() + 1]!=null) {
                if (word.charAt(i) < Memory[word.length() + 1].charAt(0))
                    Memory[word.length() + 1] = word.charAt(i) + Memory[word.length() + 1];
                if (word.charAt(i) < Memory[word.length()].charAt(0))
                    Memory[word.length()] = word.charAt(i) + Memory[word.length()];
                if (Memory[word.length()].length() < Memory[word.length() + 1].length()) {
                    String shift = Memory[word.length()];
                    Memory[word.length()] = Memory[word.length() + 1];
                    Memory[word.length() + 1] = shift;
                }
            }

        }
        return Memory[word.length()];

    }
    */

    public static String DivideConquer(
            String word, int index, int last){

        if(index < word.length()){
            if(index==last){
                String OptionA = word.charAt(index) + DivideConquer(word, index + 1, index);
                String OptionB = DivideConquer(word, index +1, index +1);
                if(OptionA.length()>OptionB.length())
                    return  OptionA;
                else
                    return OptionB;
            }else {
                if (word.charAt(last) < word.charAt(index)) {
                    String OptionA = word.charAt(index) + DivideConquer(word, index + 1, index);
                    String OptionB = DivideConquer(word, index + 2, last);
                    if(OptionA.length()>OptionB.length()){
                        return OptionA;
                    }else
                        if(OptionB.length() != 0 && word.charAt(index)<OptionB.charAt(0))
                            return word.charAt(index)+OptionB;
                        else
                            return OptionB;

                } else {
                    String OptionA = DivideConquer(word, index + 1, last);
                    if(OptionA.length()>0 && word.charAt(last)<OptionA.charAt(0))
                        return OptionA;
                    else
                        return "";
                }
            }
        }else{

            return "";

        }


    }

    public static void main(String[] args) {
        //System.out.println(DivideConquer("abcyzdef", 0, 0));
        System.out.println(SequenceDP("abcyzdef"));
    }
}
