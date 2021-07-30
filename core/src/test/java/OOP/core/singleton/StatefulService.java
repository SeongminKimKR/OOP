package OOP.core.singleton;

public class StatefulService {


    //값을 변경할 수 있는 필드가 있으면 안됨
    //가급적 읽기만 가능 해야됨
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;
    }



}
