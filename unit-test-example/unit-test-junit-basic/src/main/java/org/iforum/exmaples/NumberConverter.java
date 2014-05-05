package org.iforum.exmaples;

import java.util.HashMap;
import java.util.Map;

/**
 * ������ ���������� ��������������� ����� �� 0 �� 9 � ��������� �������������
 * 
 * @author igor.ch
 * 
 */
public class NumberConverter {

	/**
	 * �������� ������� ������������ ����� - ��������� ���������.
	 */
	private final Map<Integer, String> convertData;

	/**
	 * �����������. ������������� ������.
	 */
	public NumberConverter() {
		convertData = new HashMap<Integer, String>();
		convertData.put(0, "����");
		convertData.put(1, "����");
		convertData.put(2, "���");
		convertData.put(3, "���");
		convertData.put(4, "������");
		convertData.put(5, "����");
		convertData.put(6, "�����");
		convertData.put(7, "����");
		convertData.put(8, "������");
		convertData.put(9, "������");
	}

	/**
	 * ����������� ����� � ��������� �������������.
	 * 
	 * @param number
	 *            ����� ������� ����� ��������������( ����������� �������� �� 0
	 *            �� 9)
	 * @return ��������� ������������� �����( 0- ����, 1- ���� �.�.�.)
	 * @throws Exception
	 *             ��������� ������ ���� number ������ ���� ��� ������ ������.
	 */
	public String getStringValue(int number) throws Exception {
		String result = convertData.get(number);
		if (result == null) {
			throw new Exception(String.format(TestSampleMessage.NOT_VALID_NUMBER, number));
		}
		return result;
	}

}
