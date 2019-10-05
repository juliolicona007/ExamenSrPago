package com.prueba.julio.service.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.julio.dao.InfoRQDao;
import com.prueba.julio.model.InfoRQ;
import com.prueba.julio.service.InfoRQService;

@Service
public class InfoRQServiceImpl implements InfoRQService {

	@Autowired
	private InfoRQDao dao;

	public InfoRQDao getDao() {
		return dao;
	}

	public void setDao(InfoRQDao dao) {
		this.dao = dao;
	}
	
	@Override
	public List<InfoRQ> findAll() {
		return dao.findAll();
	}
	
	@Override
	public InfoRQ save(InfoRQ info) throws IOException, ParseException{
		String gasStationInfo = getGasStationInfo();
		if(gasStationInfo != null) {
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject)parser.parse(gasStationInfo);
			JSONArray jsonResults = (JSONArray)jsonObj.get("results");
			for(int i=0; i < jsonResults.size(); i++) {
				JSONObject jsonGasInfo = (JSONObject) jsonResults.get(i);
				String gasId = (String)jsonGasInfo.get("_id");
				if(info.getGasStation().equals(gasId)) {
					info.setGasStationAddr((String)jsonGasInfo.get("calle"));
					info.setGasStationZp((String)jsonGasInfo.get("codigopostal"));
					info.setGasStationName((String)jsonGasInfo.get("razonsocial"));
					info.setGasStationPermNum((String)jsonGasInfo.get("numeropermiso"));
					info.setGasStationRfc((String)jsonGasInfo.get("rfc"));
					String priceRegular = (String)jsonGasInfo.get("regular");
					if(!priceRegular.isEmpty()) {
						info.setPriceRegular(Double.valueOf(priceRegular));
					}
					String pricePremium = (String)jsonGasInfo.get("premium");
					if(!pricePremium.isEmpty()) {
						info.setPricePremium(Double.valueOf(pricePremium));
					}
					String priceDiesel = (String)jsonGasInfo.get("dieasel");
					if(!priceDiesel.isEmpty()) {
						info.setPriceDiesel(Double.valueOf(priceDiesel));
					}
					Double liters = 0.0;
					switch(info.getGasType()) {
						case 1:
							if(!priceRegular.isEmpty()) {
								liters = info.getAmount() / info.getPriceRegular();
							}
							break;
						case 2:
							if(!pricePremium.isEmpty()) {
								liters = info.getAmount() / info.getPricePremium();
							}
							break;
						case 3:
							if(!priceDiesel.isEmpty()) {
								liters = info.getAmount() / info.getPriceDiesel();
							}
							break;
						default:
							break;
					}
					info.setLiters(liters);
					break;
				}
			}
		}
		return dao.save(info);
	}

	private String getGasStationInfo() throws IOException {
		URL url = new URL("https://api.datos.gob.mx/v1/precio.gasolina.publico");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		int responseCode = conn.getResponseCode();
		if(responseCode == 200) {
			StringBuilder sb = new StringBuilder();
			Scanner sc = new Scanner(url.openStream());
			while(sc.hasNext()) {
				sb.append(sc.nextLine());
			}
			sc.close();
			return sb.toString();
		}
		return null;
	}
	
}
