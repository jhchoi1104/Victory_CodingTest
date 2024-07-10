import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르별 총합 구하기
        HashMap<String, Integer> totalGenres = new HashMap<>();
        for (int i=0;i<genres.length;i++) {
            totalGenres.put(genres[i],totalGenres.getOrDefault(genres[i],0)+plays[i]);
        }
        // 2. 장르별 내림차순 정렬
        List<String> sortedGenres = totalGenres.keySet().stream()
            .sorted((g1,g2)-> totalGenres.get(g2).compareTo(totalGenres.get(g1)))
            .collect(Collectors.toList());
        
        // 3. 장르 별 노래 재생수 담기
        // {장르, {고유번호, 재생수}}
        HashMap<String, HashMap<Integer, Integer>> sortedPlay = new HashMap<>();
        for (String genre: sortedGenres) {
            HashMap<Integer, Integer> map = new HashMap<>();
            
            for (int i=0;i<genres.length;i++) {
                if (genres[i].equals(genre)) map.put(i,plays[i]);
            }
            sortedPlay.put(genre,map);
        }
        
        // 4. 장르 내 재생 수에 따른 내림차순 정렬
        List<Integer> album = new ArrayList<>();
        for (String genre:sortedGenres) {
            Map<Integer, Integer> map = sortedPlay.get(genre);
              map.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue() - entry1.getValue())
                .limit(2)
                .forEach(entry -> album.add(entry.getKey()));
        }
        return album.stream().mapToInt(i->i).toArray();
    }
}