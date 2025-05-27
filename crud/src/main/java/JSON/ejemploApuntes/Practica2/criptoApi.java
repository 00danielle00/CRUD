package JSON.ejemploApuntes.Practica2;

import EjemploApis.Chistes;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class criptoApi {
    public static void main(String[] args) {
        try {

            String apiUrl = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin,ethereum&vs_currencies=usd,eur";

            URL url = new URL(apiUrl);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                json.append(line);
            }
            in.close();

            Gson gson = new Gson();
            Criptomoneda.Root criptomoneda = gson.fromJson(json.toString(), Criptomoneda.Root.class);

            System.out.println("Criptomoneda Bitcoin:");
            System.out.println("EUR €: "+criptomoneda.bitcoin.eur);
            System.out.println("USD $: "+criptomoneda.bitcoin.usd);
            System.out.println();
            System.out.println("Criptomoneda Ethereum:");
            System.out.println("EUR €: "+criptomoneda.ethereum.eur);
            System.out.println("USD $: "+criptomoneda.ethereum.usd);

        } catch(Exception e) {
            System.out.println("Algo ha ido mal.");
            e.printStackTrace();
        }
    }
}
