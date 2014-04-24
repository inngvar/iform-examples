package org.iforum.exmaples;

import java.util.HashMap;
import java.util.Map;

/**
 * —ервис занимаетс€ преобразованием чисел от 0 до 9 в строковое представление
 * 
 * @author igor.ch
 * 
 */
public class NumberConverter {

	/**
	 * —одержит правила соотсветсви€ чисел - строковым значени€м.
	 */
	private final Map<Integer, String> convertData;

	/**
	 *  онструктор. »нициализаци€ данных.
	 */
	public NumberConverter() {
		convertData = new HashMap<Integer, String>();
		convertData.put(0, "ноль");
		convertData.put(1, "один");
		convertData.put(2, "два");
		convertData.put(3, "три");
		convertData.put(4, "четыре");
		convertData.put(5, "п€ть");
		convertData.put(6, "шесть");
		convertData.put(7, "семь");
		convertData.put(8, "восемь");
		convertData.put(9, "дев€ть");
	}

	/**
	 * ѕеробразует число в строковое представление.
	 * 
	 * @param number
	 *            „исло которое будет преобразованно( принимаютс€ значени€ от 0
	 *            до 9)
	 * @return —троковое представление числа( 0- ноль, 1- один и.т.п.)
	 * @throws Exception
	 *             ¬озникает случае если number меньше нул€ или больше дев€ти.
	 */
	public String getStringValue(int number) throws Exception {
		String result = convertData.get(number);
		if (result == null) {
			throw new Exception(String.format(TestSampleMessage.NOT_VALID_NUMBER, number));
		}
		return result;
	}

}
