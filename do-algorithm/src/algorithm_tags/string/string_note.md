# What I Learned?
---
##### Map
###### TreeMap
- TreeMap은 이진트리를 기반으로 한 Map 컬렉션
- TreeMap에 객체를 저장하면, 자동으로 오름차순으로 정렬된다.
- HashMap 보다 성능이 떨어진다.
-  정렬된 상태로 Map을 유지해야 하거나 정렬된 데이터를 조회해야 하는 범위 검색이 필요한 경우 TreeMap을 사용하는 것이 효율성면에서 좋다.
###### Map의 Key와 Value를 사용해야할 때
- __Entry 컬렉션을 사용한다.__
```Java
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    
        }
```
##### Math 관련
###### 소수점 자리 출력
- String.format("%.4f", {double 형 변수});
###### Integer to Double
- {integer 변수} * 100.0