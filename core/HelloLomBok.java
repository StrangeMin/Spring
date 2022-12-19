package hello.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLomBok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLomBok helloLomBok = new HelloLomBok();
        helloLomBok.setAge(2);
        System.out.println(helloLomBok.getAge());
    }
}
