package com.revature;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ItemTableAccessor c = new ItemTableAccessor();
        System.out.println(c.selectItemById(4));


        // Item banana = new Item("banana", 1.24);
        // ItemTableAccessor b = new ItemTableAccessor();
        // b.addItem(banana);
    }
}
