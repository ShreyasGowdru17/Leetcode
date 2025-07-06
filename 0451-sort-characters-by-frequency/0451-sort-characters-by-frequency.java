class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map=s.chars()
                        .mapToObj(c->(char)c)
                        .collect(Collectors.groupingBy(c->c,Collectors.summingInt(c->1)));
        
        String answer=map.entrySet()
                            .stream()
                            .sorted((e1,e2)-> e2.getValue()-e1.getValue())
                            .map(e-> String.valueOf(e.getKey()).repeat(e.getValue()))
                            .collect(Collectors.joining());
        
        return answer;
    }
}