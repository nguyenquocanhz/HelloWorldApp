import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

public class NetworkHelper {
    protected InetAddress address;
    public String hostName;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public NetworkHelper(){
        this.hostName = "www.google.com";
    }

    public void GetIpFromDomain(){
        try{
            address = InetAddress.getByName(this.getHostName());
            if (address.isReachable(5000)) {
                ShowMsg(address.getHostName());
                ShowMsg(address.getHostAddress());
            }
            else
                ShowMsg("Website không thể truy cập !");
        }
        catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    public void GetSource(){
        try {
            URL url = new URL("https://" + this.getHostName());;
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = in.readLine()) != null){ // if đọc hết thì in toàn bộ file html ra
                ShowMsg(line);
            }
            in.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void ShowMsg(String msg){
        System.out.println(msg);
    }
}
