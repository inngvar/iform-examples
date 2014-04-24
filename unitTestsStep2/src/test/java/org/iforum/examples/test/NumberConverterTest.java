package org.iforum.examples.test;

import org.iforum.exmaples.NumberConverter;
import org.iforum.exmaples.TestSampleMessage;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * ������������ ������ NumberConverter
 * 
 * @author igor.ch
 * 
 */
public class NumberConverterTest {

	/**
	 * Number ��������� ������� ������������ ��� ������.
	 */
	private NumberConverter converter = new NumberConverter();

	/**
	 * ������� ������������ ����������, ����������� ������� ���������� ������.
	 * �� ��������� ������ �� ���������
	 */
	@Rule
	public ExpectedException exception = ExpectedException.none();

	/**
	 * ���� ������ getStringValue() � ��������� ����������.
	 * 
	 * @throws Exception
	 */
	@Test
	public void getStringValueTest() throws Exception {
		assertValue(0, "����");
		assertValue(1, "����");
		assertValue(2, "���");
		assertValue(3, "���");
		assertValue(4, "������");
		assertValue(5, "����");
		assertValue(6, "�����");
		assertValue(7, "����");
		assertValue(8, "������");
		assertValue(9, "������");
	}

	/**
	 * ���� ������ getStringValue() �� ���������� ���������� �� ����� ���������
	 * ���������.
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
	 * ��������������� �����, ��������� ��������� ������������ �������������
	 * ������� getStringValue ���������
	 * 
	 * @param inValue
	 *            �������� ������ ������ getStringValue
	 * @param expected
	 *            ������� ��������� ���������� ������.
	 */
	private void assertValue(int inValue, String expected) throws Exception {
		String stringValue = converter.getStringValue(inValue);
		Assert.assertEquals(expected, stringValue);
	}

}
