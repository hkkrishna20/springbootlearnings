package com.test;
public class StaticTest
{
     /* See below - I have marked the constructor as static */
     public StaticTest()
     {
         System.out.println("Static Constructor of the class");
     }
     public static void main(String args[])
     {
         /*Below: I'm trying to create an object of the class
          *that should invoke the constructor
          */
         StaticTest obj = new StaticTest();
     }
}