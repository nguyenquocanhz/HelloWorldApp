//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
     NetworkHelper networkHelper = new NetworkHelper();

     // Bai Tap 5
     String[] hostName = {"facebook.com","google.com","zalo.me"};
    for (int i = 0; i < hostName.length; i++) {
        networkHelper.setHostName(hostName[i]);
        networkHelper.GetIpFromDomain();
    }

}