public class MainApp {
    public static void main(String[] args) {
        if (Admin.login()) {
            Admin.menu();
        } else {
            System.out.println("Gagal login");
        }
    }
}
    
