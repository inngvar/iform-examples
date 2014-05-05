package org.iforum.examples.test;

import org.iforum.exmaples.NumberConverter;
import org.iforum.exmaples.TestSampleMessage;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Тестирование класса NumberConverter
 * 
 * @author igor.ch
 * 
 */
public class NumberConverterTest {

	/**
	 * Number конвертер который используется для тестов.
	 */
	private NumberConverter converter = new NumberConverter();

	/**
	 * Правило отслеживание исключений, возникающих вовремя выполнения тестов.
	 * По умолчанию ошибок не ожидается
	 */
	@Rule
	public ExpectedException exception = ExpectedException.none();

	/**
	 * Тест метода getStringValue() с валидными значениями.
	 * 
	 * @throws Exception
	 */
	@Test
	public void getStringValueTest() throws Exception {
		assertValue(0, "ноль");
		assertValue(1, "один");
		assertValue(2, "два");
		assertValue(3, "три");
		assertValue(4, "четыре");
		assertValue(5, "пять");
		assertValue(6, "шесть");
		assertValue(7, "семь");
		assertValue(8, "восемь");
		assertValue(9, "девять");
	}

	/**
	 * Тест метода getStringValue() со значениями выходящими за рамки диопазона
	 * ожидаемых.
	 * 
	 */
	@Test
	public void testUnexpectedValues() throws Exception {
		int testNumber = 42;
		exception.expect(Exception.class);
		exception.expectMessage(String.format(TestSampleMessage.NOT_VALID_NUMBER, testNumber));
		assertValue(testNumber, null);
	}

	/**
	 * Вспомогательный метод, позволяет проверить правильность возвращаемого
	 * методом getStringValue занечения
	 * 
	 * @param inValue
	 *            Параметр вызова метода getStringValue
	 * @param expected
	 *            Ожидаем результат исполнения метода.
	 */
	private void assertValue(int inValue, String expected) throws Exception {
		String stringValue = converter.getStringValue(inValue);
		Assert.assertEquals(expected, stringValue);
	}

}
