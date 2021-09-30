

# 영속성 관리 - 내부 동작 방식
## 엔티티의 생명 주기
### - 비영속
영속성 컨텍스트와 전혀 관계가 없는 상태

![image](https://user-images.githubusercontent.com/64236372/135511652-cbe98308-eb2e-4f86-8269-7c6daf0ab749.png)

위와 같이 셋팅만 한 상태이며
JPA랑 전혀 관계없고 비영속 상태이다

### - 영속
EntityManager를 가져와서 EntityManager persist에 member을 집어 넣으면
EntityManager에 있는 영속성 컨텍스트안에 멤버객체가 들어가게 되면서 영속상태가 되는 것이다.

![image](https://user-images.githubusercontent.com/64236372/135513284-29076c78-8d30-4484-986c-0f0b5b86654d.png)

영속상태가 된다고 db에 바로 쿼리가 날라가는게 아니다.
트랜잭션 커밋하는 시점에 영속성 컨텍스트에 있는애가 디비에 쿼리에 날라가기 때문이다.

### - 준영속

![image](https://user-images.githubusercontent.com/64236372/135513989-528632c3-a3f7-403d-9795-bb06c2154d5a.png)

### - 삭제

![image](https://user-images.githubusercontent.com/64236372/135514025-9cf7d100-2380-41ba-b39c-f1123d2055f0.png)

remove는 실제 디비삭제를 요청하는 상태 
실제 db에서 지우는 것이다.
