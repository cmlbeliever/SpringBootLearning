package com.cml.springboot.spel;

import org.eclipse.jdt.internal.compiler.ast.ExpressionContext;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpelTest {
	@Test
	public void testSpel() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression ex = parser.parseExpression("1==1");
		System.out.println("ex:" + ex.getExpressionString());
		System.out.println("ev:" + ex.getValue(Boolean.class));
	}

	@Test
	public void testSpenlWithParam() {
		ExpressionParser parser = new SpelExpressionParser();
		EvaluationContext context = new StandardEvaluationContext();
		context.setVariable("name", " am name ");
		context.setVariable("pass", " this is pass ");
		// SpEL引入了Groovy的安全导航运算符，比如此处根对象为null，所以如果访问其属性时肯定抛出空指针异常，而采用“?.”安全访问导航运算符将不抛空指针异常，而是简单的返回null。
		Expression ex = parser.parseExpression("#name + #pass +#this+' root is ' + #root?.#name");
		System.out.println("ex:" + ex.getExpressionString());
		System.out.println("ev:" + ex.getValue(context, String.class));
	}
}
