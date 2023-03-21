package com.xiaohong.fizz;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Description:
 * @Author: xiaohong
 * @Date: 2023/3/21
 */
public class Main {

    public String say(int arg) {
        String curStr = "";
        //规则1
        Check checkDefault = (str, i, flag) -> str.length() > 0 ? str : String.valueOf(i);
        //规则2
        Check checkMulti3 = (str, i, flag) -> flag.get() ? str : (i % 3 == 0 ? str + "Fizz" : str);
        Check checkMulti5 = (str, i, flag) -> flag.get() ? str : (i % 5 == 0 ? str + "Buzz" : str);
        Check checkMulti7 = (str, i, flag) -> flag.get() ? str : (i % 7 == 0 ? str + "Whizz" : str);
        //规则3
        Check checkMulti = checkMulti3.andThen(checkMulti5).andThen(checkMulti7);

        Check checkContains3 = (str, i, flag) -> {
            if (flag.get()) {
                return str;
            }
            if (containsNum(i, 3)) {
                str = "Fizz";
                flag.set(true);
            }
            return str;
        };
        //规则7
        if (containsNum(arg, 7)) {
            return checkContains3
                    .andThen(checkMulti3)
                    .andThen(checkMulti7)
                    .check(curStr, arg, new AtomicBoolean(false));
        }
        //规则6
        if (containsNum(arg, 5)) {
            return checkMulti5
                    .andThen(checkMulti7)
                    .check(curStr, arg, new AtomicBoolean(false));
        }

        //规则4 5 似乎 是一个诶
        if (containsNum(arg, 3)) {
            return "Fizz";
        }

        //default
        return checkMulti
                .andThen(checkDefault)
                .check(curStr, arg, new AtomicBoolean(false));
    }

    //这里也可以搞正则，，但实际差不多吧。。
    boolean containsNum(int num, int targetNum) {
        String numstr = String.valueOf(num);
        return numstr.contains(String.valueOf(targetNum));
    }

}