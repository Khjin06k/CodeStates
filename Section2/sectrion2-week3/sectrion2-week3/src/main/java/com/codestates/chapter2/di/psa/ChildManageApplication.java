package com.codestates.chapter2.di.psa;

public class ChildManageApplication {
    public static void main(String[] args) {
        Child newBornBaby = new NewBornBaby();
        Child infant = new Infant();
        Child toddler = new Toddler();

        newBornBaby.sleep();
        infant.sleep();
        toddler.sleep();
    }
}

abstract class Child{ //아이의 일반적인 특징을 추상 클래스로서 작성
    protected String childType;
    protected double height;
    protected double weight;
    protected String bloodType;
    protected int age;

    protected abstract void smile();
    protected abstract void cry();
    protected abstract void sleep();
    protected abstract void eat();
}

//추상 클래스를 가져와 오버라이딩 진행
class NewBornBaby extends Child{
    @Override
    protected void smile() {
        System.out.println("신생아는 가끔 웃어요");
    }

    @Override
    protected void cry() {
        System.out.println("신생아는 가끔 울어요");
    }

    @Override
    protected void eat() {
        System.out.println("신상아는 분유만 먹어요");
    }

    @Override
    protected void sleep() {
        System.out.println("신생아는 거의 하루종일 자요");
    }
}

class Infant extends Child{
    @Override
    protected void sleep() {
        System.out.println("영아부터는 밤에 잠을 자기 시작해요");
    }

    @Override
    protected void eat() {
        System.out.println("영아부터는 이유식을 시작해요");
    }

    @Override
    protected void cry() {
        System.out.println("영아는 종종 울어요");
    }

    @Override
    protected void smile() {
        System.out.println("영아는 많이 웃어요");
    }
}

class Toddler extends Child{
    @Override
    protected void smile() {
        System.out.println("유아는 웃길 때 웃어요");
    }

    @Override
    protected void cry() {
        System.out.println("유아는 화가나면 웃어요");
    }

    @Override
    protected void eat() {
        System.out.println("유아는 딱딱한 걸 먹기 시작해요");
    }

    @Override
    protected void sleep() {
        System.out.println("유아는 낮잠을 건너뛰고 밤잠만 자요");
    }
}
