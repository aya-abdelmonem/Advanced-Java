package strings;

public class Demo {
    public static void main(String[] args) {
        String firstString = "java";
        String secondString = "python";
        String longer = StringUtils.betterString(firstString,secondString,(s1,s2) -> s1.length()>=s2.length());
        System.out.println("in the two strings :"+ firstString +" , "+ secondString+
                "... the longer is : "+ longer);

        String test = "aya95";
        System.out.println(StringUtils.containsOnlyAlphapets(test));
    }
}
