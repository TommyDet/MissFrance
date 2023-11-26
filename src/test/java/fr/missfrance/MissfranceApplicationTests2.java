package fr.missfrance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


class A {

    public void print() {
        System.out.println("class A");
    }

}

class B extends A {
    public void print() {
        System.out.println("class B");
    }
}

@ExtendWith(MockitoExtension.class)
class MissfranceApplicationTests2 {


    @Test
    public void main() {
        B b = new B();
        b.print();
    }
}

