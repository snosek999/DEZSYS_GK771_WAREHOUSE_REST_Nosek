package tradearea.warehouse;

import tradearea.model.WarehouseData;
import tradearea.model.WarehouseProducts;

public class WarehouseSimulation {
	
	private double getRandomDouble( int inMinimum, int inMaximum ) {

		double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum; 
		double rounded = Math.round(number * 100.0) / 100.0; 
		return rounded;
		
	}

	private int getRandomInt( int inMinimum, int inMaximum ) {

		double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum; 
		Long rounded = Math.round(number); 
		return rounded.intValue();

	}

	public WarehouseData getData( String inID ) {
		
		WarehouseData data = new WarehouseData();
		data.setWarehouseID( inID );
		data.setWarehouseName( "Linz Bahnhof" );
        data.setWarehouseAddress("Bahnhofsstrasse 27/9");
        data.setWarehousePostalCode("1020");
        data.setWarehouseCity( "linz" );
        data.setWarehouseCountry( "Austria" );
        data.setTimestamp("2021-09-12 08:52:39.077");

        data.addWarehouseProducts(new WarehouseProducts("00-443175", "Bio Orangensaft Sonne", "Getraenk", "2500", "Packung 1L"));
        data.addWarehouseProducts(new WarehouseProducts("00-871895", "Bio Apfelsaft Gold", "Getraenk", "3420", "Packung 1L"));
        data.addWarehouseProducts(new WarehouseProducts("01-92688", "Ariel Waschmittel Color", "Waschmittel", "478", "Packung 3KG"));
        data.addWarehouseProducts(new WarehouseProducts("00-316253", "Persil Discs Color", "Waschmittel", "1430", "Packung 700G"));

        return data;
    }
}
