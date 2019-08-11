import java.util.*;

public class Main {

    public static void main(String[] args) {

        String line = "SSSWWWWeagbhjnGhB";
        sort(line);
    }

    /**
     * 按字符出现的频次倒序，频次相同的按字母顺序，字母相同的大写在前
     * @param line
     */
    private static void sort(String line) {
        // 计算出每个字符出现的频次
        Map<Character,Integer> countMap = new HashMap<>();
        for(int i = 0;i<line.length();i++){
            char ch = line.charAt(i);
            if(countMap.containsKey(ch)){
                countMap.put(ch,countMap.get(ch)+1);
            }else{
                countMap.put(ch,1);
            }
        }

        // 按规则排序
        List<Map.Entry<Character,Integer>> list = new ArrayList(countMap.entrySet());
        list.sort((o1, o2) -> {
            if(o1.getValue()>o2.getValue()){
                return -1;
            }else if(o1.getValue()<o2.getValue()){
                return 1;
            }else{
                //先按字母顺序，相同字母大写在小写前面
                Character key1 = o1.getKey();
                Character key2 = o2.getKey();
                Character low1 = Character.isLowerCase(key1) ? key1 : Character.toLowerCase(key1);
                Character low2 = Character.isLowerCase(key2) ? key2 : Character.toLowerCase(key2);
                if(low1>low2){
                    return 1;
                }else if(low1<low2){
                    return -1;
                }
                //字母相同的情况
                return key1>key2 ? 1 : -1;
            }

        });

        for(Map.Entry<Character,Integer> entry : list){
            System.out.println(entry.getKey()+">>>"+entry.getValue());
        }
    }
    
}
