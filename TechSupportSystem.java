import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TechSupportSystem {
    // Database sederhana untuk menyimpan respons berdasarkan kata kunci
    private Map<String, String> responses;

    public TechSupportSystem() {
        responses = new HashMap<>();
        initializeResponses();
    }

    // Memetakan kata kunci dengan respon yang sesuai
    private void initializeResponses() {
        responses.put("harga", "Harga sate ayam adalah Rp20.000 per porsi, dan sate kambing Rp25.000 per porsi.");
        responses.put("menu", "Kami menawarkan berbagai menu sate: sate ayam, sate kambing, sate campur, dan sate kulit.");
        responses.put("jam buka", "Kami buka setiap hari dari jam 10 pagi hingga 10 malam.");
        responses.put("alamat", "Kami berlokasi di Jalan Sate No. 123, Surabaya.");
        responses.put("pesan", "Anda bisa memesan melalui aplikasi pesan antar, atau langsung menghubungi kami di nomor 081234567890.");
    }

    // Method untuk mendapatkan respons berdasarkan kata kunci
    public String getResponse(String userInput) {
        userInput = userInput.toLowerCase();
        for (String keyword : responses.keySet()) {
            if (userInput.contains(keyword)) {
                return responses.get(keyword);
            }
        }
        return "Maaf, kami tidak mengerti pertanyaan Anda. Silakan tanyakan hal lain.";
    }

    public static void main(String[] args) {
        TechSupportSystem supportSystem = new TechSupportSystem();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Selamat datang di Sistem Dukungan Penjualan Sate! Ketik 'exit' untuk keluar.");

        while (true) {
            System.out.print("Anda: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Terima kasih telah menghubungi kami! Sampai jumpa.");
                break;
            }

            String response = supportSystem.getResponse(userInput);
            System.out.println("Dukungan: " + response);
        }
        
        scanner.close();
    }
}
