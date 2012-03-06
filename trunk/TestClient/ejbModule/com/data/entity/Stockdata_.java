package com.data.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-03-05T16:17:03.063-0800")
@StaticMetamodel(Stockdata.class)
public class Stockdata_ {
	public static volatile SingularAttribute<Stockdata, StockdataPK> id;
	public static volatile SingularAttribute<Stockdata, Double> close;
	public static volatile SingularAttribute<Stockdata, Double> high;
	public static volatile SingularAttribute<Stockdata, Double> low;
	public static volatile SingularAttribute<Stockdata, Double> open;
	public static volatile SingularAttribute<Stockdata, Integer> volume;
}
