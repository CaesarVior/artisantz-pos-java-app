package views;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame {

    private JTable categoryTable;
    private JTable menuTable;

    public MainFrame() {
        setTitle("Artisantz POS");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Tabel Kategori Menu
        JLabel categoryLabel = new JLabel("Kategori Menu");
        String[] categoryColumns = {"ID", "Nama Kategori", "Keterangan"};
        Object[][] categoryData = {
            {"K01", "Kopi", "Minuman kopi"},
            {"K02", "Non-Kopi", "Minuman non kopi"},
            {"K03", "Makanan", "Makanan berat"},
            {"K04", "Snack", "Makanan ringan"}
        };
        categoryTable = new JTable(new DefaultTableModel(categoryData, categoryColumns));
        JScrollPane categoryScroll = new JScrollPane(categoryTable);

        // Tabel Menu
        JLabel menuLabel = new JLabel("Daftar Menu");
        String[] menuColumns = {"ID", "Nama Menu", "Kategori", "Harga", "Status"};
        Object[][] menuData = {
            {"M01", "Americano", "Kopi", "22000", "Tersedia"},
            {"M02", "Caffe Latte", "Kopi", "28000", "Tersedia"},
            {"M03", "Matcha Latte", "Non-Kopi", "30000", "Tersedia"},
            {"M04", "Nasi Goreng", "Makanan", "35000", "Tersedia"},
            {"M05", "Croissant", "Snack", "20000", "Habis"}
        };
        menuTable = new JTable(new DefaultTableModel(menuData, menuColumns));
        JScrollPane menuScroll = new JScrollPane(menuTable);

        mainPanel.add(categoryLabel);
        mainPanel.add(categoryScroll);
        mainPanel.add(menuLabel);
        mainPanel.add(menuScroll);

        setContentPane(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
