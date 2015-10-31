/*
 * Copyright (c) Einsights Pte. Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 */

package com.anhvurz90.java8.tutorialspoint.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornTest {

    public static void main(String[] args) {
        // Console option: jjs sample.js
        // jjs -- a b c. To get a, b, c: arguments.
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
        String name = "Mahesh";

        Integer result = null;
        try {
            nashorn.eval("print('" + name + "');");
            result = (Integer) nashorn.eval("10 + 2");
        } catch (ScriptException e) {
            System.out.println("Error executing script: " + e);
        }

        System.out.println(result);
    }
}
