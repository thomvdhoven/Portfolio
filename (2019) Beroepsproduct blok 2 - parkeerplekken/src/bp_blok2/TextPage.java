package bp_blok2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import javafx.scene.layout.Pane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class TextPage extends Pane {

    private final String JSONURL = "https://services7.arcgis.com/21GdwfcLrnTpiju8/arcgis/rest/services/Sierende_elementen/FeatureServer/0/query?where=1%3D1&outFields=*&outSR=4326&f=json";

    JSONObject jo = new JSONObject();

    public TextPage(Pane root) {

        JSONArray ja = new JSONArray();

        try {
            JSONObject result = readUrl(JSONURL);
            JSONArray features = (JSONArray) result.get("features");

            for (Object o : features) {
                JSONObject jsonobject = (JSONObject) o;
                JSONObject attributes = (JSONObject) jsonobject.get("attributes");
                String kunstenaar = checkValue(attributes, "KUNSTENAAR");
                System.out.println(kunstenaar);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String checkValue(JSONObject jo, String attribute) {
        String waarde = "";
        try {
            if (jo.get(attribute).toString() != null) {
                waarde = jo.get(attribute).toString();
            }
        } catch (Exception e) {
        }
        return waarde;
    }

    private JSONObject readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        String data = "";
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/xml");
            BufferedReader br
                    = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            data = br.readLine();
            connection.disconnect();
            jo = (JSONObject) JSONValue.parseWithException(data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jo;
    }
}
