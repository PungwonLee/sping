package hello.core.singleton;

public class SingletonService {

    //자기자신을 내부의 프라이빗으로 스태틱으로 가지고있다 클레스 레벨에 올라가기때문에 하나만 존재한다.
    private static final SingletonService instance= new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }
    //private로 다른곳에서 생성을 못한다.
    private SingletonService(){}

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

    public static void main(String[] args) {
        SingletonService singletonService= new SingletonService();
    }
}
