package com.study.info;

public class DataInfoTest {
    public static void main(String[] args) throws Exception{
        DataInfo.Student.Address address = DataInfo.Student.Address.newBuilder().setProvince("陕西").setCity("西安").setAddr("灞桥区纺织城34号").build();
        DataInfo.Student student = DataInfo.Student.newBuilder().setAddress(address).setName("张三").setAge(23).setSex(DataInfo.Student.Sex.MAN).build();

        byte[] data = student.toByteArray();

        DataInfo.Student student1 = DataInfo.Student.parseFrom(data);

        System.out.println(student1.getName());
        System.out.println(student1.getSex());
        System.out.println(student1.getAge());
        System.out.println(student1.getAddress().getProvince()+student1.getAddress().getCity()+student1.getAddress().getAddr());
    }
}
