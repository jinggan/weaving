package org.jerrymouse.weaving.sanbox.script;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.junit.Test;

public class GroovyShellTest {
	@Test
	public void testShell() throws Exception {
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("groovy");

		// basic example
		System.out.println(engine.eval("(1..10).sum()"));

		// example showing scripting variables
		engine.put("first", "HELLO");
		engine.put("second", "world");
		System.out.println(engine
				.eval("first.toLowerCase() + second.toUpperCase()"));

		String fact = "def isEnsure(){	true;}";
		engine.eval(fact);
		Invocable inv = (Invocable) engine;
		Object result = inv.invokeFunction("isEnsure");
		System.out.println(result);

	}
}
