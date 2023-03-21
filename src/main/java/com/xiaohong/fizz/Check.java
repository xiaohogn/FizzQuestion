package com.xiaohong.fizz;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Description:
 * @Author: yjh195819
 * @Date: 2023/3/21
 */

@FunctionalInterface
public interface Check {
    String check(String cur, int args, AtomicBoolean continuee);

    default Check andThen(Check after) {
        return (str, i, flag) -> {
            String tmpStr = check(str, i, flag);
            if(after!=null){
                return after.check(tmpStr, i, flag);
            }
            return str;
        };
    }

}
