package com.educandoweb.course.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code; //codigo do tipo enumerado
	
	//construtor para o tipo enumerado
	private OrderStatus(int code) {
		this.code = code;
	}
	
	//método public para acessar este código
	public int getCode() {
		return code;
	}
	
	//método estático para converter um valor numérico para um tipo enumerado
	public static OrderStatus valueOf(int code) { //static pq vai funcionar sem precisar instanciar
		
		for (OrderStatus value : OrderStatus.values()) { //percorrendo todos os possiveis valor de OrderStatus
			if (value.getCode() ==  code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}	
}
