package com.xiaohong.fizz;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

/**
 * @Description:
 * @Author: yjh195819
 * @Date: 2023/3/22
 */
public class FizzTest {

    @Test
    public void test01() {
        Main main = new Main();
        String say = main.say(2);
        assertEquals("2", say);
    }

    @Test
    public void test02() {
        Main main = new Main();
        String say = main.say(3);
        assertEquals("Fizz", say);
    }

    @Test
    public void test03() {
        Main main = new Main();
        String say = main.say(5);
        assertEquals("Buzz", say);
    }

    @Test
    public void test04() {
        Main main = new Main();
        String say = main.say(7);
        assertEquals("Whizz", say);
    }

    @Test
    public void test05() {
        Main main = new Main();
        String say = main.say(15);
        assertEquals("Buzz", say);
    }

    @Test
    public void test06() {
        Main main = new Main();
        String say = main.say(21);
        assertEquals("FizzWhizz", say);
    }

    @Test
    public void test07() {
        Main main = new Main();
        String say = main.say(70);
        assertEquals("Whizz", say);
    }

    @Test
    public void test08() {
        Main main = new Main();
        String say = main.say(105);
        assertEquals("BuzzWhizz", say);
    }

    @Test
    public void test09() {
        Main main = new Main();
        String say = main.say(35);
        assertEquals("BuzzWhizz", say);
    }
}